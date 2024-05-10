package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends JFrame {

    private GameScreen gameScreen;

    private BufferedImage img;

    public Main() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen(img);
        gameScreen.setBackground(Color.DARK_GRAY);
        add(gameScreen);
    }
}
