class Option
{
    String description;
    Consequence consequence;
    double sucessRate;
    Random rand;

    public Option(String d, Consequence c, double sucessRate){
        description = d;
        consequence = c;
        sucessRate = sucessRate;
        rand = new Random;

    }

    public boolean isSuccessful(){
        double result = Math.random() +.01;
        if(result <= sucessRate){
            return true;
        else{
            return false;
        }
        }
    }

    public int getHPChange(){
        return consequence.consequence_HP;
    }

    public int getAggresivenessChange(){
        return consequence.consequence_aggresiveness;
    }

    public Consequence getConsequence(){
        return consequence;
    }
}
