class Option
{
    String description;
    Consequence consequence;
    
    public Option(String d, Consequence c){
        description = d;
        consequence = c;
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
