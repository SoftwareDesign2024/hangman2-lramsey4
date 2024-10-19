package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * where the computer guesses letters based on a predictable pattern.
 *
 * @author Robert C. Duvall
 */
public class HangmanGameAutoGuesser extends Guesser {
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    
    private String myLetters;
    private int myIndex;

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGameAutoGuesser() {
    	super();
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
    }
    
    // Process a guess by updating the necessary internal state.
    @Override
    public char makeGuess() {
    	char guess = myLetters.charAt(myIndex++);
        if (Character.isAlphabetic(guess)) {
            int index = getLettersLeftToGuess().indexOf("" + guess);
            if (index >= 0) {
            	recordGuess(index);
            	return guess;
            }
        // do not count repeated guess as a miss
        }
        return makeGuess();
    }
}
