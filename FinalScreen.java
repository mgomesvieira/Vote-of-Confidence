package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.michaelGV.Party.generateParties;

public class FinalScreen extends JPanel implements ActionListener {
    private JPanel row1 = new JPanel();
    private JPanel row2 = new JPanel();
    private JButton reset = new JButton("Reset");
    private InterListener inter;

    public FinalScreen(int votes) {
        row1.setLayout(new GridBagLayout());

        if (votes > 249) {
            JLabel survived = new JLabel("<html><span style='font-size:16px'>" + votes + " votes to the right. <br>" + (499 - votes) + " votes to the left.<br> The ayes have it! The ayes have it!<br> Well done, you survived your vote of confidence</span></html>", SwingConstants.CENTER);
            row1.add(survived);
        } else {
            JLabel replaced = new JLabel("<html><span style='font-size:16px'>" + votes + " votes to the right. <br>" + (499 - votes) + " votes to the left.<br> The nos have it! The nos have it!<br> Your government has been ousted...</span></html>", SwingConstants.CENTER);
            row1.add(replaced);
        }

        reset.addActionListener(this);
        row2.add(reset);

        BorderLayout finalLayout = new BorderLayout();
        setLayout(finalLayout);

        add(row1, BorderLayout.CENTER);
        add(row2, BorderLayout.SOUTH);
    }

    public void setInter(InterListener listener) {
        this.inter = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == reset) {
            if(inter != null) {
                inter.resetFrame();
            }
        }
    }


    public static void main(String[] args) {
        generateParties(3);
        ParlMember.generateMps();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        FinalScreen fin = new FinalScreen(250);
        frame.setContentPane(fin);
        frame.setVisible(true);
    }
}
