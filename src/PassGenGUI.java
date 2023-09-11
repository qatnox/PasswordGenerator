import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PassGenGUI implements ActionListener {
    JFrame frame = new JFrame("Password Generator");
    JTextField generatedPass;
    JTextField length;
    JLabel label;
    JLabel stripe;
    JLabel label1;
    JLabel symbols;
    JButton generateButton;
    JCheckBox checkBox;
    JButton clearButton;

    public void setButtons() {
        generateButton = new JButton("Generate");
        generateButton.setBounds(95, 200, 130, 35);
        generateButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        generateButton.setFocusable(false);
        generateButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(245, 200, 80, 35);
        clearButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
    }

    public void setTextFields() {
        length = new JTextField();
        length.setBounds(220, 30, 35, 22);
        length.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        generatedPass = new JTextField();
        generatedPass.setBounds(25, 160, 300, 25);
        generatedPass.setFont(new Font("Century Gothic", Font.PLAIN, 13));
    }

    public void setLabels() {
        label = new JLabel("Your password is");
        label.setBounds(100, 115, 200, 50);
        label.setFont(new Font("Century Gothic", Font.BOLD, 15));

        label1 = new JLabel("Length of the password");
        label1.setBounds(40, 15, 200, 50);
        label1.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        symbols = new JLabel("Use special symbols");
        symbols.setBounds(68, 45, 200, 50);
        symbols.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        stripe = new JLabel("_________________________________________");
        stripe.setBounds(30, 100, 300, 20);
        stripe.setFont(new Font("Century Gothic", Font.PLAIN, 13));
    }

    public void setCheckBox() {
        checkBox = new JCheckBox();
        checkBox.setBounds(218, 55, 30, 30);
    }

    public void addComponents() {
        frame.add(length);
        frame.add(generatedPass);

        frame.add(generateButton);
        frame.add(clearButton);

        frame.add(label);
        frame.add(label1);
        frame.add(stripe);
        frame.add(symbols);

        frame.add(checkBox);
    }

    public void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(360, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            String password;
            if (checkBox.isSelected()) {
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_@!#$%^&*()-+=/{}:|;?><~.,";
            } else {
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            }
            SecureRandom random = new SecureRandom();
            StringBuilder stringBuilder = new StringBuilder();
            try {
                int passLen = Integer.parseInt(length.getText());
                if (passLen > 40) {
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
        if (e.getSource() == clearButton) {
            generatedPass.setText("");
        }
    }
}
