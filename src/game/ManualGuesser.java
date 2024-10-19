package game;

import util.ConsoleReader;

public class ManualGuesser extends Guesser {
    
	public ManualGuesser() {
		super();
	}

	// Process a guess by updating the necessary internal state.
    public char makeGuess() {
    	String guess = ConsoleReader.promptString("Make a guess: ");
        if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            char guessedChar = guess.toLowerCase().charAt(0);
            int index = getLettersLeftToGuess().indexOf("" + guessedChar);
            if (index >= 0) {
            	recordGuess(index);
            	return guessedChar;
            }
        // do not count repeated guess as a miss
        }
        return makeGuess();
    }

}