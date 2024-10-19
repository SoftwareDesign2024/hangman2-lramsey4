import game.*;
import game.HangmanGameAutoGuesser;
import game.HangmanGameCheatingComputer;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
	public static final int NUM_MISSES = 8;
	public static final int NUM_LETTERS = 6;


    public static void main (String[] args) {
    	Guesser manualGuesser = new ManualGuesser();
    	Guesser autoGuesser = new HangmanGameAutoGuesser();
    	Executioner cheatExecutioner = new HangmanGameCheatingComputer(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES);
    	Executioner cleanExecutioner = new NoCheatExecutioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES);
    	
    	new HangmanGame(manualGuesser, cheatExecutioner).play();
    }
}
