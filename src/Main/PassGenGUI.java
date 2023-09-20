package Main;

import Additional.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PassGenGUI implements ActionListener  {
    JFrame frame = new JFrame("Password Generator");
    JTextField generatedPass;
    JTextField length;
    JLabel label;
    JLabel stripe;
    JLabel label1;
    JLabel symbols;
    JLabel maxLength;
    JButton generateButton;
    JButton clearButton;
    JButton copyButton;
    JCheckBox checkBox;

    public int textPassLen;
    public String textGeneratedPass;
    private final int MAX_LENGTH = 40;

    public void setButtons() {
        generateButton = new JButton("Generate");
        generateButton.setBounds(25, 200, 130, 35);
        generateButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        generateButton.setFocusable(false);
        generateButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(250, 200, 75, 35);
        clearButton.setForeground(Color.red);
        clearButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);

        copyButton = new JButton("Copy");
        copyButton.setBounds(170, 200,75, 35);
        copyButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        copyButton.setFocusable(false);
        copyButton.addActionListener(this);
    }

    public void setTextFields() {
        length = new JTextField();
        length.setBounds(220, 30, 35, 22);
        length.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        length.setBorder(new RoundedBorder(3));

        generatedPass = new JTextField();
        generatedPass.setBounds(25, 160, 300, 30);
        generatedPass.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        generatedPass.setBorder(new RoundedBorder(3));
    }

    public void setLabels() {
        label = new JLabel("YOUR PASSWORD");
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

        maxLength = new JLabel("Max length - " + MAX_LENGTH + " symbols");
        maxLength.setBounds(30, 93, 300, 25);
        maxLength.setForeground(Color.red);
        maxLength.setFont(new Font("Century Gothic", Font.BOLD, 13));
    }

    public void setCheckBox() {
        checkBox = new JCheckBox();
        checkBox.setBounds(220, 58, 25, 25);
        checkBox.setBorderPaintedFlat(false);
        Insets insets = new Insets(2, 0, 2, 2);
        checkBox.setMargin(insets);
    }

    public void addComponents() {
        frame.add(length);
        frame.add(generatedPass);

        frame.add(generateButton);
        frame.add(clearButton);
        frame.add(copyButton);

        frame.add(label);
        frame.add(label1);
        frame.add(stripe);
        frame.add(symbols);
        frame.add(maxLength);

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
            setTextPassLen();
            String password;
            if (checkBox.isSelected()) {
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_@!#$%^&*()-+=/{}:|;?><~.,‹›";
            } else {
                password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            }
            SecureRandom random = new SecureRandom();
            StringBuilder stringBuilder = new StringBuilder();
            try {
                int passLen = getTextPassLen();
                if (passLen > MAX_LENGTH) {
                    generatedPass.setText("Too large pass!");
                } else {
                    for (int i = 0; i < passLen; i++) {
                        int randomIndex = random.nextInt(password.length());
                        stringBuilder.append(password.charAt(randomIndex));
                    }

                    setTextGeneratedPass(stringBuilder.toString());
                    generatedPass.setText(getTextGeneratedPass());
                }
            } catch (Exception exception) {
                generatedPass.setText("Incompatible data types!");
            }
        }
        if (e.getSource() == clearButton) {
            generatedPass.setText("");
        }

        if(e.getSource() == copyButton){
            String copy = generatedPass.getText();
            StringSelection selectedText = new StringSelection(copy);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectedText, null);
        }
    }

    private String getTextGeneratedPass() {
        return textGeneratedPass;
    }

    private void setTextGeneratedPass(String textGeneratedPass) {
        System.out.println(textGeneratedPass);
        this.textGeneratedPass = textGeneratedPass;
    }

    private int getTextPassLen() {
        return textPassLen;
    }

    private void setTextPassLen() {
        int textPassLen = Integer.parseInt(length.getText());
        System.out.println(textPassLen);
        this.textPassLen = textPassLen;
    }
}
