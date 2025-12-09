import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisionUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Integer Division");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel num1Label = new JLabel("Num1:");
        JTextField num1Field = new JTextField();

        JLabel num2Label = new JLabel("Num2:");
        JTextField num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton divideButton = new JButton("Divide");

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());

                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }

                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid integers!",
                            "NumberFormatException",
                            JOptionPane.ERROR_MESSAGE);
                }
                catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame,
                            ex.getMessage(),
                            "ArithmeticException",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(new JLabel());
        frame.add(divideButton);

        frame.setVisible(true);
    }
}
