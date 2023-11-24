package at.altin.dartpunkterechner;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.*;

// waehrend der BPT von Leon, wurde diese kleine Applikation erstellt
public class DartPunkteRechner extends Canvas implements Runnable {
    private int remainingPoints;
    private JTextField inputField;
    private JLabel remainingPointsLabel;


    public static void main(String[] args) {
        DartPunkteRechner dartPunkteRechner = new DartPunkteRechner();
        Thread thread = new Thread(dartPunkteRechner);
        thread.start();
    }

    @Override
    public void run() {
        chooseGameType();
    }

    private void chooseGameType() {
        JFrame frame = new JFrame("Dart Punkte Rechner");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btn301 = new JButton("301");
        JButton btn501 = new JButton("501");

        btn301.addActionListener(e -> {
            remainingPoints = 301;
            startGame();
            frame.setVisible(false);
        });

        btn501.addActionListener(e -> {
            remainingPoints = 501;
            startGame();
            frame.setVisible(false);
        });

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.add(btn301);
        panel.add(btn501);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void startGame() {
        JFrame frame = new JFrame("Dart Punkte Rechner");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Add label to display remaining points
        remainingPointsLabel = new JLabel("Remaining Points: " + remainingPoints);
        panel.add(remainingPointsLabel);

        // Add input field for the user to enter throws
        inputField = new JTextField();
        panel.add(inputField);

        JButton throwDartButton = new JButton("Throw Dart");
        throwDartButton.addActionListener(e -> handleInputAndThrow());

        panel.add(throwDartButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void handleInputAndThrow() {
        boolean invalid = false;
        String input = inputField.getText();
        String[] dartThrows = input.split(",");

        int totalThrowPoints = 0;

        for (String dartThrow : dartThrows) {
            // format is like "T20", "D12", "7"
            char multiplier = dartThrow.charAt(0);
            int points = Integer.parseInt(dartThrow.substring(1));

            boolean isMitte = (points == 25 || points == 50) && multiplier == 'S';

            if(!isMitte && points > 20) {
                 invalid = true;
            } else {

                switch (multiplier) {
                    case 'T':
                        totalThrowPoints += points * 3;
                        break;
                    case 'D':
                        totalThrowPoints += points * 2;
                        break;
                    case 'S':
                        totalThrowPoints += points;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid input: " + dartThrow);
                        return;
                }
            }
        }

        if(invalid) {
            JOptionPane.showMessageDialog(null, "Invalid points!" );
        }
        else if (totalThrowPoints <= remainingPoints) {
            remainingPoints -= totalThrowPoints;

            remainingPointsLabel.setText("Remaining Points: " + remainingPoints);

            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "Congratulations! You won!");
                System.exit(0);
            } else if(remainingPoints <= 180){
                suggestThrows(remainingPoints);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bust! Total points exceed remaining points.");
        }
    }

    private void suggestThrows(int remainingPoints) {
        JFrame suggestFrame = new JFrame("Suggested Throws");
        suggestFrame.setSize(300, 200);
        suggestFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel suggestPanel = new JPanel(new GridLayout(0, 1));

        JLabel suggestLabel = new JLabel("Suggested Throws:");
        suggestPanel.add(suggestLabel);

        String suggestedThrows = calculateSuggestedThrows(remainingPoints);
        JLabel throwsLabel = new JLabel(suggestedThrows);
        suggestPanel.add(throwsLabel);

        suggestFrame.add(suggestPanel);
        suggestFrame.setVisible(true);
    }

    private String calculateSuggestedThrows(int remainingPoints) {
        StringBuilder suggestedThrows = new StringBuilder();

        for (int multiplier = 3; multiplier >= 1; multiplier--) {
            for (int points = 20; points >= 1; points--) {
                int throwValue = multiplier * points;

                if (throwValue <= remainingPoints) {
                    suggestedThrows.append(String.format("%s%d,", getMultiplierSymbol(multiplier), points));
                    remainingPoints -= throwValue;

                    if (remainingPoints == 0) {
                        suggestedThrows.deleteCharAt(suggestedThrows.length() - 1);
                        return suggestedThrows.toString();
                    }
                }
            }
        }

        return suggestedThrows.toString();
    }

    private String getMultiplierSymbol(int multiplier) {
        return switch (multiplier) {
            case 3 -> "T";
            case 2 -> "D";
            case 1 -> "S";
            default -> "";
        };
    }
}
