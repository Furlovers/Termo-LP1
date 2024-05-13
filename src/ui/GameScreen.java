package ui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Letter;
import entities.Square;
import helpers.StringHelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScreen extends JPanel implements KeyListener, ActionListener {
    private int cellSize = 64;
    private int squareIndex = 0;
    private int wordIndex = 1;
    private ArrayList<Square> squares;
    private JButton submitButton;
    private boolean canWrite = true;
    private boolean win = false;
    private List<List<Letter>> words = Arrays.asList(
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')),
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')),
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')),
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')),
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')),
            Arrays.asList(new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' '), new Letter(' ')));

    private String word = "TESTE";

    public GameScreen() {
        setLayout(null);
        drawButton();
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (squareIndex == 0) {
            squares = getSquares();
        }

        g.setFont(new Font("Arial", Font.BOLD, 40));

        words.forEach(word -> {
            for (int i = 0; i < word.size(); i++) {
                drawSquare(g, squares.get(i + (5 * (words.indexOf(word)))), word.get(i));
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char typedChar = e.getKeyChar();
        String typedCharString = String.valueOf(typedChar).toUpperCase();
        typedChar = typedCharString.charAt(0);
        System.out.println(win);
        if (squareIndex <= squares.size() && !win) {
            if ((int) e.getKeyChar() == 8) { // backspace code
                if (squareIndex <= 0) {
                    return;
                }
                switch (wordIndex) {
                    case 2:
                        if (squareIndex == 5) {
                            return;
                        }
                        break;
                    case 3:
                        if (squareIndex == 10) {
                            return;
                        }
                        break;
                    case 4:
                        if (squareIndex == 15) {
                            return;
                        }
                        break;
                    case 5:
                        if (squareIndex == 20) {
                            return;
                        }
                        break;
                    case 6:
                        if (squareIndex == 30) {
                            return;
                        }
                        break;
                }
                if (squareIndex % 5 == 0) {
                    canWrite = true;
                }
                squareIndex--;
                words.get(wordIndex - 1).get(squareIndex - (5 * (wordIndex - 1))).setLetter(' ');
                squares.get(squareIndex).setLetter(' ');
            } else {
                if (squareIndex == squares.size() || !String.valueOf(typedChar).matches("[a-zA-Z]") || !canWrite) {
                    return;
                }
                words.get(wordIndex - 1).get(squareIndex - (5 * (wordIndex - 1))).setLetter(typedChar);
                squares.get(squareIndex).setLetter(typedChar);
                squareIndex++;
                if (squareIndex % 5 == 0) {
                    canWrite = false;
                }
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
        int cellSpacing = 8;

        int gridTotalWidth = gridWidth * cellSize + (gridWidth - 1) * cellSpacing;
        int gridTotalHeight = gridHeight * cellSize + (gridHeight - 1) * cellSpacing;

        int startX = (panelWidth - gridTotalWidth) / 2;
        int startY = (panelHeight - gridTotalHeight) / 3;

        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Square square = new Square(startX + x * (cellSize + cellSpacing),
                        startY + y * (cellSize + cellSpacing));
                squares.add(square);
            }
        }

        return squares;
    }

    public void drawSquare(Graphics g, Square square, Letter letter) {
        int arcWidth = 16;
        int arcHeight = 16;

        switch (letter.getStatesEnum()) {
            case UNDISCOVERED:
                g.setColor(Color.black);
                break;
            case DISCOVERED_AND_WRONG:
                g.setColor(Color.yellow);
                break;
            case DISCOVERED_AND_RIGHT:
                g.setColor(Color.green);
                break;
        }
        g.fillRoundRect(square.getXPos(), square.getYPos(), cellSize, cellSize, arcWidth, arcHeight);

        FontMetrics fm = g.getFontMetrics();
        int letterWidth = fm.stringWidth(String.valueOf(letter.getLetter()));
        int letterHeight = fm.getAscent();

        int xPos = square.getXPos() + (cellSize - letterWidth) / 2;
        int yPos = square.getYPos() + (cellSize + letterHeight) / 2;

        g.setColor(Color.white);
        String letterString = letter.getLetter() == ' ' ? "" : String.valueOf(letter.getLetter());
        g.drawString(letterString, xPos, yPos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            canWrite = true;
            submitButton.setFocusable(false);
            if ((wordIndex == 1 & squareIndex == 5) || (wordIndex == 2 & squareIndex == 10)
                    || (wordIndex == 3 & squareIndex == 15) || (wordIndex == 4 & squareIndex == 20)
                    || (wordIndex == 5 & squareIndex == 25)) {
                win = true;
                for (int i = 0; i < words.get(wordIndex - 1).size(); i++) {
                    boolean right = StringHelper.isInAnswer(words.get(wordIndex - 1).get(i), word, i);
                    if (!right) {
                        win = false;
                    }
                }
                wordIndex++;
                repaint();
            }
        }
    }

    public void drawButton() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int buttonWidth = 200;
        int buttonHeight = 50;

        submitButton = new JButton("Enter");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        submitButton.setBounds((screenWidth - buttonWidth) / 2, screenHeight - 200, buttonWidth, buttonHeight);
        submitButton.addActionListener(this);
        add(submitButton);
    }
}
