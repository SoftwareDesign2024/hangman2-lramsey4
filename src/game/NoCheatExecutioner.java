package game;

import util.HangmanDictionary;
import util.DisplayWord;

public class NoCheatExecutioner extends Executioner{
    
    public NoCheatExecutioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
		super(dictionary, wordLength, numGuesses);
	}

	@Override
    public void cheat(char guess) {
    	// nah, no need for that here.
    }
}
