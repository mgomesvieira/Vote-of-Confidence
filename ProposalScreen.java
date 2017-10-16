package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.michaelGV.ParlMember.generateMps;
import static com.michaelGV.Party.generateParties;
import static com.michaelGV.Party.getPartys;

public class ProposalScreen extends JPanel implements ActionListener{
    private JButton iniProp;
    private JButton finalProp;
    private JPanel row1 = new JPanel();
    private JPanel row2 = new JPanel();
    private JPanel row3 = new JPanel();
    private InformationScreen info;
    private InterListener inter;
    private JSlider policy;
    private int loop;
    private int prop;

    public ProposalScreen(int loopTimer, int previousProp, InformationScreen info0) {
        BorderLayout proposalLayout = new BorderLayout();
        setLayout(proposalLayout);
        loop = loopTimer;

        info = info0;
        info.remove(info.row2);
        row1.add(info);

        GridLayout row2Layout = new GridLayout(1, 4);
        row2.setLayout(row2Layout);
        JLabel dscr = new JLabel("<html>Move the slider to<br> select your policy:</html>", SwingConstants.CENTER);
        JLabel left = new JLabel("Left", SwingConstants.RIGHT);
        policy = new JSlider(0, 100, previousProp);
        JLabel right = new JLabel("Right");
        row2.add(dscr);
        row2.add(left);
        row2.add(policy);
        row2.add(right);

        if(loop == 2) {
            finalProp = new JButton("Submit your final Policy Proposal for the House to Vote on");
            finalProp.addActionListener(this);
            row3.add(finalProp);
        } else {
            iniProp = new JButton("Submit an initial Policy Proposal");
            iniProp.addActionListener(this);
            row3.add(iniProp);
        }

        add(row1, BorderLayout.NORTH);
        add(row2, BorderLayout.CENTER);
        add(row3, BorderLayout.SOUTH);
    }

    public ProposalScreen(int loopTimer, InformationScreen info0) {
        this(loopTimer, 50, info0);
    }

    public void setInter(InterListener listener) {
        this.inter = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource() == iniProp) | ((JButton) e.getSource() == finalProp)) {
            if(inter != null) {
                prop = policy.getValue();
                inter.goJobsScreen(loop, prop);
            }
        }
    }

    public static void main(String[] args) {
        generateParties(3);
        generateMps();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        InformationScreen info = new InformationScreen();
        ProposalScreen prop = new ProposalScreen(2, 24, info);
        frame.setContentPane(prop);
        frame.setVisible(true);
    }
}
