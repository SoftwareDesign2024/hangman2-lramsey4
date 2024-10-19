package game;

import util.HangmanDictionary;
import util.DisplayWord;

public abstract class Executioner {
    // word that is being guessed
    protected String mySecretWord;
    // what is shown to the user
    protected DisplayWord myDisplayWord;
    protected int myNumGuessesLeft;
    
    public Executioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	this.myDisplayWord = new DisplayWord(mySecretWord);
    	this.mySecretWord = makeSecretWord(dictionary, wordLength);
    	this.myNumGuessesLeft = numGuesses;
    }
    
    public String getSecretWord() {
    	return mySecretWord;
    }
    
    public DisplayWord getDisplayWord() {
    	return myDisplayWord;
    }
    
    public int getNumGuessesLeft() {
    	return myNumGuessesLeft;
    }
    
    // Returns true only if the guesser has guessed all letters in the secret word.
    public boolean isGameWon() {
        return getDisplayWord().equals(mySecretWord);
    }

    // Returns true only if the guesser has used up all their chances to guess.
    public boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }
    
    // Returns a secret word.
    public String makeSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
    
    public abstract void cheat(char guess);
}
