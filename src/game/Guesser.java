package game;

public abstract class Guesser {
    // tracks letters guessed
    protected StringBuilder myLettersLeftToGuess;
	
    public Guesser() {
    	this.myLettersLeftToGuess = new StringBuilder(HangmanGame.ALPHABET);
    }
    
    public StringBuilder getLettersLeftToGuess() {
    	return myLettersLeftToGuess;
    }
    
	// Process a guess by updating the necessary internal state.
    public abstract char makeGuess();
    
    // Record that a specific letter was guessed
    public void recordGuess(int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
}