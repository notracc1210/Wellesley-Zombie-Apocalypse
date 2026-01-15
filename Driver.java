import java.util.Random;

public class Driver{
    private int hp;
    private int aggressiveness;
    private boolean hasRebirthToken; //acquired from roulette sucess
    private boolean rebirthUsed; //can rebirth once
    private boolean forceZombieNextRoll; //set if roulette fails
    private GameMap map;
    private Position currentPosition;
    private int currentPositionIndex;
    private Random rng;
    private static final double CAREER_CENTER_SUCCESS_RATE = 0.10;

    public static void main(String[] args){
        System.out.println("Welleslsey Zombie Apocalypse");
    }

    public Driver(GameMap map){
        this.map = map;
        this.hp = 100;
        this.aggressiveness = 20;
    }

    public int rollDice(){
        return rng.nextInt(6) + 1;
    }

    public void moveTo(Position pos){
        this.currentPosition = pos;
    }

    public String applyConsequence(Option o){
        this.hp += o.getHPChange();
        this.aggressiveness += o.getAggresivenessChange();
        return o.getConsequence().getDescription();
    }

    public boolean isDead(){
        return this.hp <= 0;
    }

    /**
     * revives user if !rebirthUsed and user has token
     * @ return
     */
    public boolean tryRebirth(){
        if(hasRebirthToken && !rebirthUsed){
            rebirthUsed = true;
            hp = 50; //revive with 50 HP
            return true;
        }
        return false;
    }

    public int getHP(){
        return hp;
    }

    public int getAggressiveness(){
        return aggressiveness;
    }
}
