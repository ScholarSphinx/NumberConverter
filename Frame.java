package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private JTextField input = new JTextField();
    private JPanel inputPanel = new JPanel();
    private JLabel labelInputPanel = new JLabel("Input text");
    private JPanel answerPanel = new JPanel();
    private JLabel labelAnswerPanel = new JLabel("The answer is:");
    private JLabel answer = new JLabel("The answer will be displayed here");
    private JButton decimal = new JButton("Decimal");
    private JButton binary = new JButton("Binary");
    private JButton octal = new JButton("Octal");
    private JButton hexadecimal = new JButton("Hexadecimal");
    private JRadioButton decimalRadio = new JRadioButton("From decimal");
    private JRadioButton binaryRadio = new JRadioButton("From binary");
    private JRadioButton octalRadio = new JRadioButton("From octal");
    private JRadioButton hexadecimalRadio = new JRadioButton("From hexadecimal");
    private ButtonGroup group = new ButtonGroup();

    Frame() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new GridLayout(4, 1));
        this.add(inputPanel);
        this.add(answerPanel);
        this.add(createRadioPanel());
        this.add(createOperationPanel());
        this.setLocationRelativeTo(null);

        input.setPreferredSize(new Dimension(700, 40)); // Adjusted input size
        input.setFont(new Font("Sans", Font.PLAIN, 20)); // Adjusted font size

        inputPanel.add(labelInputPanel);
        inputPanel.add(input);
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50)); // Centered input

        answerPanel.add(labelAnswerPanel);
        answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        answerPanel.add(answer);

        decimal.addActionListener(this);
        binary.addActionListener(this);
        octal.addActionListener(this);
        hexadecimal.addActionListener(this);
    }

    private JPanel createRadioPanel() {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 4));
        radioPanel.add(decimalRadio);
        radioPanel.add(binaryRadio);
        radioPanel.add(octalRadio);
        radioPanel.add(hexadecimalRadio);

        group.add(decimalRadio);
        group.add(binaryRadio);
        group.add(octalRadio);
        group.add(hexadecimalRadio);

        return radioPanel;
    }

    private JPanel createOperationPanel() {
        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(1, 4));
        operationPanel.add(decimal);
        operationPanel.add(binary);
        operationPanel.add(octal);
        operationPanel.add(hexadecimal);
        return operationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int theAnswer;
            int inputBase = 10;

            if (binaryRadio.isSelected()) {
                inputBase = 2;
            } else if (octalRadio.isSelected()) {
                inputBase = 8;
            } else if (hexadecimalRadio.isSelected()) {
                inputBase = 16;
            }

            theAnswer = Integer.parseInt(input.getText(), inputBase);

            if (e.getSource() == decimal) {
                answer.setText(String.valueOf(theAnswer));
            } else if (e.getSource() == binary) {
                answer.setText(Integer.toBinaryString(theAnswer));
            } else if (e.getSource() == octal) {
                answer.setText(Integer.toOctalString(theAnswer));
            } else if (e.getSource() == hexadecimal) {
                answer.setText(Integer.toHexString(theAnswer));
            }
        } catch (NumberFormatException ex) {
            answer.setText("Error: Please enter a valid number for the selected base");
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}