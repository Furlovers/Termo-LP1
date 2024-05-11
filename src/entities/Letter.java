package entities;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private char letter;
    private stateEnum state;
    private int index;
    private int count;

    public Letter(char letter) {
        state = stateEnum.UNDISCOVERED;
        this.letter = letter;
        this.index = 0;
        this.count = 0;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Letter> setStringToLetter(String word){
        /* Transforma uma plavra em um array de objetos do tipo Letter
         */

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
