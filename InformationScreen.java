package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.michaelGV.Party.*;
import static com.michaelGV.ParlMember.*;

public class InformationScreen extends JPanel implements ActionListener {
    private JPanel row1 = new JPanel();
    private JLabel party0;
    private JPanel partyPos0;
    private JLabel party1;
    private JPanel partyPos1;
    private JLabel party2;
    private JPanel partyPos2;
    private InterListener inter;
    private ArrayList<Party> pars;

    JPanel row2 = new JPanel();

    JButton propose = new JButton("Propose a Policy");

    public InformationScreen() {
        BorderLayout infoLayout = new BorderLayout();
        setLayout(infoLayout);

        pars = getPartys();

        party0 = new JLabel("The " + pars.get(0).getPartyName() + " " + pars.get(0).getPossessive() + " " + pars.get(0).getNumMps() + " MPs, and " + pars.get(0).getPossessive() + " a median policy:", SwingConstants.CENTER);
        partyPos0 = new partyPosPanel(pars.get(0).getMedianMpPos());

        party1 = new JLabel("The " + pars.get(1).getPartyName() + " " + pars.get(1).getPossessive() + " " + pars.get(1).getNumMps() + " MPs, and " + pars.get(1).getPossessive() + " a median policy:", SwingConstants.CENTER);
        partyPos1 = new partyPosPanel(pars.get(1).getMedianMpPos());

        party2 = new JLabel("The " + pars.get(2).getPartyName() + " " + pars.get(2).getPossessive() + " " + pars.get(2).getNumMps() + " MPs, and " + pars.get(2).getPossessive() + " a median policy:", SwingConstants.CENTER);
        partyPos2 = new partyPosPanel(pars.get(2).getMedianMpPos());

        BorderLayout row1Layout = new BorderLayout();
        row1.setLayout(row1Layout);
        JPanel row1a = new JPanel();
        JPanel row1b = new JPanel();

        GridLayout row1aLayout = new GridLayout(3, 4);
        row1a.setLayout(row1aLayout);
        row1a.add(party0);
        row1a.add(partyPos0);
        row1a.add(party1);
        row1a.add(partyPos1);
        row1a.add(party2);
        row1a.add(partyPos2);

        JLabel leader = new JLabel("<html>You are the Party Leader of the " + getGovernment().getPartyName() + ".</html>");
        row1b.add(leader);
        propose.addActionListener(this);

        row1.add(row1a, BorderLayout.CENTER);
        row1.add(row1b, BorderLayout.SOUTH);
        row2.add(propose);

        add(row1, BorderLayout.CENTER);
        add(row2, BorderLayout.SOUTH);
    }

    private class partyPosPanel extends JPanel{
        JPanel panel = new JPanel();
        private partyPosPanel(int x) {
            GridLayout panelLayout = new GridLayout(1, 3);
            setLayout(panelLayout);
            JLabel left = new JLabel("Left", SwingConstants.RIGHT);
            JLabel right = new JLabel("Right");
            NumberLine num = new NumberLine(x);
            add(left);
            add(num);
            add(right);
        }
    }

    public void setInter(InterListener listener) {
        this.inter = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == propose) {
            if(inter != null) {
                inter.firstProposalScreen(0);
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
        frame.setContentPane(info);
        frame.setVisible(true);
    }
}
