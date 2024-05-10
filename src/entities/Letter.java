package entities;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private char letter;
    private stateEnum state;

    public Letter(char letter) {
        state = stateEnum.UNDISCOVERED;
        this.letter = letter;
    }
    

    public char getLetter() {
        return letter;
    } 
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public stateEnum getStatesEnum() {
        return state;
    }
    public void setState(stateEnum state) {
        this.state = state;
    }

    public List<Letter> setStringToLetter(String word){

        char[] array = word.toCharArray();
        List<Letter> letterList = new ArrayList<Letter>();
        
        for(int i = 0; i < word.length(); i++){
            array[i] = Character.toUpperCase(array[i]);
            Letter letter  = new Letter(array[i]);
            letterList.add(letter);
        }
        return letterList;
    }
}
