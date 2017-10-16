package com.michaelGV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.michaelGV.Party.*;

public class JobsScreen extends JPanel implements ActionListener {
    private ArrayList<ParlMember> selMps;
    private ButtonGroup option;
    private JButton goVote;
    private JButton nextProp;
    private JPanel row1 = new JPanel();
    private JPanel row1a = new JPanel();
    private JPanel row1b = new JPanel();
    private JPanel row3 = new JPanel();
    private JPanel row4 = new JPanel();
    private InformationScreen info;
    private InterListener inter;
    private int loop;
    private int curProp;
    private HashMap<Integer, JCheckBox> boxesMap = new HashMap<>();

    public JobsScreen(int loopTimer, int currentProp, InformationScreen info0) {
        loop = loopTimer;
        curProp = currentProp;
        BorderLayout jobsLayout = new BorderLayout();
        setLayout(jobsLayout);

        BorderLayout row1Layout = new BorderLayout();
        row1.setLayout(row1Layout);

        info = info0;
        info.remove(info.row2);
        row1a.add(info);

        JLabel exp = new JLabel("<html><span style='font-size:8px'>Your Chief Whip is predicting that you will receive " + ParlMember.getExpVotesFor(currentProp, 1) + " votes with your current proposal as things stand.<br> 250 MPs would constitute a majority. The following MPs are undecided about which way to vote:</span></html>");
        row1b.add(exp);

        row1.add(row1a, BorderLayout.NORTH);
        row1.add(row1b, BorderLayout.SOUTH);

        BorderLayout row3Layout = new BorderLayout();
        row3.setLayout(row3Layout);

        JPanel row3a = new JPanel();
        JPanel row3b = new JPanel();

        GridLayout row3aLayout = new GridLayout(1, 12);
        row3a.setLayout(row3aLayout);
        row3a.add(new JLabel("<html><u>Name</u></html>", SwingConstants.CENTER));
        row3a.add(new JLabel("<html><u>Party</u></html>", SwingConstants.CENTER));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel("<html><u>Political<br> Position</u></html>", SwingConstants.CENTER));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel("<html><u>Loyalty</u></html>", SwingConstants.CENTER));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel("<html><u>Ambition</u></html>", SwingConstants.CENTER));
        row3a.add(new JLabel(""));
        row3a.add(new JLabel("<html><u>Offer a Ministerial<br> Position</u></html>", SwingConstants.CENTER));

        selMps = ParlMember.selMpsProbSup(10, currentProp, .4, .6);
        GridLayout row3bLayout = new GridLayout(selMps.size(), 12);
        row3b.setLayout(row3bLayout);
        option = new ButtonGroup();
        if(selMps.size() > 0) {
            for (int i = 0; i < selMps.size(); i++) {
                row3b.add(new JLabel("<html><span style='font-size:8px'>" + selMps.get(i).getMpName() + "</span></html>", SwingConstants.CENTER));
                row3b.add(new JLabel("<html><span style='font-size:8px'>" + selMps.get(i).getParty().getPartyName() + "</span></html>", SwingConstants.CENTER));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Left</span></html>", SwingConstants.RIGHT));
                row3b.add(new NumberLine(selMps.get(i).getVisiblePosition()));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Right</span></html>", SwingConstants.LEFT));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Disloyal</span></html>", SwingConstants.RIGHT));
                row3b.add(new NumberLine(selMps.get(i).getVisibleLoyalty()));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Loyal</span></html>", SwingConstants.LEFT));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Unambitious</span></html>", SwingConstants.RIGHT));
                row3b.add(new NumberLine(selMps.get(i).getVisibleAmbition()));
                row3b.add(new JLabel("<html><span style='font-size:6px'>Ambitious</span></html>", SwingConstants.LEFT));
                if (selMps.get(i).getParty().equals(Party.getGovernment())) {
                    boxesMap.put(i, new JCheckBox("", false));
                    option.add(boxesMap.get(i));
                    row3b.add(boxesMap.get(i));
                } else {
                    row3b.add(new JLabel("<html><span style='font-size:8px'>Not in<br> Your Party</span></html>"));
                }
            }
        }
        row3.add(row3a, BorderLayout.NORTH);
        row3.add(row3b, BorderLayout.CENTER);

        goVote = new JButton("<html><span style='font-size:7px'>Offer selected MP a ministerial role,<br> and go to the vote in parliament advocating this policy</span></html>");
        if (loop < 2) {
            nextProp = new JButton("<html><span style='font-size:7px'>Offer selected MP a ministerial role,<br> and enter a new initial policy proposal</span></html>");
            nextProp.addActionListener(this);
            row4.add(nextProp);
        }
        goVote.addActionListener(this);
        row4.add(goVote);

        add(row1, BorderLayout.NORTH);
        add(row3, BorderLayout.CENTER);
        add(row4, BorderLayout.SOUTH);

    }

    public void setInter(InterListener listener) {
        this.inter = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == nextProp) {
            if(inter != null) {
                boolean flag = false;
                int mpId = -1;
                if(boxesMap.size() > 0 ) {
                    for (Map.Entry<Integer, JCheckBox> entry : boxesMap.entrySet()) {
                        if (entry.getValue().isSelected()) {
                            flag = true;
                            mpId = entry.getKey();
                        }
                    }
                    if (flag) {
                        selMps.get(mpId).offerJob();
                    }
                }
                inter.newProposalScreen(loop + 1, curProp);
            }
        }
        if((JButton) e.getSource() == goVote) {
            if(inter != null) {
                boolean flag = false;
                int mpId = -1;
                if(boxesMap.size() > 0 ) {
                    for (Map.Entry<Integer, JCheckBox> entry : boxesMap.entrySet()) {
                        if (entry.getValue().isSelected()) {
                            flag = true;
                            mpId = entry.getKey();
                        }
                    }
                    if (flag) {
                        selMps.get(mpId).offerJob();
                    }
                }
                inter.goVoteScreen(curProp);
            }
        }
    }

    public static void main(String[] args) {
        generateParties(3);
        ParlMember.generateMps();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        InformationScreen info = new InformationScreen();
        JobsScreen jobs = new JobsScreen(1, 30,  info);
        frame.setContentPane(jobs);
        frame.setVisible(true);
    }

}
