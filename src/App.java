import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import entities.Letter;
import entities.Letter.*;


import javax.swing.JFrame;

public class App extends JFrame{

    private GameScreen gameScreen;

    private BufferedImage img;

    

    public App() {
        
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen(img);
        gameScreen.setBackground(Color.DARK_GRAY);
        add(gameScreen);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.err.println(e.getKeyChar());

            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
               
            }
        });
    }



    public static void main(String[] args) throws Exception {
        App app = new App();
        List<Letter> list = setStringToLetter("teste");

        // for(Letter letter : list){
        //     System.out.println(letter.getLetter());
        // }
    }



    public static List<Letter> setStringToLetter(String word){

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
