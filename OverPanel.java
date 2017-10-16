package com.michaelGV;

import javax.swing.*;
import java.awt.*;

public class OverPanel extends JPanel {
    private InitialScreen initialScreen;
    private InformationScreen informationScreen;
    private ProposalScreen proposalScreen;
    private JobsScreen jobsScreen;
    private FinalScreen finalScreen;
    private InterListener inter0;

    public OverPanel() {
        BorderLayout overLayout = new BorderLayout();
        setLayout(overLayout);

        inter0 = new InterListener() {
            @Override
            public void getInfoScreen() {
                Party.generateParties(3);
                ParlMember.generateMps();
                informationScreen = new InformationScreen();
                informationScreen.setInter(inter0);
                remove(initialScreen);
                add(informationScreen);
                validate();
                repaint();
            }

            @Override
            public void firstProposalScreen(int i) {
                proposalScreen = new ProposalScreen(i, informationScreen);
                proposalScreen.setInter(inter0);
                remove(informationScreen);
                add(proposalScreen);
                validate();
                repaint();
            }

            @Override
            public void newProposalScreen(int i, int prop) {
                proposalScreen = new ProposalScreen(i, prop, informationScreen);
                proposalScreen.setInter(inter0);
                remove(jobsScreen);
                add(proposalScreen);
                validate();
                repaint();
            }

            @Override
            public void goJobsScreen(int i, int prop) {
                jobsScreen = new JobsScreen(i, prop, informationScreen);
                jobsScreen.setInter(inter0);
                remove(proposalScreen);
                add(jobsScreen);
                validate();
                repaint();
            }

            @Override
            public void goVoteScreen(int finProp) {
                finalScreen = new FinalScreen(ParlMember.addVotes(finProp, 1));
                finalScreen.setInter(inter0);
                remove(jobsScreen);
                add(finalScreen);
                validate();
                repaint();
            }

            @Override
            public void resetFrame() {
                initialScreen = new InitialScreen();
                initialScreen.setInter(inter0);
                remove(finalScreen);
                add(initialScreen);
                validate();
                repaint();
            }
        };

        initialScreen = new InitialScreen();
        initialScreen.setInter(inter0);
        add(initialScreen);
    }

    public static void main(String[] args) {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        OverPanel overPanel = new OverPanel();
        frame.setContentPane(overPanel);
        frame.setVisible(true);
    }
}
