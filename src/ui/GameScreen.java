package ui;

import javax.swing.JPanel;
import entities.Square;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel implements KeyListener {

    private Random random;
    private BufferedImage img;
    private int cellSize = 48;
    private int squareIndex = 0;
    private ArrayList<Square> squares;

    public GameScreen(BufferedImage img) {
        this.img = img;
        random = new Random();
        setFocusable(true);
        addKeyListener(this);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (squareIndex == 0) {
            squares = getSquares();
        }

        g.setFont(new Font("Arial", Font.BOLD, 24));

        for (Square square : squares) {
            drawSquare(g, square, square.getLetter());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char typedChar = e.getKeyChar();
        String typedCharString = String.valueOf(typedChar).toUpperCase();
        typedChar = typedCharString.charAt(0);
        if (squareIndex <= squares.size()) {
            if ((int) e.getKeyChar() == 8) { // backspace code
                if (squareIndex <= 0) {
                    return;
                }
                squareIndex--;
                squares.get(squareIndex).setLetter(' ');
            } else {
                if (squareIndex == squares.size() || !String.valueOf(typedChar).matches("[a-zA-Z]")) {
                    return;
                }
                squares.get(squareIndex).setLetter(typedChar);
                squareIndex++;
            }
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    public ArrayList<Square> getSquares() {
        ArrayList<Square> squares = new ArrayList<Square>();

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int gridWidth = 5;
        int gridHeight = 6;
        int cellSpacing = 16;

        int gridTotalWidth = gridWidth * cellSize + (gridWidth - 1) * cellSpacing;
        int gridTotalHeight = gridHeight * cellSize + (gridHeight - 1) * cellSpacing;

        int startX = (panelWidth - gridTotalWidth) / 2;
        int startY = (panelHeight - gridTotalHeight) / 2;

        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Square square = new Square(startX + x * (cellSize + cellSpacing),
                        startY + y * (cellSize + cellSpacing));
                squares.add(square);
            }
        }

        return squares;
    }

    public void drawSquare(Graphics g, Square square, char letter) {
        g.setColor(Color.black);
        g.fillRect(square.getXPos(), square.getYPos(), cellSize, cellSize);

        g.setColor(Color.white);
        g.drawString(String.valueOf(letter), square.getXPos() + 15, square.getYPos() + 32);
    }
}
