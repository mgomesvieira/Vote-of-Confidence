package com.michaelGV;

public interface InterListener {
    public void getInfoScreen();

    public void firstProposalScreen(int i);

    public void newProposalScreen(int i, int prop);

    public void goJobsScreen(int i, int prop);

    public void goVoteScreen(int finProp);

    public void resetFrame();
}
