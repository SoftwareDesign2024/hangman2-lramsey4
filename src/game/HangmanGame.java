package game;

import java.util.List;

import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
	public static final String DICTIONARY = "data/lowerwords.txt";
	public static final int WORD_LENGTH = 6;
	public static final int NUM_MISSES = 8;
	public static final int NUM_LETTERS = 6;

	// guesser state
	private String myLetters;
	private int myIndex;
	// executioner state
	private List<String> myRemainingWords;
	private Guesser guesser;
	private Executioner executioner;

	/**
	 * Create Hangman game with the given dictionary of words to play a game with words 
	 * of the given length and giving the user the given number of chances.
	 */
	public HangmanGame(Guesser guesserType, Executioner executionerType) {
		this.guesser = guesserType;
		this.executioner = executionerType;
	}

	/**
	 * Play one complete game.
	 */
	public void play() {
		int myNumGuessesLeft = executioner.getNumGuessesLeft();
		boolean gameOver = false;
		while (!gameOver) {
			printStatus();

			char guess = guesser.makeGuess();
			if (! executioner.checkGuessInSecret(guess)) {
				myNumGuessesLeft -= 1;
			}

			if (executioner.isGameLost()) {
				System.out.println("YOU ARE HUNG!!!");
				gameOver = true;
			}
			else if (executioner.isGameWon()) {
				System.out.println("YOU WIN!!!");
				gameOver = true;
			}
			else {
				System.out.println("Please enter a single letter ...");
			}
		}
		System.out.println("The secret word was " + executioner.getSecretWord());
	}

	// Print game stats
	private void printStatus() {
		System.out.println(executioner.getDisplayWord());
		System.out.println("# misses left = " + executioner.getNumGuessesLeft());
		System.out.println("letters not yet guessed = " + guesser.getLettersLeftToGuess());
		// NOT PUBLIC, but makes it easier to test
		//System.out.println("*** " + mySecretWord);
		System.out.println();
	}
}
