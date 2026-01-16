public class Ending {
    String endingName;
    String achievement;
    String description;
    int currentHP;
    int currentAggressiveness;
    boolean isAlive;



    public Ending(int currentHP, int currentAggressiveness, boolean isAlive) {
        this.currentHP = currentHP;
        this.currentAggressiveness = currentAggressiveness;
        this.isAlive = isAlive;
    }
    

    public boolean isEnding(){
        return currentHP <= 0 || !isAlive;
    }

    public String getEndingName() {
        return endingName;
    }

    public String getAchievement() {
        return achievement;
    }

    public String getDescription() {
        return description;
    }

    public void setEnding() {
        if (!isAlive || currentHP <= 0) {
            endingName = "Freshman Forever";
            achievement = "Orientation Never Ends";
            description = "You fall during the chaos. Days later, familiar footsteps echo through campus. Welcome to Wellesley. Again.";
        }

        else if (currentAggressiveness >= 90 && currentHP <= 30) {
            endingName = "Self-Destruction";
            achievement = "Aggression Without Control";
            description = "You survive the zombies, but not yourself. Violence works—until it doesn’t.";
        }

        else if (currentHP >= 80 && currentAggressiveness >= 45 && currentAggressiveness <= 55) {
            endingName = "Perfect Run";
            achievement = "Dean’s List: Apocalypse Edition";
            description = "You balance force, mercy, and leadership flawlessly. Wellesley survives. Somehow, you still graduate.";
        }

        else if (currentAggressiveness >= 85 && currentHP >= 20) {
            endingName = "Campus Cleansed";
            achievement = "Final Girl (or Final Boss)";
            description = "By the time rescue arrives, there is nothing left to save. Only silence remains.";
        }

        else if (currentAggressiveness >= 70 && currentHP >= 30) {
            endingName = "Blood on the Path";
            achievement = "Scream Tunnel";
            description = "You fight your way through campus alone. The legends were right. The tunnel remembers you.";
        }

        else if (currentHP >= 70 && currentAggressiveness <= 20) {
            endingName = "Silent Survival";
            achievement = "The Last Librarian";
            description = "You barricade yourself in Clapp Library, surviving in silence while the world collapses outside.";
        }

        else if (currentHP >= 50 && currentAggressiveness <= 30) {
            endingName = "Escape Without Scars";
            achievement = "Wellesley Is a Feeling";
            description = "You flee campus under cover of fog, leaving Wellesley behind before it consumes you.";
        }

        else {
            endingName = "Unrecorded Survival";
            achievement = "No One Will Remember This";
            description = "You survive, but no story is told. History moves on without you.";
        }


    }



}
