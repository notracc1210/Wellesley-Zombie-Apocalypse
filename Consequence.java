public class Consequence
{
    String description;
    int consequence_HP, consequence_aggresiveness;
    boolean causesGameOver;
    boolean grantRebirthToken;
    boolean forceZombieNextRoll;
    boolean isSuccess;
    
    public Consequence(String d, int h, int a){
        description = d;
        consequence_HP = h;
        consequence_aggresiveness = a;
        this.causesGameOver = false;
        this.grantRebirthToken = false;
        this.forceZombieNextRoll = false;
        this.isSuccess = false;
    }

    public Consequence(String d, int h, int a, boolean gameOver, boolean rebirth, boolean forceZombie){
        description = d;
        consequence_HP = h;
        consequence_aggresiveness = a;
        this.causesGameOver = gameOver;
        this.grantRebirthToken = rebirth;
        this.forceZombieNextRoll = forceZombie;
        this.isSuccess = false;
    }

    public String getDescription(){
        return description;
    }
    
    public int getHP(){
        return consequence_HP;
    }
    
    public int getAggressiveness(){
        return consequence_aggresiveness;
    }
    
    public boolean causesGameOver(){
        return causesGameOver;
    }
    
    public boolean grantsRebirthToken(){
        return grantRebirthToken;
    }
    
    public boolean forcesZombieNextRoll(){
        return forceZombieNextRoll;
    }
}
