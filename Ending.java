public class Ending {
    String endingName;
    String description;
    int currentHP;
    int currentAggresiveness;
    boolean isAlive;

    public Ending(String endingName, String description, int currentHP, int currentAggresiveness, boolean isAlive) {
        this.endingName = endingName;
        this.description = description;
        this.currentHP = currentHP;
        this.currentAggresiveness = currentAggresiveness;
        this.isAlive = isAlive;
    }

    public boolean isEnding(){
        return currentHP <= 0 || isAlive;
    }

    public String getEndingName() {
        return endingName;
    }

    public String getDescription() {
        return description;
    }

}
