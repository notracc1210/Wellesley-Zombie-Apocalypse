import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle {
    ArrayList<PuzzleQuestion> questions;
    
    public Puzzle(){
        questions = new ArrayList<>();
        initializeFreemanHallPuzzle();
    }
    
    private void initializeFreemanHallPuzzle(){
        // Riddle 1
        PuzzleQuestion q1 = new PuzzleQuestion(
            "I have cities but no houses, forests but no trees, and water but no fish. What am I?",
            "A map"
        );
        q1.addWrongAnswer("A painting");
        q1.addWrongAnswer("A dream");
        q1.addWrongAnswer("A book");
        questions.add(q1);
        
        // Riddle 2
        PuzzleQuestion q2 = new PuzzleQuestion(
            "The more you take, the more you leave behind. What am I?",
            "Footsteps"
        );
        q2.addWrongAnswer("Money");
        q2.addWrongAnswer("Time");
        q2.addWrongAnswer("Memories");
        questions.add(q2);
        
        // Riddle 3
        PuzzleQuestion q3 = new PuzzleQuestion(
            "What can travel around the world while staying in a corner?",
            "Stamp"
        );
        q3.addWrongAnswer("Wind");
        q3.addWrongAnswer("Light");
        q3.addWrongAnswer("Reflection");
        questions.add(q3);
    }
    
    /**
     * Play the Freeman Hall puzzle
     * Returns true if all riddles solved correctly, false otherwise
     */
    public boolean playFreemanHallPuzzle(){
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("     FREEMAN HALL SAFE PUZZLE");
        System.out.println("═══════════════════════════════════════\n");
        
        int solvedCorrectly = 0;
        
        for(int i = 0; i < questions.size(); i++){
            PuzzleQuestion question = questions.get(i);
            System.out.println("Riddle " + (i+1) + " of " + questions.size() + ":");
            System.out.println(question.getQuestion() + "\n");
            
            ArrayList<String> options = question.getAllAnswers();
            for(int j = 0; j < options.size(); j++){
                System.out.println((j+1) + ". " + options.get(j));
            }
            
            System.out.println("Enter your answer (1-4):");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            
            if(choice < 1 || choice > 4){
                System.out.println("Invalid choice. The safe recognizes your hesitation as weakness.");
                return false;
            }
            
            String selectedAnswer = options.get(choice - 1);
            
            if(question.isCorrect(selectedAnswer)){
                System.out.println("\n✓ CORRECT! You hear a satisfying CLICK from the lock mechanism.");
                System.out.println("The safe moves to the next riddle.\n");
                solvedCorrectly++;
            } else {
                System.out.println("\n✗ WRONG! Your answer triggers a security alarm!");
                System.out.println("BEEEEP! BEEEEP! BEEEEP!");
                System.out.println("Metal shutters slam down over the safe. Dust falls from the ceiling.");
                System.out.println("The floor trembles beneath you. You scramble away, covering your head.\n");
                return false;
            }
        }
        
        if(solvedCorrectly == questions.size()){
            System.out.println("═══════════════════════════════════════");
            System.out.println("    ALL RIDDLES SOLVED! SAFE OPENS!");
            System.out.println("═══════════════════════════════════════\n");
            System.out.println("The safe door swings open with a satisfying CLICK.\n");
            System.out.println("Inside you find:");
            System.out.println("  • A gleaming weapon");
            System.out.println("  • Vials of luminescent magical medicine");
            System.out.println("  • A crystalline token that pulses with energy\n");
            System.out.println("The token is ancient and powerful—a REBIRTH TOKEN.");
            System.out.println("If you die, you will return. This is POWER.\n");
            return true;
        }
        
        return false;
    }
}

/**
 * Inner class representing a single puzzle question
 */
class PuzzleQuestion {
    String question;
    String correctAnswer;
    ArrayList<String> wrongAnswers;
    
    public PuzzleQuestion(String q, String correct){
        question = q;
        correctAnswer = correct.toLowerCase();
        wrongAnswers = new ArrayList<>();
    }
    
    public void addWrongAnswer(String answer){
        wrongAnswers.add(answer);
    }
    
    public String getQuestion(){
        return question;
    }
    
    public boolean isCorrect(String answer){
        return answer.toLowerCase().equals(correctAnswer);
    }
    
    /**
     * Returns all answers (correct + wrong) in random order
     */
    public ArrayList<String> getAllAnswers(){
        ArrayList<String> allAnswers = new ArrayList<>();
        allAnswers.add(correctAnswer);
        allAnswers.addAll(wrongAnswers);
        
        // Simple shuffle
        for(int i = allAnswers.size() - 1; i > 0; i--){
            int j = (int)(Math.random() * (i + 1));
            String temp = allAnswers.get(i);
            allAnswers.set(i, allAnswers.get(j));
            allAnswers.set(j, temp);
        }
        
        return allAnswers;
    }
}
