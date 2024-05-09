import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameScreen extends JPanel{

    private Random random;
    private BufferedImage img;

    public GameScreen(BufferedImage img){
        this.img = img;
        random = new Random();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int y = 0; y < 6 ;y++){ 
            for(int x = 0; x < 5;x++){
                g.setColor(Color.black);
                g.fillRect(460 + (x * 64), 100 + (y * 64), 48, 48);
            }
        }

    }

    private Color getRndColor(){
        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }
}
