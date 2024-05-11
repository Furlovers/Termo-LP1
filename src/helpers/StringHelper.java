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

    public static void isInAnswer(Letter letter, String answer){ // chamar iterativamente para cada letra em letterList -> isInAnswer(letterList[i], gabarito)
        
        char[] separated_answer = new char[answer.length];

        for (int i = 0; i<answer.length; i++){
            separated_answer[i] = answer.charAt(i);
        }

        for(int i = 0; i<answer.length; i++){
            if (letter.getLetter() == separated_answer[i]){
                letter.setState(DISCOVERED_AND_WRONG);
            }
        }

    }

    public static void isInRightPos(Letter letter, String answer){ // chamar iterativamente para cada letra em letterList -> isInAnswer(letterList[i], gabarito)
        
        char[] separated_answer = new char[answer.length];

        for (int i = 0; i<answer.length; i++){
            separated_answer[i] = answer.charAt(i);
        }

        for(int i = 0; i<answer.length; i++){
            if (letter.getLetter() == separated_answer[i]){
                letter.setState(DISCOVERED_AND_WRONG);
            }
        }

    }

    public static boolean win(List<Letter> letterList){

        /*Se o estado de qualquer letra no array de letras letterList
         * for diferente de DISCOVERED_AND_RIGHT (letra na posição certa),
         * nao ganhou naquela rodada. Chamar sempre no final de cada rodada
         * para ver se o usuário ganhou.
         */
        for(int i = 0; i < letterList.length; i++){

            if(letterList[i].getStatesEnum() != DISCOVERED_AND_RIGHT){
                return false;
            }
        }

        return true;
    }

}
