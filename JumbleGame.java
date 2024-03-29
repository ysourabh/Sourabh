import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

 
public class JumbleGame {
 
    private static final String[] WORDS_DATABASE = new String[] {
        "Niit","Dwarka","Java","Najafgarh","Janakpuri","New Delhi"
    };

    public static void main(String[] args) {
        JumbleGame jg = new JumbleGame();
        jg.startGame();
    }
    private void startGame() {
        int numberOfGuesses = 0;
        String original = selectRandomWord();
        String shuffled = getShuffledWord(original);
        boolean gameOn = true;
        while(gameOn) {
            System.out.println("Shuffled word is: "+shuffled);
            numberOfGuesses++;
            String userGuess = getUserGuess();
            if(original.equalsIgnoreCase(userGuess)) {
                System.out.println("Congratulations! You found the word in "+numberOfGuesses+" guesses");
                gameOn = false;
            }else {
                System.out.println("Sorry, Wrong answer");
            }
        }        
    }
     
    public String getUserGuess() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Please type in the original word: ");
        return sn.nextLine();
    }
     
    public String selectRandomWord() {
        int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
        return WORDS_DATABASE[rPos];
    }
     
    public String getShuffledWord(String original) {
        String shuffledWord = original; // start with original
        int wordSize = original.length();
        int shuffleCount = 10; // let us randomly shuffle letters 10 times
        for(int i=0;i<shuffleCount;i++) {
            //swap letters in two indexes
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
        }
        return shuffledWord;
    }
 
    private String swapCharacters(String shuffledWord, int position1, int position2) {
        char[] charArray = shuffledWord.toCharArray();
        // Replace with a "swap" function, if desired:
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }
}