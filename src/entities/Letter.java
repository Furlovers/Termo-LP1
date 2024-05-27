package entities;

import java.util.ArrayList;
import java.util.List;

import helpers.StateEnum;

public class Letter {
    /*
     * Definição da classe "Letter", elemento base
     * para a lógica do jogo desenvolvido. Possui os
     * atributos 'letter', o qual recebe uma letra (char)
     * e state, que recebe o estado daquela letra em relação
     * à palavra gabarito daquela partida.
     */
    private char letter;
    private StateEnum state;

    public Letter(char letter) {
        state = StateEnum.UNDISCOVERED;
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public StateEnum getStatesEnum() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public List<Letter> setStringToLetter(String word) {

        /*
         * Recebe uma palavra como string, tranforma todas
         * as sua letras em maiúsculas então cria-se um objeto
         * 'Letter' para cada uma delas. Cada objeto 'Letter'
         * é armazenado em um ArrayList que é retornado, a fim
         * viabilizar a aplicação dos métodos desenvolvidos.
         */

        char[] array = word.toCharArray();
        List<Letter> letterList = new ArrayList<Letter>();

        for (int i = 0; i < word.length(); i++) {
            array[i] = Character.toUpperCase(array[i]);
            Letter letter = new Letter(array[i]);
            letterList.add(letter);
        }
        return letterList;
    }
}