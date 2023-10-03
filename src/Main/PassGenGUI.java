package Main;

import Additional.GeneratePassword;
import Additional.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassGenGUI implements ActionListener  {
    JFrame frame = new JFrame("Password Generator");
    public JTextField generatedPass;
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
    Font font = new Font("Century Gothic", Font.PLAIN, 15);

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
        clearButton.setFont(font);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);

        copyButton = new JButton("Copy");
        copyButton.setBounds(170, 200,75, 35);
        copyButton.setFont(font);
        copyButton.setFocusable(false);
        copyButton.addActionListener(this);
    }

    public void setTextFields() {
        length = new JTextField();
        length.setBounds(220, 30, 35, 22);
        length.setFont(font);
        length.setBorder(new RoundedBorder(3));

        generatedPass = new JTextField();
        generatedPass.setBounds(25, 160, 300, 30);
        generatedPass.setFont(font);
        generatedPass.setBorder(new RoundedBorder(3));
    }

    public void setLabels() {
        label = new JLabel("YOUR PASSWORD");
        label.setBounds(100, 115, 200, 50);
        label.setFont(new Font("Century Gothic", Font.BOLD, 15));

        label1 = new JLabel("Length of the password");
        label1.setBounds(40, 15, 200, 50);
        label1.setFont(font);

        symbols = new JLabel("Use special symbols");
        symbols.setBounds(68, 45, 200, 50);
        symbols.setFont(font);

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
            try {
                setTextPassLen();
                String password;
                if (checkBox.isSelected()) {
                    password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_@!#$%^&*()-+=/{}:|;?><~.,‹›";
                } else {
                    password = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                }
                int passLen = getTextPassLen();
                GeneratePassword generatePassword = new GeneratePassword();
                generatePassword.generate(password, MAX_LENGTH, passLen, generatedPass);

            } catch (Exception exception) {
                generatedPass.setText("\t   0_o");
            }
        }
        if (e.getSource() == clearButton) {
            generatedPass.setText("");
            length.setText("");
            checkBox.setSelected(false);
        }

        if(e.getSource() == copyButton){
            String copy = generatedPass.getText();
            StringSelection selectedText = new StringSelection(copy);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectedText, null);
        }
    }

    public String getTextGeneratedPass() {
        return textGeneratedPass;
    }

    public void setTextGeneratedPass(String textGeneratedPass) {
        this.textGeneratedPass = textGeneratedPass;
    }

    private int getTextPassLen() {
        return textPassLen;
    }

    private void setTextPassLen() {
            this.textPassLen = Integer.parseInt(length.getText());
    }
}
