package IntroductionCS.u12.day03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Fan extends JFrame {

    public Fan() {
        setLayout(new GridLayout(3,2));
        add(new FanCell(-10));
        add(new FanCell(5));
        add(new FanCell(-20));
        add(new FanCell(1));
        add(new FanCell(10));
        add(new FanCell(150));
    }

    public static void main(String[] args) {
        Fan frame = new Fan();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FanCell extends JPanel {
    static final int BORDER_WIDTH = 5;
    private int speed = -1;
    private int startAngle = 0;
    private boolean on = true;

    public FanCell(int speed) {
        this.speed = speed;
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (on)
                    startAngle += speed;
                    repaint();
            }
        });
        timer.start();



        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                on = !on;
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Draw the enclosing circle
        int dX = getWidth() - (2 * BORDER_WIDTH);
        int dY = getHeight() - (2 * BORDER_WIDTH);
        g.drawOval(BORDER_WIDTH, BORDER_WIDTH, dX, dY);

        // Draw Arcs
        int minX = 2 * BORDER_WIDTH;
        int minY = 2 * BORDER_WIDTH;
        int maxX = getWidth() - 2 * BORDER_WIDTH;
        int maxY = getHeight() - 2 * BORDER_WIDTH;
        dX = maxX - minX;
        dY = maxY - minY;

        g.fillArc(minX, minY, dX, dY, 10 +startAngle, 30);
        g.fillArc(minX, minY, dX, dY, 100 + startAngle, 30);
        g.fillArc(minX, minY, dX, dY, 190 + startAngle, 30);
        g.fillArc(minX, minY, dX, dY, 280 + startAngle, 30);


    }
}
