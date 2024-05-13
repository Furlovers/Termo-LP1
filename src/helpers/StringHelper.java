package helpers;

import java.util.ArrayList;
import java.util.List;

import entities.Letter;
import entities.stateEnum;

public class StringHelper {

    public static List<Letter> setStringToLetter(String word) {

        char[] array = word.toCharArray();
        List<Letter> letterList = new ArrayList<Letter>();

        for (int i = 0; i < word.length(); i++) {
            array[i] = Character.toUpperCase(array[i]);
            Letter letter = new Letter(array[i]);
            letterList.add(letter);
        }
        return letterList;
    }

    public static void isInAnswer(Letter letter, String answer) {

        char[] separated_answer = new char[answer.length()];

        for (int i = 0; i < answer.length(); i++) {
            separated_answer[i] = answer.charAt(i);
        }

        for (int i = 0; i < answer.length(); i++) {
            if (letter.getLetter() == separated_answer[i]) {
                letter.setState(stateEnum.DISCOVERED_AND_WRONG);
            }
        }

    }
}
