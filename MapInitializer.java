/**
 * MapInitializer.java
 * Initializes the game map with detailed positions and consequences
 */
public class MapInitializer {
    
    public static GameMap initializeMap() {
        GameMap map = new GameMap();
        
        // Position 0: Special Position - Meeting a Zombie
        Position zombieEncounter = new Position(
            "Zombie Encounter",
            "You turn a corner and come face-to-face with a zombie.\n" +
            "Its decomposed face snarls at you. Time slows down.\n" +
            "You must act now. Fight or Flight?\n" +
            "Your survival instinct kicks in—choose wisely."
        );
        
        zombieEncounter.addOption(new Option(
            "Fight the zombie",
            new Consequence("You engage the zombie with everything you have. The fight is brutal and visceral.\n" +
                "Teeth snap at your arms. Decaying flesh falls as you strike. You manage to defeat it,\n" +
                "but not without injury. You stumble away, wounded and exhausted.", 
                -10, 15)
        ));
        
        zombieEncounter.addOption(new Option(
            "Flee from the zombie",
            new Consequence("You turn and run as fast as your legs can carry you. The zombie gives chase,\n" +
                "moaning and clicking. Your heart pounds in your chest. After several blocks, you lose it\n" +
                "in a crowd of abandoned cars. You're safe... for now.", 
                -5, 5)
        ));
        
        map.addPosition(zombieEncounter);
        
        // Position 1: Alumnae Hall - Shuttle Escape with Russian Roulette (5% success)
        Position alumnaeHall = new Position(
            "Alumnae Hall",
            "You arrive at Alumnae Hall, where rumors of an escape shuttle linger.\n" +
            "Some say it leaves for safety off-campus.\n" +
            "The reality is far more complicated—the shuttle is leaving, but the odds are terrible.\n" +
            "Do you stay at Wellesley or risk the shuttle gamble?"
        );
        
        alumnaeHall.addOption(new Option(
            "Stay at Wellesley College and barricade",
            new Consequence("You decide to hunker down at Wellesley. It's familiar. It's known.\n" +
                "You reinforce your position, establish supply lines, and settle in.\n" +
                "Nothing changes. You remain safe for now, but uncertainty lingers.", 
                0, 0)
        ));
        
        // Probabilistic shuttle option (5% success, 95% failure)
        Option shuttleOption = new Option("Get on the shuttle and attempt escape");
        
        // Success scenario (5% chance)
        shuttleOption.addProbabilisticConsequence(
            new Consequence("Against impossible odds—a 5% chance—you made it!\n" +
                "The shuttle roars to life. Campus shrinks behind you as you accelerate toward the highway.\n" +
                "The gates close. You're out. You're FREE. GAME OVER - YOU ESCAPED!", 
                20, -5, true, false, false),
            5
        );
        
        // Failure scenario (95% chance)
        shuttleOption.addProbabilisticConsequence(
            new Consequence("You board the shuttle with false hope. It rumbles to a start, then dies.\n" +
                "The engine fails. Escape denied. As you exit in shame, you feel a dark presence growing.\n" +
                "The zombies sense your desperation. Aggressiveness increases significantly.\n" +
                "The next encounter will be with a zombie—no escape.", 
                -10, 15, false, false, true),
            95
        );
        
        alumnaeHall.addOption(shuttleOption);
        
        map.addPosition(alumnaeHall);
        
        // Position 2: Lulu Dining Hall - 4 Food Options
        Position luluDining = new Position(
            "Lulu Dining Hall",
            "You enter Lulu Dining Hall.\n" +
            "The kitchen is partially intact with several food stations.\n" +
            "Four distinct food options remain: fresh salad, grilled chicken, pasta, and rice bowls.\n" +
            "Food quality is everything now. Your choice will directly impact your survival."
        );
        
        luluDining.addOption(new Option(
            "Choose the fresh salad",
            new Consequence("The vegetables are vibrant and crisp. Nutrients flood your system.\n" +
                "You feel rejuvenated and energized. Your body feels lighter, healthier.", 
                15, 0)
        ));
        
        luluDining.addOption(new Option(
            "Choose the grilled chicken",
            new Consequence("The protein is exactly what your exhausted body needs.\n" +
                "You feel stronger, more resilient. Confidence in your strength grows.", 
                10, 10)
        ));
        
        luluDining.addOption(new Option(
            "Choose the pasta",
            new Consequence("The pasta is questionable—it's been sitting for days.\n" +
                "Within an hour, your stomach turns. You feel weaker and more desperate.\n" +
                "The bad choice haunts you.", 
                -10, -5)
        ));
        
        luluDining.addOption(new Option(
            "Choose the rice bowls",
            new Consequence("Rice stores well. The carbs give you sustained energy.\n" +
                "You feel satisfied and ready to continue your journey.", 
                12, 0)
        ));
        
        map.addPosition(luluDining);
        
        // Position 3: Career Center - Russian Roulette (10% success)
        Position careerCenter = new Position(
            "Career Center",
            "You find a posting for an international job hiring opportunity.\n" +
            "A mysterious figure offers you one chance: complete the interview perfectly.\n" +
            "Success rate: 10% | Failure rate: 90%\n" +
            "Success: You gain a rebirth token—if you die, you return once.\n" +
            "Failure: The next dice roll forces you to encounter a zombie. No escape."
        );
        
        // Probabilistic interview option (10% success, 90% failure)
        Option interviewOption = new Option("Attempt the interview");
        
        // Success scenario (10% chance)
        interviewOption.addProbabilisticConsequence(
            new Consequence("You take a deep breath and enter the interview.\n" +
                "Against impossible odds, everything clicks perfectly.\n" +
                "The interviewer hands you a glowing token—your rebirth token.\n" +
                "If you die, you will return. This is POWER.", 
                5, 10, false, true, false),
            10
        );
        
        // Failure scenario (90% chance)
        interviewOption.addProbabilisticConsequence(
            new Consequence("Your answers are scattered and desperate. The interview falls apart.\n" +
                "They reject you coldly and with finality.\n" +
                "As you leave, you feel a terrible omen—your next encounter will be unavoidable.\n" +
                "Next time, there is a zombie. No escape possible.", 
                0, -5, false, false, true),
            90
        );
        
        careerCenter.addOption(interviewOption);
        
        careerCenter.addOption(new Option(
            "Skip the interview entirely",
            new Consequence("You walk past the Career Center without stopping.\n" +
                "No token. No guaranteed zombie. Your fate remains uncertain.", 
                0, 0)
        ));
        
        map.addPosition(careerCenter);
        
        // Position 4: Lake Waban - Fight or Flight
        Position lakeWaban = new Position(
            "Lake Waban Path",
            "You're walking along the frozen path of Lake Waban when you encounter a HERD of zombies.\n" +
            "Terror floods your body. The undead are shambling toward you.\n" +
            "You must choose: Stand and fight, or run for your life?"
        );
        
        lakeWaban.addOption(new Option(
            "Fight the zombie herd",
            new Consequence("You stand your ground and fight with everything you have.\n" +
                "Zombies fall under your assault. The victory is brutal and exhausting.\n" +
                "You decrease your HP from the battle but increase your aggressiveness dramatically.", 
                -20, 25)
        ));
        
        lakeWaban.addOption(new Option(
            "Flee from the herd (Your greatest mistake)",
            new Consequence("You turn and run in the opposite direction, not thinking, just surviving.\n" +
                "After creating distance, you stop to catch your breath.\n" +
                "That's when you realize: You're standing in the middle of the frozen lake Waban.\n" +
                "You hear a terrifying CRACK beneath your feet. The ice breaks. You plunge into the icy water.\n" +
                "You die of hypothermia. RIP.", 
                -100, 0, true, false, false)
        ));
        
        map.addPosition(lakeWaban);
        
        // Position 5: Bates Dining Hall - 4 Food Options
        Position batesDining = new Position(
            "Bates Dining Hall",
            "You enter Bates Dining Hall. The dining area is eerily quiet.\n" +
            "You find four food options: fresh bread, canned soup, mystery meat, and dried fruit.\n" +
            "Quality varies significantly. Choose wisely—bad food will haunt you."
        );
        
        batesDining.addOption(new Option(
            "Choose the fresh bread",
            new Consequence("The bread is crusty and still warm. You break off a piece and eat slowly,\n" +
                "savoring each bite. Carbs restore your energy. You feel nourished.", 
                12, 0)
        ));
        
        batesDining.addOption(new Option(
            "Choose the canned soup",
            new Consequence("The soup heats quickly over a makeshift fire.\n" +
                "Warmth spreads through your body. You feel stronger and ready to continue.", 
                8, 5)
        ));
        
        batesDining.addOption(new Option(
            "Choose the mystery meat",
            new Consequence("You don't want to know what this is. The smell is questionable.\n" +
                "You eat it anyway, desperate and hungry.\n" +
                "Within an hour, your stomach turns. You feel weaker.", 
                -15, -5)
        ));
        
        batesDining.addOption(new Option(
            "Choose the dried fruit",
            new Consequence("Dried fruit is stable and nutritious. The natural sugars give you a quick boost.\n" +
                "You feel your energy return. A good, safe choice.", 
                10, 0)
        ));
        
        map.addPosition(batesDining);
        
        // Position 6: Freeman Hall - Puzzle Solving
        Position freemanHall = new Position(
            "Freeman Hall",
            "You discover a locked safe with a complex puzzle lock.\n" +
            "A brass plate next to the safe reads: 'Answer my riddles to unlock treasures within.'\n" +
            "Inside: weapons, medicine, and survival tools.\n" +
            "You must solve the puzzle by answering riddle questions correctly.\n" +
            "The safe has a security system—wrong answers trigger an alarm."
        );
        
        // Puzzle questions - correct answer is option 1
        Option puzzle1 = new Option("Riddle One: I have cities but no houses, forests but no trees, and water but no fish. What am I?");
        puzzle1.addProbabilisticConsequence(
            new Consequence("Correct! 'A map!' The safe recognizes your answer and moves to the next riddle.\n" +
                "You feel the lock mechanism shift. One step closer.", 
                0, 0),
            0  // This is just a holder - actual answer will be checked in Driver
        );
        
        Option puzzle2 = new Option("Riddle Two: The more you take, the more you leave behind. What am I?");
        puzzle2.addProbabilisticConsequence(
            new Consequence("Correct! 'Footsteps!' Another lock mechanism clicks into place.\n" +
                "You're one step away from opening the safe.", 
                0, 0),
            0  // This is just a holder - actual answer will be checked in Driver
        );
        
        Option puzzle3_correct = new Option("Riddle Three (ANSWER: Reflection): What can travel around the world while staying in a corner?");
        puzzle3_correct.addProbabilisticConsequence(
            new Consequence("CORRECT! You solved all three riddles perfectly!\n" +
                "The safe door swings open with a satisfying CLICK.\n" +
                "Inside: a gleaming weapon, vials of luminescent magical medicine, and a crystalline token that pulses with energy.\n" +
                "The token is ancient and powerful—a REBIRTH TOKEN.\n" +
                "If you die, you will return. This is POWER.", 
                15, 10, false, true, false),
            0
        );
        
        Option puzzle3_wrong = new Option("Riddle Three (WRONG ANSWER): What can travel around the world while staying in a corner?");
        puzzle3_wrong.addProbabilisticConsequence(
            new Consequence("WRONG! Your answer triggers a security alarm!\n" +
                "BEEEEP! BEEEEP! BEEEEP!\n" +
                "Metal shutters slam down over the safe. The security system activates!\n" +
                "Dust falls from the ceiling. The floor trembles beneath you.\n" +
                "You scramble away from the safe, covering your head. The alarm blares for ten seconds then cuts off.\n" +
                "The safe is now permanently sealed. You take significant damage and panic increases your aggression.", 
                -15, 20),
            0
        );
        
        // Add options to Freeman Hall position (will show puzzle interface)
        freemanHall.addOption(new Option(
            "Solve the safe puzzle",
            new Consequence("You examine the safe carefully. Three riddles are carved into the lock mechanism.\n" +
                "You'll need to solve all three to unlock it. The safe's security system is active.",
                0, 0)
        ));
        
        freemanHall.addOption(new Option(
            "Skip the puzzle and leave",
            new Consequence("You decide the risk isn't worth it. You back away from the safe slowly.\n" +
                "Maybe someone else will come along and open it. You continue on, unharmed.", 
                0, 0)
        ));
        
        map.addPosition(freemanHall);
        
        // Position 7: Wellesley Chapel - Chappell Roan Karaoke
        Position chapel = new Position(
            "Wellesley Chapel",
            "The chapel's silence is broken by a haunting, melodic voice.\n" +
            "You peer behind the altar and find CHAPPELL ROAN—impossibly alive and powerful.\n" +
            "She grins wickedly. 'Karaoke time,' she demands.\n" +
            "'Choose a song: Subway or My Kink is Karma?'"
        );
        
        chapel.addOption(new Option(
            "Perform 'Subway'",
            new Consequence("You belt out the song with all your heart. The music fills the chapel with ethereal power.\n" +
                "As the final note rings, a shimmering portal opens before the altar—\n" +
                "a gateway to an alternate Wellesley where the apocalypse never happened.\n" +
                "You step through. GAME OVER - YOU ESCAPED!", 
                50, -25, true, false, false)
        ));
        
        chapel.addOption(new Option(
            "Perform 'My Kink is Karma'",
            new Consequence("You start singing. Chappell's smile turns sinister and cruel.\n" +
                "As you reach the chorus, she pulls out a syringe filled with luminescent viral serum.\n" +
                "'I'm done with this version of you,' she whispers.\n" +
                "The injection burns like fire. You die. GAME OVER.", 
                -100, 0, true, false, false)
        ));
        
        chapel.addOption(new Option(
            "Refuse to sing and run",
            new Consequence("'No!' you shout, sprinting toward the exit.\n" +
                "Chappell laughs maniacally behind you, but you escape.\n" +
                "You've made a dangerous enemy, but you're alive.\n" +
                "You never look back at the chapel.", 
                0, 20)
        ));
        
        map.addPosition(chapel);
        
        // Position 8: Science Center - 3 Directions to Escape
        Position scienceCenter = new Position(
            "Science Center",
            "The Science Center looms before you. Through shattered windows, you see movement.\n" +
            "Twisted, wrong movement. Mutated animals roam the halls—creatures warped by the virus.\n" +
            "A squirrel the size of a wolf with teeth like daggers paces near the entrance.\n" +
            "You must choose a direction to escape: North Passage, East Passage, or West Passage?"
        );
        
        scienceCenter.addOption(new Option(
            "Head through the North Passage (Clear path)",
            new Consequence("You move north through the Science Center. The path is clear.\n" +
                "You encounter no mutated creatures. Your HP and aggressiveness remain stable.\n" +
                "A lucky escape through a quiet corridor.", 
                0, 0)
        ));
        
        scienceCenter.addOption(new Option(
            "Head through the East Passage (Creatures attack)",
            new Consequence("You burst through the East Passage. Mutated rabbits and twisted squirrels attack!\n" +
                "You take significant damage but fight them off with fierce aggressiveness.\n" +
                "The battle leaves you wounded but filled with adrenaline.", 
                -20, 30)
        ));
        
        scienceCenter.addOption(new Option(
            "Head through the West Passage (Mixed results)",
            new Consequence("The West Passage is partially blocked. You squeeze through carefully.\n" +
                "One mutated creature notices you, but you avoid direct combat.\n" +
                "You escape with minor injuries and gained caution.", 
                -8, 5)
        ));
        
        map.addPosition(scienceCenter);
        
        // Position 9: Davis Museum - Russian Roulette (1/6 survival, 5/6 death)
        Position davisMuseum = new Position(
            "Davis Museum",
            "Inside Davis Museum, on a velvet pedestal, sits an antique revolver.\n" +
            "A note beside it reads: 'One chamber is loaded. ⅙ chance of surviving.'\n" +
            "Russian Roulette. The ultimate gamble. Will you take your chances?"
        );
        
        // Probabilistic roulette option (1/6 survive, 5/6 die)
        Option rouletteOption = new Option("Play Russian Roulette");
        
        // Survive scenario (1/6 chance)
        rouletteOption.addProbabilisticConsequence(
            new Consequence("You spin the chamber slowly. Your hand trembles as you place the gun to your temple.\n" +
                "You close your eyes and pull the trigger. CLICK. An empty chamber.\n" +
                "Your hands shake violently as adrenaline floods your body.\n" +
                "You're alive. You're invincible—or just incredibly lucky.", 
                0, 30),
            16
        );
        
        // Death scenario (5/6 chance)
        rouletteOption.addProbabilisticConsequence(
            new Consequence("You spin the chamber. The metallic click of each rotation sounds like your heartbeat.\n" +
                "You aim. You pull the trigger. The sound is deafening.\n" +
                "Pain explodes through your head. Everything goes black. You're DEAD.\n" +
                "Fate has spoken.", 
                -100, 0, true, false, false),
            84
        );
        
        davisMuseum.addOption(rouletteOption);
        
        davisMuseum.addOption(new Option(
            "Refuse to play and take the gun instead",
            new Consequence("You grab the revolver without spinning.\n" +
                "Having a firearm changes everything about how you feel.\n" +
                "Protection. Power. Control. The gun is heavy in your hands but makes you feel alive.", 
                5, 15)
        ));
        
        map.addPosition(davisMuseum);
        
        // Position 10: Clapp Library - 3 Book Choices
        Position clappLibrary = new Position(
            "Clapp Library",
            "You enter the quiet, dusty sanctuary of Clapp Library.\n" +
            "Research papers on virology are scattered across study tables.\n" +
            "You find three distinct books: 'Viral Transmission Patterns', 'Immune System Defense', and 'Unknown Subject'.\n" +
            "Knowledge is power. But which knowledge?"
        );
        
        clappLibrary.addOption(new Option(
            "Study 'Viral Transmission Patterns'",
            new Consequence("You spend hours absorbing information about how the virus spreads.\n" +
                "You learn transmission vectors, safe zones, and infection prevention.\n" +
                "Your knowledge becomes your armor. You understand your enemy now.\n" +
                "HP increases significantly as you learn survival techniques.", 
                20, 10)
        ));
        
        clappLibrary.addOption(new Option(
            "Study 'Immune System Defense'",
            new Consequence("You learn about immune response patterns and biological weaknesses in the undead.\n" +
                "The knowledge fills you with confidence. You feel stronger mentally and physically.\n" +
                "Both HP and aggressiveness increase from this knowledge.", 
                15, 15)
        ));
        
        clappLibrary.addOption(new Option(
            "Study the 'Unknown Subject' (Risky)",
            new Consequence("You grab the unmarked book. The contents are disturbing and cryptic.\n" +
                "Information about zombie origins. Hints that someone caused this intentionally.\n" +
                "The knowledge is too much. Your aggressiveness spikes, but your HP decreases from the shock.", 
                -5, 35)
        ));
        
        map.addPosition(clappLibrary);
        
        return map;
    }
}
