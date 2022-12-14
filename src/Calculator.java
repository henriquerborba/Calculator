import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Calculator {
    private JPanel Calculator;
    private JTextField txtDisplay;
    private JButton a0Button;
    private JButton multiplicationButton;
    private JButton subtractionButton;
    private JButton rightBracketButton;
    private JButton plusButton;
    private JButton divisionButton;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton leftBracketButton;
    private JButton backSpaceButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton dotButton;
    private JButton acButton1;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton equalsButton;
    private JLabel errorLabel;
    private JButton senButton;
    private JButton cosButton;
    private JButton tgButton;
    private JButton squareButton;

    Double result;
    public Calculator() {
        acButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a0Button.getText());
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a1Button.getText());
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a2Button.getText());
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a3Button.getText());
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a4Button.getText());
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a5Button.getText());
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a6Button.getText());
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a7Button.getText());
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a8Button.getText());
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a9Button.getText());
            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + ".");
            }
        });
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "/");
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "*");
            }
        });
        subtractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "-");
            }
        });
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "+");
            }
        });
        backSpaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtDisplay.getText();
                if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
                    str = str.substring(0, str.length() - 1);
                }
                txtDisplay.setText(str.substring(0, str.length() - 1));
            }
        });
        rightBracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + ")");
            }
        });
        leftBracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "(");
            }
        });

        senButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "sin");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "cos");
            }
        });

        tgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "tan");
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "sqrt");
            }
        });

        acButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        });
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double result = EvaluateString.eval(txtDisplay.getText());
                    txtDisplay.setText(Double.toString(result));
                } catch (Exception error) {
                    System.out.println(error.toString());
                    errorLabel.setText(error.getMessage());
                    errorLabel.setVisible(true);
                    hideError(5000);
                }
            }
        });
    }

    private void hideError(int delay) {
        final Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");
                errorLabel.setVisible(false);
            }
        });
        timer.stop();
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Path currentRelativePath = Paths.get("");
        ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/assets/icon.png");
        frame.setIconImage(img.getImage());
        LookAndFeel feel = UIManager.getLookAndFeel();
        String systemLF = UIManager.getSystemLookAndFeelClassName();

        try {
            UIManager.setLookAndFeel(systemLF);
        } catch (Exception e) {
            LookAndFeel feel2 = UIManager.getLookAndFeel();
        }
        frame.pack();
        frame.setVisible(true);
    }
}
