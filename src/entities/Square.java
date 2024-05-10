package entities;

public class Square {
    private int xPos;
    private int yPos;
    private char letter;

    public Square(int xPos, int yPos, char letter) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.letter = letter;
    }

    public Square(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.letter = ' ';
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

}
