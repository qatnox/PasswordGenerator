import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PassGen extends JFrame implements ActionListener, GUI {

    GUIElements guiElements = new GUIElements();

    public static void main(String[] args) {
        new PassGen();
    }

    public void exit(ActionEvent e){
        System.exit(0);
    }

    PassGen(){
        setTitle("Password Generator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiElements.length = new JTextField();
        guiElements.length.setBounds(220, 28, 35, 25);

        guiElements.generatedPass = new JTextField();
        guiElements.generatedPass.setBounds(25, 160, 300, 25);
        //---------------------------------------------------------
        guiElements.button = new JButton("Generate password");
        guiElements.button.setBounds(95, 200, 150, 35);
        guiElements.button.addActionListener(e -> {
            String password;
            if(guiElements.checkBox.isSelected()){
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_@!#$%^&*()-+=/{}:|;?><~.,";
            }else {
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            }
            SecureRandom random = new SecureRandom();
            StringBuilder stringBuilder = new StringBuilder();
            try {
                int passLen = Integer.parseInt(guiElements.length.getText());
                if (passLen > 38) {
                    guiElements.generatedPass.setText("Too large pass!");
                } else {
                    for (int i = 0; i < passLen; i++) {
                        int randomIndex = random.nextInt(password.length());
                        stringBuilder.append(password.charAt(randomIndex));
                    }
                    guiElements.generatedPass.setText(stringBuilder.toString());
                }
            } catch (Exception exception) {
                guiElements.generatedPass.setText("Incompatible data types!");
            }
        });

        //---------------------------------------------------------
        guiElements.label = new JLabel("Your password is:");
        guiElements.label.setBounds(30, 110, 200, 50);

        guiElements.label1 = new JLabel("The length of the password:");
        guiElements.label1.setBounds(55, 15, 200, 50);

        guiElements.symbols = new JLabel("Use special symbols: ");
        guiElements.symbols.setBounds(55, 45, 200, 50);

        guiElements.stripe = new JLabel("_________________________________________");
        guiElements.stripe.setBounds(30, 100, 300, 20);
        //---------------------------------------------------------
        guiElements.checkBox = new JCheckBox();
        guiElements.checkBox.setBounds(218, 60, 20, 20);


        add(guiElements.length);
        add(guiElements.generatedPass);
        //---------------------------------------------------------
        add(guiElements.button);
        //---------------------------------------------------------
        add(guiElements.label);
        add(guiElements.label1);
        add(guiElements.stripe);
        add(guiElements.symbols);
        //---------------------------------------------------------
        add(guiElements.checkBox);


        setLayout(null);
        setResizable(false);
        setSize(350, 300);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
