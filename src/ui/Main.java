package ui;

import java.awt.Color;

import javax.swing.JFrame;

import ui.Menu.MenuScreen;

public class Main extends JFrame {

    private GameScreen gameScreen;
    private MenuScreen menu;

    public Main() {
        // gameScreen = new GameScreen();
        // gameScreen.setBackground(Color.DARK_GRAY);
        // add(gameScreen);

        menu = new MenuScreen();
        add(menu);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}