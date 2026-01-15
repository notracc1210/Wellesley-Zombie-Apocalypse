import java.util.ArrayList;
import java.util.Random;

public class GameMap {
    private ArrayList<Position> positions;
    private Random rng = new Random();
    private static final int MAX_AGGRESSIVENESS = 10;
    private static final int ZOMBIE_ATTACK_MAX = 10;

    public GameMap() {
        positions = new ArrayList<>();
    }

    public void addPosition(Position p) {
        positions.add(p);
    }

    public Position getPositionByIndex(int i) {
        return positions.get(i);
    }

    public int size() {
        return positions.size();
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    // ===== STATUS BAR =====
    public void enforceAggressivenessCap(Driver driver) {
        if (driver.getAggressiveness() > MAX_AGGRESSIVENESS) {
            driver.setAggressiveness(MAX_AGGRESSIVENESS);
        }
    }

    // ===== ZOMBIE ENCOUNTER - GLOBAL RULE =====
    public void zombieEncounter(Driver driver) {
        int zombieAttackPower = rng.nextInt(ZOMBIE_ATTACK_MAX + 1); // 0..10

        if (driver.getAggressiveness() > zombieAttackPower) {
            // player defeats the zombie -> continue game
        } else {
            // player dies -> GAME OVER
            driver.adjustHP(-driver.getHP()); // set HP to 0
        }
    }

    // ===== LOCATION: Alumni Hall =====
    public void alumniHall(Driver driver, String choice) {
        if ("Go back home".equalsIgnoreCase(choice)) {
            driver.adjustHP(-driver.getHP());
        } else if ("Stay".equalsIgnoreCase(choice)) {
            // continue game (no change)
        }
    }

    // ===== LOCATION: Lulu =====
    public void lulu(Driver driver) {
        driver.adjustHP(1);
    }

    // ===== LOCATION: Career Center (Russian roulette style) =====
    public void careerCenter(Driver driver) {
        if (rng.nextDouble() < Driver.CAREER_CENTER_SUCCESS_RATE) {
            driver.setHasRebirthToken(true);
        } else {
            driver.setForceZombieNextRoll(true);
        }
    }

    // ===== LOCATION: Lake Waban =====
    public void lakeWaban(Driver driver, String choice) {
        if ("Flight".equalsIgnoreCase(choice)) {
            driver.adjustHP(-driver.getHP());
        } else if ("Fight".equalsIgnoreCase(choice)) {
            // Fight outcome unspecified
        }
    }

    // ===== LOCATION: Bates Dining Hall =====
    public void batesDining(Driver driver) {
        driver.adjustHP(-1);
    }

    // ===== LOCATION: Freeman =====
    public void freeman(Driver driver, boolean puzzleSuccess) {
        if (puzzleSuccess) {
            // success: grant weapon or medicine (designer to implement)
        } else {
            // failure: no-op or status change (designer to implement)
        }
    }

    // ===== LOCATION: Chapel =====
    public void chapel(Driver driver, String choice) {
        if ("Subway".equalsIgnoreCase(choice)) {
            // portal to alternate universe (designer: implement map swap/ending)
        } else if ("My Kink is Karma".equalsIgnoreCase(choice)) {
            driver.adjustHP(-driver.getHP());
        }
    }

    // ===== LOCATION: Science Center =====
    public void scienceCenter(Driver driver) {
        // treat as hostile encounter
        zombieEncounter(driver);
    }

    // ===== LOCATION: Davis Museum (Russian roulette / Immortality Vaccine) =====
    public void davisMuseum(Driver driver) {
        if (rng.nextDouble() < 0.10) {
            // gain one-time vaccine -> reuse rebirth token mechanic
            driver.setHasRebirthToken(true);
        } else {
            driver.setForceZombieNextRoll(true);
        }
    }

    // ===== LOCATION: Clapp Library =====
    public void clappLibrary(Driver driver) {
        driver.adjustHP(1);
    }
}
