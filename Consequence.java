class Consequence
{
    String description;
    int consequence_HP,consequence_aggresiveness;
    
    public Consequence(String d, int h, int a){
        description = d;
        consequence_HP = h;
        consequence_aggresiveness = a;
    }

    public String getDescription(){
        return description;
    }
}
