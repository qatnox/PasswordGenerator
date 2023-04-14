import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;



public class PassGen extends Frame implements ActionListener {

    JTextField generatedPass;
    JTextField length;
    JLabel label;
    JLabel stripe;
    JLabel label1;
    JLabel symbols;
    JButton button;
    JButton exit;
    JCheckBox checkBox;

    PassGen(){

        length = new JTextField();
        length.setBounds(220, 58, 35, 25);

        generatedPass = new JTextField();
        generatedPass.setBounds(25, 200, 300, 25);
        //---------------------------------------------------------
        button = new JButton("Generate password");
        button.setBounds(95, 240, 150, 35);
        button.addActionListener(this);

        exit = new JButton("EXIT");
        exit.setBounds(120, 340, 100, 35);
        exit.addActionListener(this:: exit);
        //---------------------------------------------------------
        label = new JLabel("Your password is:");
        label.setBounds(30, 160, 200, 50);

        label1 = new JLabel("The length of the password:");
        label1.setBounds(55, 45, 200, 50);

        symbols = new JLabel("Use special symbols: ");
        symbols.setBounds(55, 75, 200, 50);

        stripe = new JLabel("_________________________________________");
        stripe.setBounds(30, 150, 300, 20);
        //---------------------------------------------------------
        checkBox = new JCheckBox();
        checkBox.setBounds(218, 90, 20, 20);


        add(length);
        add(generatedPass);

        add(button);
        add(exit);

        add(label);
        add(label1);
        add(stripe);
        add(symbols);

        add(checkBox);
        //---------------------------------------------------------
        setLayout(null);
        setSize(350, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String password;

        if(checkBox.isSelected()){
            password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_@!#$%^&*()-+=/{}:|;?><~";
        }else {
            password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        }
            SecureRandom random = new SecureRandom();
            StringBuilder stringBuilder = new StringBuilder();
            try {
                int passLen = Integer.parseInt(length.getText());

                if (passLen > 38) {
                    generatedPass.setText("Too large pass!");
                } else {
                    for (int i = 0; i < passLen; i++) {
                        int randomIndex = random.nextInt(password.length());
                        stringBuilder.append(password.charAt(randomIndex));
                    }
                    generatedPass.setText(stringBuilder.toString());
                }
            } catch (Exception exception) {
                generatedPass.setText("Incompatible data types!");
            }
        }

    public void exit(ActionEvent e){
        System.exit(0);
    }

    public static void main(String[] args) {
        new PassGen();
    }
}
