package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialScreen extends JPanel implements ActionListener {
    JPanel row1 = new JPanel();
    //ImageIcon startPanel = new ImageIcon(this.getClass().getResource("/images/startPanel.png"));
    JTextArea initial = new JTextArea("Be the Prime Minister, survive the vote of Confidence! \n    " +
            "You have three turns to suggest policy proposals. Each turn " +
            "you will put forwards a policy proposal your chief whip will then " +
            "report an estimate of how MPs will vote, and which MPs are on the " +
            "fence. \n    Offer those MPs from your party a position of responsibility " +
            "to gain their loyalty or amend your policy to get more MPs to vote with your " +
            "government. \n    " +
            "At the end of the third round (or earlier if you choose to skip straight " +
            "to vote), parliament votes and decides your fate. " +
            "\n    Each scenario is randomly generated, so you can play again and again " +
            "to test your skill!");
    private InterListener inter;


    JPanel row2 = new JPanel();
    JButton start = new JButton("Start");

    public InitialScreen() {
        BorderLayout iniLayout = new BorderLayout();
        setLayout(iniLayout);

        row1.setLayout(new GridLayout(1, 1));

        initial.setFont(new Font("Serif", Font.PLAIN, 30));
        initial.setLineWrap(true);
        initial.setWrapStyleWord(true);
        initial.setOpaque(false);
        initial.setEditable(false);

        start.addActionListener(this);
        row1.add(initial);
        row2.add(start);

        add(row1, BorderLayout.CENTER);
        add(row2, BorderLayout.SOUTH);
    }

    public void setInter(InterListener listener) {
        this.inter = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == start) {
            if(inter != null) {
                inter.getInfoScreen();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        InitialScreen ini = new InitialScreen();
        frame.setContentPane(ini);
        frame.setVisible(true);
    }
}
