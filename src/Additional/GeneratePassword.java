package Additional;

import Main.PassGenGUI;

import javax.swing.*;
import java.util.Random;

public class GeneratePassword {
    PassGenGUI ui = new PassGenGUI();
    public void generate(String password, int MAX_LENGTH, int passLen, JTextField generatedPass){
        if (passLen > MAX_LENGTH || passLen < 1) {
            generatedPass.setText("Incorrect length!");
        } else {
            char[] passSymbols = password.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < passLen; i++) {
                Random random = new Random();
                stringBuilder.append(passSymbols[random.nextInt(passSymbols.length)]);
            }
            ui.setTextGeneratedPass(stringBuilder.toString());
            generatedPass.setText(ui.getTextGeneratedPass());
        }
    }
}
