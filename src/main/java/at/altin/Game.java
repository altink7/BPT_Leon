package at.altin;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);


        JButton button = new JButton("Button");
        button.setBounds(100, 100, 100, 40);
        button.setBackground(Color.RED);
        button.setForeground(Color.GREEN);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 500));
        panel.add(button);


        if(button.getModel().isPressed()){
            Graphics g = panel.getGraphics();
            g.setColor(Color.BLUE);
            g.fillRect(2005, 2005, 2005, 2005);

            panel.add(button);
            panel.repaint();
        }

        JLabel label = new JLabel();
        label.setText("Hi");
        label.setBounds(0, 0, 75, 75);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 400));
        panel.add(label);

        Graphics g = panel.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 100, 100);
        g.setColor(Color.RED);
        g.fillOval(125, 125, 50, 50);
        panel.add(button);
        panel.repaint();
    }
}
