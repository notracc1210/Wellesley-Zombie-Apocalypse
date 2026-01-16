import java.util.ArrayList;
import java.util.Random;

public class Option
{
    String description;
    Consequence consequence;
    ArrayList<WeightedConsequence> probabilisticConsequences;
    Random rng = new Random();
    
    // Constructor for simple consequence (no probability)
    public Option(String d, Consequence c){
        description = d;
        consequence = c;
        probabilisticConsequences = new ArrayList<>();
    }
    
    // Constructor for probabilistic consequences
    public Option(String d){
        description = d;
        consequence = null;
        probabilisticConsequences = new ArrayList<>();
    }
    
    // Add a consequence with a probability weight
    public void addProbabilisticConsequence(Consequence c, int weight){
        probabilisticConsequences.add(new WeightedConsequence(c, weight));
    }
    
    // Get a random consequence based on weights
    public Consequence getRandomConsequence(){
        if(probabilisticConsequences.isEmpty()){
            return consequence;
        }
        
        // Calculate total weight
        int totalWeight = 0;
        for(WeightedConsequence wc : probabilisticConsequences){
            totalWeight += wc.weight;
        }
        
        // Roll based on weights
        int roll = rng.nextInt(totalWeight) + 1;
        int current = 0;
        
        for(WeightedConsequence wc : probabilisticConsequences){
            current += wc.weight;
            if(roll <= current){
                return wc.consequence;
            }
        }
        
        return probabilisticConsequences.get(probabilisticConsequences.size() - 1).consequence;
    }

    public int getHPChange(){
        if(consequence != null){
            return consequence.consequence_HP;
        }
        // For probabilistic outcomes, get a random consequence and return its HP change
        Consequence randomConsequence = getRandomConsequence();
        return randomConsequence.consequence_HP;
    }

    public int getAggresivenessChange(){
        if(consequence != null){
            return consequence.consequence_aggresiveness;
        }
        // For probabilistic outcomes, get a random consequence and return its aggressiveness change
        Consequence randomConsequence = getRandomConsequence();
        return randomConsequence.consequence_aggresiveness;
    }

    public String getDescription(){
        return description;
    }

    public Consequence getConsequence(){
        return consequence;
    }
    
    public boolean hasProbabilisticOutcome(){
        return !probabilisticConsequences.isEmpty();
    }
    
    // Inner class for weighted consequences
    public static class WeightedConsequence {
        Consequence consequence;
        int weight;
        
        public WeightedConsequence(Consequence c, int w){
            consequence = c;
            weight = w;
        }
    }
}
