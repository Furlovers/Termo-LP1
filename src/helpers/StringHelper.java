package helpers;

import java.util.ArrayList;
import java.util.List;

import entities.Letter;
import entities.stateEnum;

public class StringHelper {

    public static List<Letter> setStringToLetter(String word) {

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

    public static boolean isCorrect(Letter letter, String answer, int letterIndex) {

        /*
         * Verifica o estado de uma letra da palavra informada pelo usuário
         * em relação à palavra gabarito. Recebe um objeto letra, a palavra
         * gabarito e o índice da letra no tabuleiro. Desenvolvida para ser
         * chamada iterativamente para cada "Letter" na ArrayList que contém
         * a palavra informada pelo usuário após a aplicação do método
         * setStringToLetter.
         * 
         */

        char[] separated_answer = new char[answer.length()];

        for (int i = 0; i < answer.length(); i++) {
            separated_answer[i] = answer.charAt(i);
        }

        boolean isWrong = true;
        for (int i = 0; i < answer.length(); i++) {
            if (letter.getLetter() == separated_answer[i]) {
                isWrong = false;
                letter.setState(stateEnum.DISCOVERED_AND_WRONG);
                if (i == letterIndex) {
                    letter.setState(stateEnum.DISCOVERED_AND_RIGHT);
                    return true;
                }
            }
        }

        if (isWrong) {
            letter.setState(stateEnum.WRONG);
        }
        return false;

    }
}