package Main;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            InitPassGen main = new InitPassGen();
        } catch (Exception ignored) {}
    }
}
