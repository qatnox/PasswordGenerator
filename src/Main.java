import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            InitPassGen main = new InitPassGen();
        } catch (Exception ignored) {}
    }
}
