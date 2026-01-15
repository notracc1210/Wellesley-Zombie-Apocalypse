import java.util.Random;

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
        this.rng = new Random();
    }

    public int rollDice{
        int rolledNum = rng.nextInt(6) + 1;
    }

    public void moveTo(Position pos){
        this.currentPosition = pos;
    }

    public void applyConsequence(Consequence c){


    }
    /**
     * @ return true if user is dead/hp <= 0
     */
    public boolean isDead(){
        return hp <= 0;
    }

    /**
     * revives user if !rebirthUsed and user has token
     * @ return
     */
    public boolean tryRebirth(){

    }
    /**
     * @ return hp
     */
    public int getHP(){
        return hp;
    }

    /**
     * getter for agressiveness
     * @ return aggressiveness
     */
    public int getAggressiveness(){

    }
    /**
     * aggressiveness setter
     * @ param takes an int value
     */
    public void setAggressiveness(int value){
        this.aggressiveness = value;
    }
}
