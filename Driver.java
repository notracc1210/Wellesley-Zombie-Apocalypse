public class Driver{
    private int hp;
    private int aggressiveness;
    private boolean hasRebirthToken; //acquired from roulette sucess
    private boolean rebirthUsed; //can rebirth once
    private boolean forceZombieNextRoll; //set if roulette fails
    private GameMap map;
    private Position currentPosition;
    private Random rng;
    private static final double CAREER_CENTER_SUCCESS_RATE = 0.10;

    public static void main(String[] args){
        System.out.println("Welleslsey Zombie Apocalypse")
    }

    public Driver(GameMap map, int startingHP){
        this.map = map;
        this.hp = startingHP;
    }

    public int rollDice{

    }

    public void moveTo(Position pos){

    }

    public void choose(Option option){

    }

    public void applyConsequence(Consequence c){

    }

    public boolean isDead(){

    }

    /**
     * revives user if !rebirthUsed and user has token
     * @ return
     */
    public boolean tryRebirth(){

    }

    public int getHP(){

    }

    public int getAggressiveness(){

    }

    public void setAggressiveness(int value){

    }
}
