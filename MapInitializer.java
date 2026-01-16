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
                -25, 15)
        ));
        
        zombieEncounter.addOption(new Option(
            "Flee from the zombie",
            new Consequence("You turn and run as fast as your legs can carry you. The zombie gives chase,\n" +
                "moaning and clicking. Your heart pounds in your chest. After several blocks, you lose it\n" +
                "in a crowd of abandoned cars. You're safe... for now.", 
                -12, 5)
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
                -25, 15, false, false, true),
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
                -25, -5)
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
                -35, 25)
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
                -30, -5)
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
                -35, 20),
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
                -40, 30)
        ));
        
        scienceCenter.addOption(new Option(
            "Head through the West Passage (Mixed results)",
            new Consequence("The West Passage is partially blocked. You squeeze through carefully.\n" +
                "One mutated creature notices you, but you avoid direct combat.\n" +
                "You escape with minor injuries and gained caution.", 
                -16, 5)
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
                -12, 35)
        ));
        
        map.addPosition(clappLibrary);
        
        // Position 11: Severance Hall - Survival Choice
        Position severanceHall = new Position(
            "Severance Hall",
            "An old dormitory looms before you, its walls marked with scratches and blood.\n" +
            "Inside, you can hear faint music playing—Vivaldi's Four Seasons.\n" +
            "It's hauntingly beautiful and completely out of place in this apocalypse.\n" +
            "Do you investigate the sound or continue without entering?"
        );
        
        severanceHall.addOption(new Option(
            "Investigate the music cautiously",
            new Consequence("You climb through a window and find survivors gathered in a sealed safe room.\n" +
                "They're playing music to maintain sanity. They welcome you with open arms.\n" +
                "You feel hope and camaraderie. They share food and shelter.", 
                18, -8)
        ));
        
        severanceHall.addOption(new Option(
            "Enter through the front door",
            new Consequence("The door creaks open. You step inside and immediately hear moaning.\n" +
                "Zombies are in the building! You scramble toward the music but take severe damage.\n" +
                "You barely make it to the safe room before slamming the door shut.", 
                -40, 18)
        ));
        
        severanceHall.addOption(new Option(
            "Avoid the building and move on",
            new Consequence("You trust your instincts and stay alert. The music fades as you leave.\n" +
                "Better safe than sorry. Caution keeps you alive.", 
                0, 8)
        ));
        
        map.addPosition(severanceHall);
        
        // Position 12: Stone Hall - Resource Cache
        Position stoneHall = new Position(
            "Stone Hall",
            "A hidden basement cache lies before you. Shelves are lined with supplies.\n" +
            "Medical kits, food rations, and ammunition glimmer in the dim light.\n" +
            "A skeleton sits in the corner—whoever hid these didn't survive to use them.\n" +
            "How much do you take? The more you carry, the heavier you'll be."
        );
        
        stoneHall.addOption(new Option(
            "Take everything you can carry",
            new Consequence("Greed takes over. You load yourself with supplies until you can barely move.\n" +
                "Your HP increases significantly. You feel prepared and powerful.\n" +
                "But the weight slows you down. Next encounter will be dangerous.", 
                28, 12)
        ));
        
        stoneHall.addOption(new Option(
            "Take only what you need",
            new Consequence("You practice restraint and take only essentials: water, first aid, protein.\n" +
                "You feel disciplined and focused. Steady and reliable gains.", 
                12, 2)
        ));
        
        stoneHall.addOption(new Option(
            "Take nothing and leave",
            new Consequence("Superstition grips you. Whoever owned these didn't survive.\n" +
                "You leave them untouched and continue quickly.", 
                0, 0)
        ));
        
        map.addPosition(stoneHall);
        
        // Position 13: Munger Hall - Encounter Choice
        Position mungerHall = new Position(
            "Munger Hall",
            "Inside a lecture hall, you find evidence of other survivors.\n" +
            "Fresh footprints in the dust. Recently opened cans. A sleeping bag laid out.\n" +
            "Someone was here not more than a day ago. Survival gear scattered about.\n" +
            "Do you search for them or leave before they return?"
        );
        
        mungerHall.addOption(new Option(
            "Search thoroughly for the survivors",
            new Consequence("You spend time tracking the survivors. The trail leads toward the woods.\n" +
                "You lose the trail but gather supplies they've left behind.\n" +
                "You find weapons, food, and a map marking safe zones. Excellent.", 
                16, -5)
        ));
        
        mungerHall.addOption(new Option(
            "Wait in hiding for them to return",
            new Consequence("You hide and wait. Hours pass. A group of four survivors returns.\n" +
                "You reveal yourself. They're cautious but eventually trustworthy.\n" +
                "They share knowledge about the area and give you supplies.", 
                20, -10)
        ));
        
        mungerHall.addOption(new Option(
            "Leave immediately",
            new Consequence("You don't know if these survivors are friend or foe.\n" +
                "Better to be safe. You leave without incident.", 
                0, 5)
        ));
        
        map.addPosition(mungerHall);
        
        // Position 14: Billings Hall - Food Discovery
        Position billingsHall = new Position(
            "Billings Hall",
            "A former student dormitory. Kitchenettes on each floor are mostly ransacked.\n" +
            "You find scattered food items of varying quality and age.\n" +
            "Some items smell fresh, others smell questionable at best.\n" +
            "Your hunger is real, but choosing wrong could kill you."
        );
        
        billingsHall.addOption(new Option(
            "Eat the fresh granola from sealed containers",
            new Consequence("The granola is crunchy and packed with oats, nuts, and dried fruit.\n" +
                "Energy floods your body. Excellent choice.\n" +
                "You feel ready for whatever comes next.", 
                16, 2)
        ));
        
        billingsHall.addOption(new Option(
            "Eat the moldy bread you find",
            new Consequence("You take one bite and immediately spit it out.\n" +
                "The mold tastes awful and sends chills down your spine.\n" +
                "You feel nauseous for hours. Bad decision.", 
                -28, -5)
        ));
        
        billingsHall.addOption(new Option(
            "Drink expired milk you find",
            new Consequence("It's from before the apocalypse. You drink it anyway, desperate.\n" +
                "Within thirty minutes, your stomach churns violently.\n" +
                "You spend hours feeling weak and dehydrated.", 
                -35, -8)
        ));
        
        map.addPosition(billingsHall);
        
        // Position 15: Hazard Hall - Dangerous Path
        Position hazardHall = new Position(
            "Hazard Hall",
            "The building is structurally unsound. Debris falls from above at random intervals.\n" +
            "Concrete slabs, metal beams, and shattered glass litter the ground.\n" +
            "You must move through quickly or risk being crushed.\n" +
            "The only path forward requires crossing this danger zone."
        );
        
        hazardHall.addOption(new Option(
            "Sprint through the debris at full speed",
            new Consequence("You move fast and furious. Debris misses you by inches!\n" +
                "Your adrenaline is pumping at maximum. You make it through unscathed.\n" +
                "The exhilaration fills you with aggressive energy.", 
                2, 25)
        ));
        
        hazardHall.addOption(new Option(
            "Carefully pick your way through, testing each step",
            new Consequence("You move methodically, testing each board and beam.\n" +
                "It takes forever, but you avoid all damage.\n" +
                "You emerge exhausted but unharmed.", 
                6, 0)
        ));
        
        hazardHall.addOption(new Option(
            "Try to climb through the ceiling beams",
            new Consequence("You attempt to climb above the danger. Your foot slips.\n" +
                "You crash down hard onto concrete, taking severe damage.\n" +
                "You limp away, injured and questioning your judgment.", 
                -32, 8)
        ));
        
        map.addPosition(hazardHall);
        
        // Position 16: Dower House - Rest Stop
        Position dowerHouse = new Position(
            "Dower House",
            "An old, quiet cottage stands before you. Paint peels from the walls.\n" +
            "Inside, you find it relatively untouched. No signs of zombie activity.\n" +
            "A fireplace. Clean beds. Canned food in the pantry.\n" +
            "This could be a safe haven. Do you stay or keep moving?"
        );
        
        dowerHouse.addOption(new Option(
            "Rest for several hours",
            new Consequence("Sleep restores you completely. You wake refreshed and rejuvenated.\n" +
                "You feel like yourself again. You even find supplies to take with you.\n" +
                "This rest was exactly what you needed.", 
                24, -5)
        ));
        
        dowerHouse.addOption(new Option(
            "Rest briefly and move on",
            new Consequence("A quick nap gives you a minor boost.\n" +
                "You continue with renewed focus but feel like you left unfinished business.", 
                10, 0)
        ));
        
        dowerHouse.addOption(new Option(
            "Don't stop. Keep moving immediately",
            new Consequence("You're paranoid. Staying in one place feels dangerous.\n" +
                "You keep moving. Your aggressiveness spikes from the constant vigilance.", 
                0, 10)
        ));
        
        map.addPosition(dowerHouse);
        
        // Position 17: Founders Hall - Treasure Hunt
        Position foundersHall = new Position(
            "Founders Hall",
            "A historic building with locked rooms and hidden passages.\n" +
            "The architecture is maze-like. Legends speak of treasures hidden by students long ago.\n" +
            "You can hear something moving behind the walls.\n" +
            "Do you search for the treasure or leave?"
        );
        
        foundersHall.addOption(new Option(
            "Search thoroughly, including hidden areas",
            new Consequence("You spend hours searching. Behind a false wall, you find a jewelry box.\n" +
                "Diamonds, gold, and precious stones. Could be traded for supplies.\n" +
                "Excellent discovery. You take what you can carry.", 
                24, 8)
        ));
        
        foundersHall.addOption(new Option(
            "Search quickly and leave",
            new Consequence("You find nothing of value in a quick sweep.\n" +
                "Time is wasted but you escape safely. The sounds in the walls grow louder.", 
                0, 2)
        ));
        
        foundersHall.addOption(new Option(
            "Follow the sounds in the walls",
            new Consequence("Curiosity gets the best of you. You follow the scratching sounds.\n" +
                "Zombies burst through a wall! You fight them off but take heavy damage.\n" +
                "You escape with injuries and nothing to show for it.", 
                -40, 20)
        ));
        
        map.addPosition(foundersHall);
        
        // Position 18: Green Hall - Infected Water
        Position greenHall = new Position(
            "Green Hall",
            "The building has a water fountain. Your mouth is dry. Your lips are cracked.\n" +
            "Your thirst is absolutely unbearable. The fountain still has water.\n" +
            "But the water looks slightly discolored. Yellowish. Possibly contaminated.\n" +
            "Is it safe? Can you afford not to drink?"
        );
        
        greenHall.addOption(new Option(
            "Drink the water anyway",
            new Consequence("Your thirst wins out over caution.\n" +
                "The water tastes metallic and wrong. Your stomach immediately rejects it.\n" +
                "You feel sick for hours. Severe dehydration sets in.", 
                -35, -3)
        ));
        
        greenHall.addOption(new Option(
            "Find an alternative water source",
            new Consequence("You locate a sealed bottle of water in a nearby office.\n" +
                "Condensation on the bottle. Cool and inviting. Pure.\n" +
                "You drink it slowly and savor every drop. Perfect.", 
                12, 0)
        ));
        
        greenHall.addOption(new Option(
            "Boil the fountain water over a fire",
            new Consequence("You spend time building a fire and boiling the water.\n" +
                "Heat should kill any contaminants. You drink carefully.\n" +
                "It works. You're hydrated and safer for it.", 
                8, 2)
        ));
        
        map.addPosition(greenHall);
        
        // Position 19: Homestead Cottage - Abandoned Lab
        Position homesteadCottage = new Position(
            "Homestead Cottage",
            "A research facility is hidden within the cottage basement.\n" +
            "Glass beakers. Microscopes. Bunsen burners. Research notes everywhere.\n" +
            "Experiments on the virus are detailed in scientific journals.\n" +
            "Notes suggest a critical weakness has been discovered.\n" +
            "Do you read the research thoroughly or move on?"
        );
        
        homesteadCottage.addOption(new Option(
            "Study the research thoroughly",
            new Consequence("You spend hours absorbing information about zombie weaknesses.\n" +
                "UV light. Certain chemicals. Specific temperatures.\n" +
                "This knowledge becomes your armor. You understand your enemy now.", 
                22, 16)
        ));
        
        homesteadCottage.addOption(new Option(
            "Glance at the research and take notes",
            new Consequence("You get a general sense but miss important details.\n" +
                "You copy some diagrams but don't fully understand them.\n" +
                "Minor knowledge gain.", 
                8, 3)
        ));
        
        homesteadCottage.addOption(new Option(
            "Ignore the research entirely",
            new Consequence("Science won't help you survive.\n" +
                "You leave the cottage and continue on.", 
                0, 0)
        ));
        
        map.addPosition(homesteadCottage);
        
        // Position 20: Longfellow Hall - Safe Haven
        Position longfellowHall = new Position(
            "Longfellow Hall",
            "A secure dormitory. Barricaded windows. Reinforced doors.\n" +
            "A perimeter has been established. Guards stand watch.\n" +
            "Other survivors are living here. They're organized. They have rules.\n" +
            "They offer you a choice: join them or continue alone?"
        );
        
        longfellowHall.addOption(new Option(
            "Join the group as a full member",
            new Consequence("You become part of a community. Safety in numbers.\n" +
                "You contribute your skills. They give you shelter, food, and protection.\n" +
                "Your HP increases from the sense of belonging.", 
                22, -15)
        ));
        
        longfellowHall.addOption(new Option(
            "Join temporarily for supplies",
            new Consequence("You stay for a few days, gathering supplies and information.\n" +
                "You don't commit fully but you benefit from their resources.", 
                16, 0)
        ));
        
        longfellowHall.addOption(new Option(
            "Continue alone",
            new Consequence("Independence appeals to you. You don't need a group.\n" +
                "You leave and move on. Aggressiveness increases from solo determination.", 
                0, 16)
        ));
        
        map.addPosition(longfellowHall);
        
        // Position 21: North Gate - Escape Attempt
        Position northGate = new Position(
            "North Gate",
            "The main entrance to campus. A fortified gate stands before you.\n" +
            "Wrought iron, massive and imposing. It's locked from the inside.\n" +
            "On the other side: the outside world. Freedom.\n" +
            "Do you climb over or find another way?"
        );
        
        northGate.addOption(new Option(
            "Climb over the gate",
            new Consequence("You scale the gate with determination and strength.\n" +
                "Your muscles burn as you pull yourself up. You make it to the top.\n" +
                "You jump down on the other side. Your aggressiveness and strength grow.", 
                8, 22)
        ));
        
        northGate.addOption(new Option(
            "Find a gap in the fence",
            new Consequence("You locate a weak section in the perimeter fence.\n" +
                "You squeeze through carefully. Smart thinking.\n" +
                "Minor damage but safe passage. You're free.", 
                -8, 8)
        ));
        
        northGate.addOption(new Option(
            "Try to unlock the gate from inside",
            new Consequence("You search for a keypad or lock mechanism.\n" +
                "The system is complex and you can't figure it out.\n" +
                "Time is wasted. Frustration builds. Zombies approach.", 
                -24, 14)
        ));
        
        map.addPosition(northGate);
        
        // Position 22: South Commons - Supplies
        Position southCommons = new Position(
            "South Commons",
            "A common area with multiple vending machines and a food storage room.\n" +
            "The machines still have snacks visible through the glass.\n" +
            "The storage room is sealed with a heavy padlock.\n" +
            "Do you break in or use the machines?"
        );
        
        southCommons.addOption(new Option(
            "Break into the storage room with tools",
            new Consequence("You force the door open and find plenty of supplies.\n" +
                "Food rations. Medical kits. Hygiene items. Excellent haul.", 
                26, 12)
        ));
        
        southCommons.addOption(new Option(
            "Break the vending machines for snacks",
            new Consequence("You smash the glass. The machines still work partially.\n" +
                "You get snacks, chocolate, and protein bars.\n" +
                "Not ideal but sufficient. Some nutrition is better than none.", 
                10, 5)
        ));
        
        southCommons.addOption(new Option(
            "Search for a maintenance key",
            new Consequence("You spend time searching for keys. You find nothing.\n" +
                "The machines and storage remain locked. Time wasted.", 
                0, 0)
        ));
        
        map.addPosition(southCommons);
        
        // Position 23: East Campus - Zombie Den
        Position eastCampus = new Position(
            "East Campus",
            "Multiple zombies are gathered here. It's clearly their territory.\n" +
            "You count at least seven of them shambling about.\n" +
            "The stench of decay is overwhelming. This is dangerous.\n" +
            "Stealth or combat?"
        );
        
        eastCampus.addOption(new Option(
            "Move through stealthily and silently",
            new Consequence("You crouch low and move silently like a shadow.\n" +
                "You control your breathing. The zombies don't notice you.\n" +
                "You slip through undetected. Safe passage achieved.", 
                0, -8)
        ));
        
        eastCampus.addOption(new Option(
            "Charge through aggressively, guns blazing",
            new Consequence("You attack the zombie group. The fight is intense and brutal.\n" +
                "Zombies swarm you. You fight them off with savage determination.\n" +
                "You win but take significant damage. You're exhausted.", 
                -44, 32)
        ));
        
        eastCampus.addOption(new Option(
            "Try to sneak around the perimeter",
            new Consequence("You circle around the zombie den carefully.\n" +
                "It takes longer but you avoid direct confrontation.\n" +
                "You emerge unharmed but drained from the tension.", 
                2, 5)
        ));
        
        map.addPosition(eastCampus);
        
        // Position 24: West Quad - Meditation Moment
        Position westQuad = new Position(
            "West Quad",
            "An eerily peaceful section of campus surrounded by buildings.\n" +
            "No zombies. No threats. No sounds. Just silence.\n" +
            "The grass is green. A fountain still works. Birds sing.\n" +
            "Reality seems suspended here. Do you meditate and reflect?"
        );
        
        westQuad.addOption(new Option(
            "Meditate deeply and center yourself",
            new Consequence("You sit in silence and find inner peace.\n" +
                "Mental clarity returns. You find your center.\n" +
                "Mental aggressiveness decreases as peace fills you.", 
                16, -20)
        ));
        
        westQuad.addOption(new Option(
            "Sit and pray quietly",
            new Consequence("You pray for strength, for those you've lost, for survival.\n" +
                "Spiritual comfort fills you.\n" +
                "You feel connected to something larger than yourself.", 
                14, -18)
        ));
        
        westQuad.addOption(new Option(
            "Continue exploring immediately",
            new Consequence("You're paranoid. This peace feels unnatural.\n" +
                "You keep moving. Your aggressiveness spikes from constant vigilance.", 
                0, 12)
        ));
        
        map.addPosition(westQuad);
        
        // Position 25: Academic Quad - Knowledge Gain
        Position academicQuad = new Position(
            "Academic Quad",
            "The heart of campus. Open air. The silence is deafening.\n" +
            "You find scattered textbooks and research papers.\n" +
            "Biology, chemistry, virology texts. Knowledge everywhere.\n" +
            "Do you study?"
        );
        
        academicQuad.addOption(new Option(
            "Study the biology textbooks thoroughly",
            new Consequence("You gain medical knowledge about disease, immunity, and biology.\n" +
                "Understanding of the virus mechanics grows significantly.", 
                20, 12)
        ));
        
        academicQuad.addOption(new Option(
            "Study chemistry texts for potential weapons",
            new Consequence("You learn about chemical compounds and reactions.\n" +
                "Possibilities for creating anti-zombie weapons appear.\n" +
                "Knowledge is power.", 
                12, 18)
        ));
        
        academicQuad.addOption(new Option(
            "Don't waste time studying",
            new Consequence("Books are meaningless now. Survival is what matters.\n" +
                "You move on quickly.", 
                0, 5)
        ));
        
        map.addPosition(academicQuad);
        
        // Position 26: Tower Court - Heights Challenge
        Position towerCourt = new Position(
            "Tower Court",
            "A tall bell tower structure. Climbing it would give you a vantage point.\n" +
            "But the stairs are broken in places. The structure creaks in the wind.\n" +
            "From the top, you could see entire campus. You could see zombies coming.\n" +
            "But it's dangerous. Do you climb?"
        );
        
        towerCourt.addOption(new Option(
            "Climb carefully to the top",
            new Consequence("You scale the tower carefully, testing each step.\n" +
                "From the top, you see zombie movement patterns clearly.\n" +
                "Knowledge of their location gives you tactical advantage.", 
                14, 20)
        ));
        
        towerCourt.addOption(new Option(
            "Climb quickly and recklessly",
            new Consequence("You sprint up the stairs without caution.\n" +
                "You make it to the top but take damage from a fall.\n" +
                "Still, you see the terrain from above.", 
                -16, 25)
        ));
        
        towerCourt.addOption(new Option(
            "Stay on the ground",
            new Consequence("Too risky. The structure is unstable.\n" +
                "You remain grounded and safe. You lose tactical advantage.", 
                0, 0)
        ));
        
        map.addPosition(towerCourt);
        
        // Position 27: Cabot Hall - Mystery Door
        Position cabotHall = new Position(
            "Cabot Hall",
            "A basement door is locked with a digital keypad.\n" +
            "Red light. Locked. You have to guess the code.\n" +
            "Behind the door: humming sounds. Generator noise. Lights.\n" +
            "Someone—or something—is using power here. 3 attempts allowed."
        );
        
        Option codeOption = new Option("Attempt to guess the code");
        codeOption.addProbabilisticConsequence(
            new Consequence("You guess correctly on your second try! 2496!\n" +
                "The door hisses open. A underground bunker filled with supplies awaits.\n" +
                "Solar panels. Water filtration. Canned food. JACKPOT.", 
                35, 8),
            33
        );
        codeOption.addProbabilisticConsequence(
            new Consequence("Your guesses are wrong. Wrong! WRONG!\n" +
                "The keypad beeps angrily and locks permanently.\n" +
                "Access denied forever. You move on empty-handed.", 
                0, 0),
            67
        );
        
        cabotHall.addOption(codeOption);
        
        cabotHall.addOption(new Option(
            "Ignore the door and leave",
            new Consequence("Too risky. You don't have time for guessing games.\n" +
                "You leave the basement and move on.", 
                0, 0)
        ));
        
        map.addPosition(cabotHall);
        
        // Position 28: Emerson Hall - Literary Escape
        Position emersonHall = new Position(
            "Emerson Hall",
            "A library of rare books and manuscripts. Leather-bound classics.\n" +
            "One book on a pedestal seems to glow faintly with blue light.\n" +
            "The title is unreadable but the energy is palpable.\n" +
            "Do you take it?"
        );
        
        emersonHall.addOption(new Option(
            "Take the glowing book",
            new Consequence("The book pulses with strange, ancient energy.\n" +
                "You feel enlightened and empowered.\n" +
                "Knowledge and power flow through you. The book feels warm in your hands.", 
                24, 14)
        ));
        
        emersonHall.addOption(new Option(
            "Read the book but don't take it",
            new Consequence("You read passages from the glowing tome.\n" +
                "The words are cryptic but powerful. They make you think.\n" +
                "You gain some knowledge but leave the book behind.", 
                10, 5)
        ));
        
        emersonHall.addOption(new Option(
            "Leave the book behind",
            new Consequence("Too strange. Too unusual. You leave it and continue.\n" +
                "Better safe than sorry. The light fades as you leave.", 
                0, 0)
        ));
        
        map.addPosition(emersonHall);
        
        // Position 29: Jewell Hall - Trap Avoided
        Position jewelHall = new Position(
            "Jewell Hall",
            "The floor ahead looks unstable. Wood is rotted. Boards are broken.\n" +
            "You can see through the gaps to the floor below. It's a long drop.\n" +
            "Do you cross carefully or find a detour?"
        );
        
        jewelHall.addOption(new Option(
            "Cross carefully, testing each board",
            new Consequence("You test each board before stepping.\n" +
                "The floor holds. Slow but safe and methodical.\n" +
                "You reach the other side unharmed.", 
                4, 0)
        ));
        
        jewelHall.addOption(new Option(
            "Take the detour through the window",
            new Consequence("You exit through a window and circle around.\n" +
                "Takes longer and is harder, but guarantees safety.\n" +
                "You emerge from a difficult external path.", 
                2, -8)
        ));
        
        jewelHall.addOption(new Option(
            "Sprint across the floor at full speed",
            new Consequence("You run fast, betting the floor can hold.\n" +
                "Halfway across, wood gives way. You fall through!\n" +
                "You grab the edge and pull yourself up. Severe damage taken.", 
                -48, 16)
        ));
        
        map.addPosition(jewelHall);
        
        // Position 30: Freeman Dormitory - Friend or Foe
        Position freemanDormitory = new Position(
            "Freeman Dormitory",
            "You hear a voice calling for help from inside.\n" +
            "A woman's voice. Young. Terrified. Desperate.\n" +
            "'Please! Help me! There's someone here!'\n" +
            "Is it a human survivor or a zombie trap designed to lure prey?"
        );
        
        Option trustOption = new Option("Investigate the voice");
        trustOption.addProbabilisticConsequence(
            new Consequence("It's a real survivor! A woman trapped by zombies.\n" +
                "You rescue her from the dormitory.\n" +
                "She has supplies, knowledge, and profound gratitude.", 
                22, -8),
            50
        );
        trustOption.addProbabilisticConsequence(
            new Consequence("It's a trap! Zombies swarm you from hidden corners!\n" +
                "You fight them off but take heavy damage.\n" +
                "You escape but you're badly wounded. Never trust sounds.", 
                -52, 28),
            50
        );
        
        freemanDormitory.addOption(trustOption);
        
        freemanDormitory.addOption(new Option(
            "Ignore the voice and move on",
            new Consequence("You can't risk it. Traps are common now.\n" +
                "You leave the dormitory. The voice fades. You may have made a mistake.", 
                0, 8)
        ));
        
        map.addPosition(freemanDormitory);
        
        // Position 31: Houghton Chapel - Spiritual Moment
        Position houghtonChapel = new Position(
            "Houghton Chapel",
            "A serene chapel untouched by the chaos and violence outside.\n" +
            "Stained glass windows filter light into colored patterns.\n" +
            "The air is quiet. The atmosphere is sacred.\n" +
            "Do you find solace in prayer or move on quickly?"
        );
        
        houghtonChapel.addOption(new Option(
            "Pray deeply for guidance and strength",
            new Consequence("You kneel and pray for strength, for those lost, for survival.\n" +
                "Spiritual peace fills you. You find inner strength.\n" +
                "Your HP increases from the mental respite and spiritual connection.", 
                20, -12)
        ));
        
        houghtonChapel.addOption(new Option(
            "Sit quietly in contemplation",
            new Consequence("You sit in the pew and contemplate your life.\n" +
                "The weight of the apocalypse feels lighter for a moment.\n" +
                "You gain perspective on your journey.", 
                12, -10)
        ));
        
        houghtonChapel.addOption(new Option(
            "Move on immediately",
            new Consequence("No time for spirituality. Prayer won't save you.\n" +
                "Action and survival matter. You leave quickly.", 
                0, 5)
        ));
        
        map.addPosition(houghtonChapel);
        
        // Position 32: Wellesley Square - Market
        Position wellesleySquare = new Position(
            "Wellesley Square",
            "An abandoned market area with shops. Storefronts line the streets.\n" +
            "Clothing stores. Electronics. A pharmacy. A grocery store.\n" +
            "Windows are broken. Doors are open. Goods are scattered.\n" +
            "Do you loot the stores?"
        );
        
        wellesleySquare.addOption(new Option(
            "Thoroughly loot the stores",
            new Consequence("You systematically search each store.\n" +
                "Clothing. Tools. Canned goods. First aid supplies. Medicine.\n" +
                "Significant supplies gathered. You load yourself well.", 
                28, 8)
        ));
        
        wellesleySquare.addOption(new Option(
            "Take only essentials and leave quickly",
            new Consequence("You grab water, food, and basic supplies.\n" +
                "You move fast. Better to leave before zombies arrive.", 
                10, 4)
        ));
        
        wellesleySquare.addOption(new Option(
            "Stay to search the pharmacy thoroughly",
            new Consequence("You spend significant time in the pharmacy.\n" +
                "You find antibiotics, painkillers, and medical supplies.\n" +
                "Great medical resources but zombies detect you.", 
                20, 18)
        ));
        
        map.addPosition(wellesleySquare);
        
        // Position 33: Margaret Freeman Hall - Combat Training
        Position margaretFreemanHall = new Position(
            "Margaret Freeman Hall",
            "A gym facility. Weights and training equipment are available.\n" +
            "Free weights. Treadmills. Rowing machines. A boxing ring.\n" +
            "Your muscles feel weak. Your body is weakening from lack of exercise.\n" +
            "Do you train?"
        );
        
        margaretFreemanHall.addOption(new Option(
            "Intensive workout session",
            new Consequence("You spend hours training intensely.\n" +
                "Your muscles burn and strengthen. Sweat pours from you.\n" +
                "Your strength and aggressiveness increase significantly.", 
                16, 32)
        ));
        
        margaretFreemanHall.addOption(new Option(
            "Light stretching and movement",
            new Consequence("Gentle exercise maintains your baseline fitness.\n" +
                "You feel limber but not stronger.\n" +
                "Modest gains.", 
                8, 8)
        ));
        
        margaretFreemanHall.addOption(new Option(
            "Bag work and combat drills",
            new Consequence("You practice punching and combat techniques.\n" +
                "Fighting feels natural. Your combat instinct sharpens.\n" +
                "Aggressiveness spikes. HP improves from exercise.", 
                12, 28)
        ));
        
        map.addPosition(margaretFreemanHall);
        
        // Position 34: Doll House - Eerie Artifacts
        Position dollHouse = new Position(
            "Doll House",
            "An old doll museum. Dolls with blank faces stare at you from shelves.\n" +
            "Porcelain dolls. Cloth dolls. Vintage dolls.\n" +
            "Their eyes seem to follow you. The atmosphere is unsettling.\n" +
            "Do you search for valuables?"
        );
        
        dollHouse.addOption(new Option(
            "Search thoroughly despite the creepiness",
            new Consequence("You push through the discomfort and search.\n" +
                "You find a music box worth something.\n" +
                "Also find antique jewelry and coins. Valuable for trading.", 
                18, -12)
        ));
        
        dollHouse.addOption(new Option(
            "Leave quickly",
            new Consequence("The atmosphere is too creepy. Too wrong.\n" +
                "You exit without finding anything. Your instincts say go.", 
                0, 8)
        ));
        
        dollHouse.addOption(new Option(
            "Destroy the dolls in frustration",
            new Consequence("Something about them unnerves you. You smash them.\n" +
                "You destroy doll after doll. It feels therapeutic.\n" +
                "You escape but feel drained. No supplies found.", 
                -10, 15)
        ));
        
        map.addPosition(dollHouse);
        
        // Position 35: Knapton House - Safe Room
        Position knaptOnHouse = new Position(
            "Knapton House",
            "A well-fortified house. Reinforced doors. Boarded windows.\n" +
            "Signs of previous survivors everywhere. Food containers. Bedding. Weapons.\n" +
            "It's been set up for survival. Someone knew what they were doing.\n" +
            "Do you settle in for the night?"
        );
        
        knaptOnHouse.addOption(new Option(
            "Stay the night and rest deeply",
            new Consequence("You find clean bedding and rest deeply.\n" +
                "Sleep restores you completely. You wake refreshed.\n" +
                "Recovery is significant. You find supplies to take with you.", 
                30, -12)
        ));
        
        knaptOnHouse.addOption(new Option(
            "Rest briefly and leave",
            new Consequence("A short nap restores you.\n" +
                "You move on with renewed energy.", 
                12, 0)
        ));
        
        knaptOnHouse.addOption(new Option(
            "Don't stay. Keep moving",
            new Consequence("Staying in one place feels dangerous.\n" +
                "You keep moving. Your aggressiveness spikes.", 
                0, 12)
        ));
        
        map.addPosition(knaptOnHouse);
        
        // Position 36: Pittman Hall - Infected Supplies
        Position pittmanHall = new Position(
            "Pittman Hall",
            "An old residence hall. Supplies are available on a table.\n" +
            "Canned food. Water bottles. Medicine. But they smell strange.\n" +
            "A sickly sweet odor. Contamination? Decay? Mold?\n" +
            "You're hungry. Will you risk it?"
        );
        
        Option suppliesOption = new Option("Take the supplies anyway");
        suppliesOption.addProbabilisticConsequence(
            new Consequence("They're actually fine! Just old and poorly stored.\n" +
                "Good supplies gained. You feel relieved and fed.", 
                18, 2),
            60
        );
        suppliesOption.addProbabilisticConsequence(
            new Consequence("The supplies are spoiled. You get severe food poisoning.\n" +
                "You spend hours vomiting and weak.", 
                -35, -8),
            40
        );
        
        pittmanHall.addOption(suppliesOption);
        
        pittmanHall.addOption(new Option(
            "Avoid the supplies and move on",
            new Consequence("Better safe than sorry.\n" +
                "You leave the supplies untouched.", 
                0, 5)
        ));
        
        map.addPosition(pittmanHall);
        
        // Position 37: Simmons Hall - Weapon Cache
        Position simmonsHall = new Position(
            "Simmons Hall",
            "An armory has been hidden here in a locked cabinet.\n" +
            "You can see through the glass: pistols, shotguns, rifles, ammunition.\n" +
            "An arsenal. Enough to arm an entire group.\n" +
            "Do you take them all?"
        );
        
        simmonsHall.addOption(new Option(
            "Take the weapons and load up heavily",
            new Consequence("You arm yourself with multiple weapons.\n" +
                "Guns strapped across your body. Ammunition in your pack.\n" +
                "Aggressiveness and confidence spike dramatically.", 
                12, 38)
        ));
        
        simmonsHall.addOption(new Option(
            "Take only one gun and supplies",
            new Consequence("One weapon is enough. You're mobile and effective.\n" +
                "Balanced approach between power and mobility.", 
                8, 18)
        ));
        
        simmonsHall.addOption(new Option(
            "Take grenades and explosives",
            new Consequence("You grab grenades and TNT.\n" +
                "Explosives are powerful but unstable.\n" +
                "High risk, high reward.", 
                5, 32)
        ));
        
        map.addPosition(simmonsHall);
        
        // Position 38: Tower Campus - Observation Point
        Position towerCampus = new Position(
            "Tower Campus",
            "A tall academic building with a 200-foot tower.\n" +
            "From the roof, you could see the entire surrounding area.\n" +
            "But the stairs are long and the building is exposed.\n" +
            "Do you climb up?"
        );
        
        towerCampus.addOption(new Option(
            "Climb to the roof carefully",
            new Consequence("You climb carefully. Each step is methodical.\n" +
                "From the roof, you see zombie patterns and movement routes.\n" +
                "Tactical knowledge gained. You understand the terrain now.", 
                16, 20)
        ));
        
        towerCampus.addOption(new Option(
            "Climb quickly to save time",
            new Consequence("You sprint up the stairs. Your heart pounds.\n" +
                "You reach the roof and gasp for air.\n" +
                "You see the patterns but take minor damage from exertion.", 
                -10, 20)
        ));
        
        towerCampus.addOption(new Option(
            "Avoid climbing",
            new Consequence("Better to avoid exposure on a tall structure.\n" +
                "You stay ground-level and move on.", 
                0, 0)
        ));
        
        map.addPosition(towerCampus);
        
        // Position 39: Cutter House - Ancient Text
        Position cutterHouse = new Position(
            "Cutter House",
            "A research house. An ancient text about historical plagues is on a shelf.\n" +
            "The Black Death. Spanish Flu. Malaria outbreaks.\n" +
            "Could this contain insights about the current outbreak?\n" +
            "The author seems to have been obsessed with epidemiology."
        );
        
        cutterHouse.addOption(new Option(
            "Read the ancient text thoroughly",
            new Consequence("You spend hours reading. The parallels are striking.\n" +
                "You understand patterns in disease spread, transmission, and control.\n" +
                "Knowledge becomes your weapon.", 
                22, 12)
        ));
        
        cutterHouse.addOption(new Option(
            "Skim the text quickly",
            new Consequence("You get a general sense but miss important details.\n" +
                "Minor knowledge gain.", 
                8, 3)
        ));
        
        cutterHouse.addOption(new Option(
            "Skip the reading",
            new Consequence("Too old. Probably irrelevant to your survival.\n" +
                "You move on.", 
                0, 0)
        ));
        
        map.addPosition(cutterHouse);
        
        // Position 40: Acorn House - Hidden Passage
        Position acornHouse = new Position(
            "Acorn House",
            "You find a hidden passage in the basement behind loose bricks.\n" +
            "It descends into darkness. Where does it lead?\n" +
            "The passage smells of earth and age. Ancient.\n" +
            "Do you explore it?"
        );
        
        Option passageOption = new Option("Follow the passage into the darkness");
        passageOption.addProbabilisticConsequence(
            new Consequence("It leads to an underground network connecting buildings!\n" +
                "A safe route to move without exposure. Valuable discovery.\n" +
                "You mark it mentally as an escape route.", 
                24, 8),
            70
        );
        passageOption.addProbabilisticConsequence(
            new Consequence("The passage collapses! You're trapped briefly.\n" +
                "You escape but take severe damage from falling debris.", 
                -35, 10),
            30
        );
        
        acornHouse.addOption(passageOption);
        
        acornHouse.addOption(new Option(
            "Avoid the passage",
            new Consequence("Too risky. Unknown dangers in the dark.\n" +
                "You leave the house. Safety in caution.", 
                0, 8)
        ));
        
        map.addPosition(acornHouse);
        
        // Position 41: Blackwood House - Dark Energy
        Position blackwoodHouse = new Position(
            "Blackwood House",
            "The air feels heavy here. Something is deeply wrong.\n" +
            "Symbols on the walls. Candles burned to stubs.\n" +
            "Evidence of rituals. Of something unnatural.\n" +
            "Do you investigate or trust your instincts and leave?"
        );
        
        blackwoodHouse.addOption(new Option(
            "Investigate the dark energy thoroughly",
            new Consequence("You find evidence of dark rituals and ceremonies.\n" +
                "Notes about experiments. Control. Power.\n" +
                "Aggressiveness spikes from fear and anger at what you've discovered.", 
                -8, 35)
        ));
        
        blackwoodHouse.addOption(new Option(
            "Leave immediately",
            new Consequence("Your instincts scream at you to go.\n" +
                "You trust them and leave immediately.", 
                0, 12)
        ));
        
        blackwoodHouse.addOption(new Option(
            "Destroy the ritual items",
            new Consequence("You smash the candles and tear down the symbols.\n" +
                "It feels cathartic and righteous.\n" +
                "But you take minor damage from sharp materials.", 
                -12, 25)
        ));
        
        map.addPosition(blackwoodHouse);
        
        // Position 42: Stone Ridge House - Puzzle Lock
        Position stoneRidgeHouse = new Position(
            "Stone Ridge House",
            "A historic mansion with a locked study door.\n" +
            "A combination lock with three rotating dials.\n" +
            "Behind the door: evidence of a safe.\n" +
            "Can you figure out the code? You have unlimited attempts."
        );
        
        Option lockOption = new Option("Try to crack the combination");
        lockOption.addProbabilisticConsequence(
            new Consequence("You solve it! The lock clicks open.\n" +
                "The door opens to reveal a hidden room with supplies.\n" +
                "Weapons, food, water, documents. Significant treasure.", 
                32, 12),
            40
        );
        lockOption.addProbabilisticConsequence(
            new Consequence("You work on the lock for hours.\n" +
                "You never figure it out. Time wasted.\n" +
                "You leave frustrated.", 
                -10, 3),
            60
        );
        
        stoneRidgeHouse.addOption(lockOption);
        
        stoneRidgeHouse.addOption(new Option(
            "Force the door open with tools",
            new Consequence("You use a crowbar and hammer to force it.\n" +
                "The door gives way. You access supplies inside.\n" +
                "Not as much as if you'd unlocked it, but something.", 
                16, 8)
        ));
        
        map.addPosition(stoneRidgeHouse);
        
        // Position 43: Lakeside Cottage - Water Source
        Position lakesideCottage = new Position(
            "Lakeside Cottage",
            "A cottage nestled by the water. Fresh water source nearby.\n" +
            "The lake is calm. The air is fresh. No zombies visible.\n" +
            "This is a peaceful sanctuary.\n" +
            "Do you collect water and stay, or move on?"
        );
        
        lakesideCottage.addOption(new Option(
            "Stay and collect water extensively",
            new Consequence("Fresh water invigorates you completely.\n" +
                "You fill containers. You bathe. You hydrate.\n" +
                "Your HP increases significantly. You feel alive.", 
                28, -5)
        ));
        
        lakesideCottage.addOption(new Option(
            "Fill bottles and move on quickly",
            new Consequence("Quick refill. You collect water and continue your journey.\n" +
                "Efficient. No wasted time.", 
                12, 0)
        ));
        
        lakesideCottage.addOption(new Option(
            "Stay overnight by the water",
            new Consequence("You camp by the cottage. Sleep comes easy.\n" +
                "The sound of water is soothing. You rest deeply.", 
                24, -10)
        ));
        
        map.addPosition(lakesideCottage);
        
        // Position 44: Forest Path - Navigation Challenge
        Position forestPath = new Position(
            "Forest Path",
            "Dense woods surround you. Towering trees. Thick undergrowth.\n" +
            "Easy to get lost. No clear path forward.\n" +
            "You must choose how to navigate this wilderness."
        );
        
        forestPath.addOption(new Option(
            "Trust your instincts and navigate by feeling",
            new Consequence("Your gut feeling guides you true.\n" +
                "You navigate successfully through the woods.\n" +
                "Your instincts have not failed you.", 
                2, 16)
        ));
        
        forestPath.addOption(new Option(
            "Move cautiously, marking your path",
            new Consequence("Slow but steady. You mark trees as you go.\n" +
                "You avoid getting lost through careful planning.", 
                8, 2)
        ));
        
        forestPath.addOption(new Option(
            "Climb a tree for perspective",
            new Consequence("You climb high for a vantage point.\n" +
                "You see the path forward clearly.\n" +
                "Knowledge is gained but it takes time and energy.", 
                -12, 15)
        ));
        
        map.addPosition(forestPath);
        
        // Position 45: Wilderness Camp - Survival Test
        Position wildernesscamp = new Position(
            "Wilderness Camp",
            "An abandoned campsite with remnants of civilization.\n" +
            "A tent. Firewood. Cooking supplies. Supplies scattered about.\n" +
            "This is perfect for survival and recovery.\n" +
            "Do you set up camp here?"
        );
        
        wildernesscamp.addOption(new Option(
            "Establish a base camp for several days",
            new Consequence("You build shelter, gather resources, and establish supplies.\n" +
                "You're now safe and well-supplied.\n" +
                "You feel secure for the first time in days.", 
                32, -8)
        ));
        
        wildernesscamp.addOption(new Option(
            "Take supplies and move on",
            new Consequence("You grab what you can carry.\n" +
                "Mobile and ready. You continue your journey.", 
                16, 8)
        ));
        
        wildernesscamp.addOption(new Option(
            "Sleep here one night only",
            new Consequence("You rest for the night but leave at dawn.\n" +
                "Balanced approach.", 
                14, 2)
        ));
        
        map.addPosition(wildernesscamp);
        
        // Position 46: Mountain Overlook - Perspective Shift
        Position mountainOverlook = new Position(
            "Mountain Overlook",
            "From here, you can see for many miles in all directions.\n" +
            "The world spreads before you. Mountains. Valleys. Forests.\n" +
            "The scale is overwhelming. You're just one person.\n" +
            "Take time to think?"
        );
        
        mountainOverlook.addOption(new Option(
            "Meditate deeply on your journey",
            new Consequence("You sit in silence and reflect.\n" +
                "Clarity and perspective return. You understand yourself better.\n" +
                "Your spirit is renewed and aggressiveness decreases.", 
                22, -18)
        ));
        
        mountainOverlook.addOption(new Option(
            "Pray or find spiritual connection",
            new Consequence("You pray to the universe. To whatever listens.\n" +
                "Spiritual comfort fills you.\n" +
                "The weight of survival feels lighter.", 
                18, -15)
        ));
        
        mountainOverlook.addOption(new Option(
            "Keep moving",
            new Consequence("No time for reflection. Survival first.\n" +
                "Your aggressiveness spikes from constant vigilance.", 
                0, 8)
        ));
        
        map.addPosition(mountainOverlook);
        
        // Position 47: Ravine Path - Danger Zone
        Position ravinePath = new Position(
            "Ravine Path",
            "A narrow path along a deep ravine. Sheer drops on both sides.\n" +
            "One slip means a fatal fall into darkness.\n" +
            "The path is only three feet wide in places.\n" +
            "Cross carefully or find another route?"
        );
        
        Option ravineOption = new Option("Cross the ravine carefully and methodically");
        ravineOption.addProbabilisticConsequence(
            new Consequence("You focus intensely and cross carefully.\n" +
                "Each step is deliberate. Calm under pressure.\n" +
                "You reach the other side safely.", 
                2, 14),
            75
        );
        ravineOption.addProbabilisticConsequence(
            new Consequence("You slip! Your foot slides on loose rock.\n" +
                "You fall toward the ravine but barely catch yourself.\n" +
                "Close call. Very close. Moderate damage from the shock.", 
                -40, 22),
            25
        );
        
        ravinePath.addOption(ravineOption);
        
        ravinePath.addOption(new Option(
            "Search for a detour around the ravine",
            new Consequence("You spend time looking for another route.\n" +
                "You find one but it adds hours to your journey.", 
                0, -3)
        ));
        
        map.addPosition(ravinePath);
        
        // Position 48: Ancient Ruin - Artifact Discovery
        Position ancientRuin = new Position(
            "Ancient Ruin",
            "Old stone structures. Archaeological artifacts scattered everywhere.\n" +
            "Pottery. Weapons. Jewelry. A civilization long forgotten.\n" +
            "Some items are valuable. Some are cursed.\n" +
            "Search for valuable items?"
        );
        
        ancientRuin.addOption(new Option(
            "Excavate artifacts systematically",
            new Consequence("You find a valuable artifact: an ancient amulet.\n" +
                "Could be worth something to collectors or researchers.\n" +
                "You feel the weight of history in your hands.", 
                24, 10)
        ));
        
        ancientRuin.addOption(new Option(
            "Move through quickly",
            new Consequence("The ruins are stable but uninteresting.\n" +
                "Nothing valuable found. You continue on.", 
                0, 0)
        ));
        
        ancientRuin.addOption(new Option(
            "Destroy the artifacts in frustration",
            new Consequence("Something about the ruins angers you.\n" +
                "You smash pottery and weapons.\n" +
                "It's cathartic but yields nothing of value.", 
                -16, 12)
        ));
        
        map.addPosition(ancientRuin);
        
        // Position 49: Hidden Sanctuary - Safe Heaven
        Position hiddenSanctuary = new Position(
            "Hidden Sanctuary",
            "A perfectly hidden sanctuary deep in the woods.\n" +
            "Other survivors have built a thriving community here.\n" +
            "Tents. Gardens. Defensive positions. Organization.\n" +
            "Do you join them or keep your independence?"
        );
        
        hiddenSanctuary.addOption(new Option(
            "Join the sanctuary permanently",
            new Consequence("You become part of a community.\n" +
                "You find peace, purpose, and belonging.\n" +
                "Your HP increases significantly from safety and friendship.", 
                36, -20)
        ));
        
        hiddenSanctuary.addOption(new Option(
            "Join temporarily for rest and supplies",
            new Consequence("You stay a few days, gaining rest and supplies.\n" +
                "You don't commit fully but you benefit greatly.", 
                22, -8)
        ));
        
        hiddenSanctuary.addOption(new Option(
            "Stay independent and move on",
            new Consequence("Freedom matters more than safety.\n" +
                "You continue solo. Aggressiveness increases.", 
                0, 22)
        ));
        
        map.addPosition(hiddenSanctuary);
        
        // Position 50: Final Checkpoint - Redemption
        Position finalCheckpoint = new Position(
            "Final Checkpoint",
            "The last known outpost before the beyond.\n" +
            "Supplies are limited. A final decision awaits.\n" +
            "What will define you in these final moments?"
        );
        
        finalCheckpoint.addOption(new Option(
            "Take the remaining supplies greedily",
            new Consequence("You gather everything useful.\n" +
                "Prepared for whatever comes next.\n" +
                "You feel ready and powerful.", 
                24, 14)
        ));
        
        finalCheckpoint.addOption(new Option(
            "Leave supplies for other survivors",
            new Consequence("Compassion overrides your need.\n" +
                "You think of future survivors who will need these supplies.\n" +
                "Your humanity shines through the darkness.", 
                0, -28)
        ));
        
        finalCheckpoint.addOption(new Option(
            "Take only what you need",
            new Consequence("Balanced approach. You take essentials.\n" +
                "You feel responsible but not greedy.", 
                10, 5)
        ));
        
        map.addPosition(finalCheckpoint);
        
        // Position 51: Ethereal Realm - Beyond the Veil
        Position etherealRealm = new Position(
            "Ethereal Realm",
            "A place that shouldn't exist. Reality bends here in impossible ways.\n" +
            "Colors that have no names. Sounds that echo from nowhere.\n" +
            "This is beyond normal. Beyond the apocalypse itself.\n" +
            "Is this heaven or hell or something else entirely?"
        );
        
        etherealRealm.addOption(new Option(
            "Embrace the ethereal power completely",
            new Consequence("You accept the strange energy flowing through the realm.\n" +
                "Power floods your body. Consciousness expands.\n" +
                "You feel invincible. Aggressiveness spikes dangerously high.", 
                18, 40)
        ));
        
        etherealRealm.addOption(new Option(
            "Resist and find the way out",
            new Consequence("You focus on escaping this strange place.\n" +
                "Reality stabilizes. Your feet find solid ground.\n" +
                "You're confused but alive.", 
                12, 8)
        ));
        
        etherealRealm.addOption(new Option(
            "Question everything and observe",
            new Consequence("You don't resist or accept. You simply observe.\n" +
                "Knowledge of the realm's nature comes to you.\n" +
                "You gain perspective on the apocalypse itself.", 
                10, 5)
        ));
        
        map.addPosition(etherealRealm);
        
        // Position 52: Temporal Anomaly - Time Loop
        Position temporalAnomaly = new Position(
            "Temporal Anomaly",
            "Events seem to repeat exactly. Every moment has happened before.\n" +
            "You're stuck in a time loop. Same conversations. Same actions.\n" +
            "Are you destined to repeat forever?\n" +
            "Do you accept your fate or fight to break free?"
        );
        
        temporalAnomaly.addOption(new Option(
            "Accept the loop and find peace within it",
            new Consequence("Acceptance brings unexpected peace.\n" +
                "You find calm in the chaos of repetition.\n" +
                "Mental aggressiveness decreases as you surrender.", 
                18, -22)
        ));
        
        temporalAnomaly.addOption(new Option(
            "Fight desperately to break the loop",
            new Consequence("You struggle against the temporal bonds.\n" +
                "Every moment you fight harder. Rage builds.\n" +
                "Aggressiveness explodes but you take damage from the effort.", 
                -8, 38)
        ));
        
        temporalAnomaly.addOption(new Option(
            "Manipulate the loop to your advantage",
            new Consequence("You begin to understand the loop's patterns.\n" +
                "You manipulate them for supplies and knowledge.\n" +
                "You become a master of this strange place.", 
                20, 15)
        ));
        
        map.addPosition(temporalAnomaly);
        
        // Position 53: Crystal Cavern - Mystical Energy
        Position crystalCavern = new Position(
            "Crystal Cavern",
            "Massive crystals grow from the cavern walls and floor.\n" +
            "They glow with inner light in colors you've never seen.\n" +
            "The energy pulses. It's alive. It's aware of you.\n" +
            "Do you harness this power?"
        );
        
        crystalCavern.addOption(new Option(
            "Absorb the crystal energy fully",
            new Consequence("Power floods your body from head to toe.\n" +
                "You feel invincible. Unstoppable. Divine.\n" +
                "The crystals resonate with your soul.", 
                32, 28)
        ));
        
        crystalCavern.addOption(new Option(
            "Take samples of the crystals",
            new Consequence("You carefully harvest crystal fragments.\n" +
                "Valuable. Powerful. But difficult to carry.\n" +
                "You gain resources but at a cost.", 
                16, 12)
        ));
        
        crystalCavern.addOption(new Option(
            "Leave the crystals alone",
            new Consequence("Some power is too dangerous. Too unknown.\n" +
                "You move on without touching them.\n" +
                "Better safe than sorry.", 
                8, 8)
        ));
        
        map.addPosition(crystalCavern);
        
        // Position 54: Shadowland - Dark Test
        Position shadowland = new Position(
            "Shadowland",
            "Darkness surrounds you. Total darkness. Nothing is visible.\n" +
            "Not just absence of light. Active darkness that presses against you.\n" +
            "The shadows seem to have weight and intention.\n" +
            "Push through or turn back?"
        );
        
        shadowland.addOption(new Option(
            "Push through the darkness with determination",
            new Consequence("You move forward. Fear grips you but you continue.\n" +
                "You emerge on the other side. Mentally stronger but physically weaker.\n" +
                "You've faced the darkness itself and survived.", 
                -24, 32)
        ));
        
        shadowland.addOption(new Option(
            "Create light to guide your way",
            new Consequence("You create fire or find a light source.\n" +
                "The shadows retreat from the light.\n" +
                "You navigate through with confidence.", 
                8, 15)
        ));
        
        shadowland.addOption(new Option(
            "Turn back immediately",
            new Consequence("This darkness is too much. Too unnatural.\n" +
                "You find another path. Caution preserves your sanity.", 
                0, 10)
        ));
        
        map.addPosition(shadowland);
        
        // Position 55: Divine Temple - Transcendence
        Position divineTemple = new Position(
            "Divine Temple",
            "A sacred place beyond explanation. Divine presence is felt.\n" +
            "The air is pure. The light is golden. Time feels different here.\n" +
            "This is a place of ultimate peace or ultimate judgment.\n" +
            "Do you seek transcendence?"
        );
        
        divineTemple.addOption(new Option(
            "Seek transcendence through meditation",
            new Consequence("You connect with something greater than yourself.\n" +
                "Understanding flows through you. Peace and power merge.\n" +
                "You're transformed by the connection.", 
                36, 20)
        ));
        
        divineTemple.addOption(new Option(
            "Pray for forgiveness and salvation",
            new Consequence("You confess your sins. All of them.\n" +
                "Forgiveness washes over you. Guilt dissolves.\n" +
                "Your spirit is renewed. Aggressiveness decreases.", 
                28, -25)
        ));
        
        divineTemple.addOption(new Option(
            "Remain grounded in material world",
            new Consequence("Spirituality is not your path. You understand that.\n" +
                "You respect the space but don't try to transcend.\n" +
                "You leave at peace with yourself.", 
                8, 2)
        ));
        
        map.addPosition(divineTemple);
        
        // Position 56: Inferno Gauntlet - Trial by Fire
        Position infernoGauntlet = new Position(
            "Inferno Gauntlet",
            "Flames surround you on all sides. A wall of fire blocks every path.\n" +
            "Heat is unbearable. Your skin burns. The air is toxic with smoke.\n" +
            "This is hell itself. Sprint through or find shelter?\n" +
            "Time is running out."
        );
        
        Option fireOption = new Option("Sprint through the fire with all your might");
        fireOption.addProbabilisticConsequence(
            new Consequence("You move fast and furious through the flames.\n" +
                "Your body is singed but you make it through!\n" +
                "You're alive. Barely. Covered in burns but alive.", 
                -35, 35),
            70
        );
        fireOption.addProbabilisticConsequence(
            new Consequence("The flames consume you. Agony beyond measure.\n" +
                "Your journey ends in fire. The apocalypse claims another victim.", 
                -100, 0, true, false, false),
            30
        );
        
        infernoGauntlet.addOption(fireOption);
        
        infernoGauntlet.addOption(new Option(
            "Find shelter and wait out the fire",
            new Consequence("You locate a fireproof bunker or cave.\n" +
                "You survive the inferno. Patience saved you.", 
                10, 5)
        ));
        
        map.addPosition(infernoGauntlet);
        
        // Position 57: Frozen Abyss - Hypothermia Risk
        Position frozenAbyss = new Position(
            "Frozen Abyss",
            "Temperature drops below zero. Ice covers everything.\n" +
            "Your breath freezes in the air. Your fingers lose feeling.\n" +
            "Hypothermia looms. Snow falls. The wind howls.\n" +
            "Can you survive this frozen hell?"
        );
        
        frozenAbyss.addOption(new Option(
            "Find shelter quickly in a cave or structure",
            new Consequence("You locate a cave with insulation from the cold.\n" +
                "You build a fire. Warmth returns to your body.\n" +
                "You survive the cold. Shelter saved you.", 
                18, -8)
        ));
        
        frozenAbyss.addOption(new Option(
            "Keep moving to generate body heat",
            new Consequence("Motion generates heat. You move constantly.\n" +
                "Your muscles burn but hypothermia stays at bay.\n" +
                "You stay ahead of death through movement.", 
                12, 22)
        ));
        
        frozenAbyss.addOption(new Option(
            "Dig into snow for insulation",
            new Consequence("You create a snow shelter. It's not perfect but it works.\n" +
                "You survive the night. Adaptation saved you.", 
                8, 8)
        ));
        
        map.addPosition(frozenAbyss);
        
        // Position 58: Mirage Desert - Reality Check
        Position mirageDesert = new Position(
            "Mirage Desert",
            "Nothing but sand and heat in all directions.\n" +
            "Temperature soars above 120 degrees. You're hallucinating.\n" +
            "Mirages appear and disappear. Water that isn't there.\n" +
            "Trust your mind or your instincts?"
        );
        
        mirageDesert.addOption(new Option(
            "Trust your instincts over your mind",
            new Consequence("Your senses guide you true despite the illusions.\n" +
                "You find an oasis. Real water and shade.\n" +
                "Instinct survives where logic would fail.", 
                24, 8)
        ));
        
        mirageDesert.addOption(new Option(
            "Trust your logic and map reading",
            new Consequence("You analyze the terrain carefully despite hallucinations.\n" +
                "You navigate methodically.\n" +
                "Slow but steady progress through the desert.", 
                14, 3)
        ));
        
        mirageDesert.addOption(new Option(
            "Chase a mirage hoping it's real",
            new Consequence("You follow a phantom. Hours of walking wasted.\n" +
                "You collapse in despair.\n" +
                "The desert has defeated you.", 
                -54, -15)
        ));
        
        map.addPosition(mirageDesert);
        
        // Position 59: Abyssal Depths - Underwater Quest
        Position abyssalDepths = new Position(
            "Abyssal Depths",
            "You're underwater in an abyss. Strange creatures swim nearby.\n" +
            "Bioluminescent organisms. Creatures from nightmares.\n" +
            "An ancient artifact glints on the seafloor far below.\n" +
            "Find the artifact or escape to the surface?"
        );
        
        abyssalDepths.addOption(new Option(
            "Dive deep for the ancient artifact",
            new Consequence("You descend into the abyss.\n" +
                "You find an ancient artifact of immense power.\n" +
                "You barely make it back to the surface. Exhausted but triumphant.", 
                30, 22)
        ));
        
        abyssalDepths.addOption(new Option(
            "Escape to the surface immediately",
            new Consequence("You swim upward and break through to air.\n" +
                "Safe on land. Alive. No treasure but alive.", 
                12, 8)
        ));
        
        abyssalDepths.addOption(new Option(
            "Explore the depths cautiously",
            new Consequence("You move carefully through the abyss.\n" +
                "You find smaller artifacts and knowledge.\n" +
                "Balanced approach. Some treasure. Some safety.", 
                18, 12)
        ));
        
        map.addPosition(abyssalDepths);
        
        // Position 60: Infinity's End - Final Judgment
        Position infinityEnd = new Position(
            "Infinity's End",
            "The final location. All paths lead here. All journeys end here.\n" +
            "Your choices have led you to this moment.\n" +
            "Before you: judgment. Behind you: your past.\n" +
            "What will define your final choice?"
        );
        
        infinityEnd.addOption(new Option(
            "Accept your fate and find peace",
            new Consequence("You accept what has come to pass.\n" +
                "Peace fills you. GAME OVER - YOU FOUND PEACE.\n" +
                "Your journey is complete.", 
                0, 0, true, false, false)
        ));
        
        infinityEnd.addOption(new Option(
            "Continue fighting beyond the end",
            new Consequence("Your spirit refuses to break. Never give up.\n" +
                "You continue forward. GAME OVER - ENDLESS ADVENTURE.\n" +
                "The journey continues eternally.", 
                0, 0, true, false, false)
        ));
        
        infinityEnd.addOption(new Option(
            "Sacrifice yourself to save others",
            new Consequence("You understand the cost. You make the final choice.\n" +
                "Your sacrifice saves countless others.\n" +
                "GAME OVER - YOU BECAME A LEGEND.", 
                0, 0, true, false, false)
        ));
        
        map.addPosition(infinityEnd);
        
        return map;
    }
}
