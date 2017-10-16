package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class NumberLine extends JPanel {
    private int value;
    private Color green1 = new Color(32, 77, 2);

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int maxXValue = getWidth();
        int maxYValue = getHeight();
        Line2D.Float xline = new Line2D.Float((float) maxXValue/6f, (float) maxYValue/2f, (float) maxXValue * (5f/6f), (float) maxYValue/2f);
        Line2D.Float yline = new Line2D.Float( (float) maxXValue/ 2f, (float) maxYValue * (8f/20f), (float) maxXValue/2f, (float) maxYValue *(12f/20f));
        g2.draw(xline);
        g2.draw(yline);
        Ellipse2D.Float cir = new Ellipse2D.Float((float) (maxXValue/6f + (4f * value/600f) * (maxXValue) - 5f), (float) ((maxYValue/2f) - 5f), 10F, 10F );
        g2.setColor(green1);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(cir);
    }


    public NumberLine(int val0) {
        value = val0;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,200);
        NumberLine num = new NumberLine(100);
        frame.setContentPane(num);
        frame.setVisible(true);

    }
}
