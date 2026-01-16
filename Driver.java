import java.util.Random;
import java.util.Scanner;

public class Driver{
    private int hp;
    private int aggressiveness;
    private boolean hasRebirthToken; //acquired from roulette sucess
    private boolean rebirthUsed; //can rebirth once
    private boolean forceZombieNextRoll; //set if roulette fails
    private boolean isAlive = true;
    private static GameMap gameMap;
    private Position currentPosition;
    private int currentPositionIndex = 0;
    private Random rng = new Random();
    private static final double CAREER_CENTER_SUCCESS_RATE = 0.10;
    private static final String OPENING_NARRATIVE = 
        "It starts on an ordinary day.\n\n" +
        "Classes are half full. Group chats are half silent.\n" +
        "Someone jokes that campus feels too quiet.\n\n" +
        "By nightfall, the bells stop ringing.\n\n" +
        "Emergency alerts flood your phone—then cut off mid-sentence.\n" +
        "Doors lock automatically. Lights flicker.\n" +
        "From somewhere between the Science Center and Tower Court, you hear screaming.\n\n" +
        "This isn't a movie.\n" +
        "There are no heroes. No instructions. No reset button.\n\n" +
        "Only two things matter now:\n\n" +
        "HP — your strength, stamina, and will to keep going\n" +
        "Aggressiveness — how far you're willing to go to survive\n\n" +
        "Every choice changes who you become.\n" +
        "Hide. Run. Negotiate. Fight. Abandon. Protect.\n\n" +
        "Wellesley College is no longer a campus.\n" +
        "It's a maze of memories, barricades, and shadows.\n\n" +
        "Some people will escape.\n" +
        "Some will lead.\n" +
        "Some will lose themselves.\n\n" +
        "And some will never leave.\n\n" +
        "Survive the night.\n" +
        "Live with the ending.";

    public static void main(String[] args){
        System.out.println("Welleslsey Zombie Apocalypse");
        gameMap = MapInitializer.initializeMap();
        Driver player = new Driver();
        player.startGame();


    }

    public void startGame(){
        //game loop here 
        System.out.println("Starting game...");
        //game loop here
        System.out.println("Game started.");
        System.out.println(OPENING_NARRATIVE);
        System.out.println("\nYou start with " + hp + " HP and " + aggressiveness + " Aggressiveness.\n");

        Ending ending = new Ending(hp, aggressiveness, isAlive);
        while(ending.isEnding() == false && currentPositionIndex < gameMap.getSize()){
            System.out.println("Press Enter to roll the dice.");
            try{
                System.in.read();
            } catch(Exception e){
                e.printStackTrace();
            }
            
            // If forceZombieNextRoll is true, force movement to position 0 (Zombie Encounter)
            int diceRoll;
            if(forceZombieNextRoll){
                System.out.println("You sense an overwhelming presence... A zombie appears!");
                moveTo(gameMap.getPosition(0)); // Move to Zombie Encounter
                forceZombieNextRoll = false; // Reset flag
                continue;
            } else {
                diceRoll = rollDice();
                System.out.println("You rolled a " + diceRoll + "!");
                currentPositionIndex += diceRoll;
            }
            
            if(currentPositionIndex >= gameMap.getSize()){
                currentPositionIndex = gameMap.getSize() - 1; //move to last position
                moveTo(gameMap.getPosition(currentPositionIndex));

                ending = new Ending(hp, aggressiveness, isAlive);
                break;
            }

            moveTo(gameMap.getPosition(currentPositionIndex));

            ending = new Ending(hp, aggressiveness, isAlive);
        }

        System.out.println("\n--- GAME OVER ---");
        ending.setEnding();
        System.out.println(ending.getEndingName());
        System.out.println("Achievement Unlocked: " + ending.getAchievement());
        System.out.println(ending.getDescription());
    }

    public Driver(){
        this.hp = 100;
        this.aggressiveness = 20;
        this.currentPositionIndex = 0;
    }

    public int rollDice(){
        return rng.nextInt(1) + 1;
    }

    public void moveTo(Position pos){
        this.currentPosition = pos;
        System.out.println("Moved to position: " + pos.getName());
        System.out.println(pos.getDescription());
        System.out.println("Options:");
        for(int i = 0; i < pos.getOptions().size(); i++){
            System.out.println((i+1) + ". " + pos.getOptions().get(i).getDescription());
        }

        System.out.println("Choose an option by entering the corresponding number:");
        
        Scanner scanner = new Scanner(System.in);
        
        int choice = scanner.nextInt();
        Option selectedOption = pos.getOptions().get(choice - 1);
        
        // Special handling for Freeman Hall puzzle
        if(pos.getName().equals("Freeman Hall") && selectedOption.getDescription().equals("Solve the safe puzzle")){
            Puzzle puzzle = new Puzzle();
            boolean puzzleSolved = puzzle.playFreemanHallPuzzle();
            
            if(puzzleSolved){
                // Puzzle solved - grant rebirth token
                this.hasRebirthToken = true;
                this.hp += 15;
                this.aggressiveness += 10;
                System.out.println("\n--- Reward for Success ---");
                System.out.println("You have gained a REBIRTH TOKEN!");
            } else {
                // Puzzle failed - trigger alarm
                this.hp -= 15;
                this.aggressiveness += 20;
                System.out.println("\n--- Consequences of Failure ---");
                System.out.println("You take damage from the alarm and panic overwhelms you.");
            }
            System.out.println("\nAfter this event, your HP is now " + hp + " and your Aggressiveness is now " + aggressiveness + ".\n");
        } else {
            // Regular option handling
            String consequenceDescription = applyConsequence(selectedOption);
            
            System.out.println("\n--- What Happens ---");
            System.out.println(consequenceDescription);
            System.out.println("\nAfter this event, your HP is now " + hp + " and your Aggressiveness is now " + aggressiveness + ".\n");
        }
    }

    public String applyConsequence(Option o){
        // Get the consequence (either direct or probabilistic)
        Consequence consequence = o.getConsequence();
        if(o.hasProbabilisticOutcome()){
            consequence = o.getRandomConsequence();
        } else {
            consequence = o.getConsequence();
        }
        
        // Apply HP and aggressiveness changes
        this.hp += consequence.getHP();
        this.aggressiveness += consequence.getAggressiveness();
        
        // Handle special mechanics
        if(consequence.grantsRebirthToken()){
            this.hasRebirthToken = true;
        }
        
        if(consequence.forcesZombieNextRoll()){
            this.forceZombieNextRoll = true;
        }
        
        if(consequence.causesGameOver()){
            this.isAlive = false;
        }
        
        return consequence.getDescription();
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

    public boolean russianRoulette(int successRate){
        int roll = rng.nextInt(100) + 1; 
        if(roll <= successRate){ 
            forceZombieNextRoll = false;
            hasRebirthToken = true;
            return true; 
        } else {
            forceZombieNextRoll = true;
            return false; 
        }
    }
}
