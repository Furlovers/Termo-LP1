package helpers;

import java.util.ArrayList;
import java.util.List;

import entities.Letter;

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
}
