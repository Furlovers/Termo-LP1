import javax.swing.JFrame;

public class App extends JFrame{


    public App() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }
}
