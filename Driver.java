import java.util.Random;
import java.util.Scanner;

public class Driver{
    private int hp;
    private int aggressiveness;
    private boolean hasRebirthToken; //acquired from roulette sucess
    private boolean rebirthUsed; //can rebirth once
    private boolean forceZombieNextRoll; //set if roulette fails
    private GameMap map;
    private Position currentPosition;
    private Random rng;
    private Scanner scanner;
    private static final double CAREER_CENTER_SUCCESS_RATE = 0.10;


public static void main(String[] args){
    System.out.println("Welleslsey Zombie Apocalypse");
}

    public Driver(GameMap map) {
        this.map = map;
        this.hp = 100;
        this.aggressiveness = 50;
        this.hasRebirthToken = false;
        this.rebirthUsed = false;
        this.forceZombieNextRoll = false;

        this.rng = new Random();
        this.scanner = new Scanner(System.in);

    public void gameLoop() {
        while (true) {
            printStatus();

            int roll = rollDice();
            currentPosition = map.getPositionByIndex(roll % map.size());

            System.out.println("\nYou arrive at: " + currentPosition.name);
            System.out.println(currentPosition.description);

            if (currentPosition.options.isEmpty()) {
                System.out.println("There is nothing you can do here.");
                continue;
            }

            for (int i = 0; i < currentPosition.options.size(); i++) {
                System.out.println((i + 1) + ". " + currentPosition.options.get(i).description);
            }

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt() - 1;

            if (choice < 0 || choice >= currentPosition.options.size()) {
                System.out.println("Invalid choice. You hesitate.");
                continue;
            }

            Option selected = currentPosition.options.get(choice);

            if (selected.isSuccessful()) {
                applyConsequence(selected.getConsequence());
            } else {
                System.out.println("It failed...");
            }

            if (isDead()) {
                if (tryRebirth()) {
                    System.out.println("You were reborn.");
                } else {
                    endGame();
                    return;
                }
            }
        }
    }

    public int rollDice(){
        int rolledNum = rng.nextInt(6) + 1;
    }

    public void moveTo(Position pos){
        this.currentPosition = pos;
    }
    /**
     *

    public void applyConsequence(Consequence c){


    }
    */

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
    public boolean tryRebirth() {
        if (hasRebirthToken && !rebirthUsed) {
            hp = 50;
            rebirthUsed = true;
            return true;
        }
        return false;
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
        return this.aggressiveness;
    }
    /**
     * aggressiveness setter
     * @ param takes an int value
     */
    public void setAggressiveness(int value){
        this.aggressiveness = value;
    }
}
