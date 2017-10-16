package com.michaelGV;

import java.util.ArrayList;

import static com.michaelGV.Forename.getRandomForename;
import static com.michaelGV.Party.*;
import static com.michaelGV.Surname.getRandomSurname;

public class ParlMember {
    private int mpId;
    private String forename;
    private String surname;
    private String seat;
    private int ambition;
    private int visibleAmbition;
    private int loyalty;
    private int visibleLoyalty;
    private int position;
    private int visiblePosition;
    private Party party;
    private int governing;
    private int opposition;
    private int ambEta;
    private int loyEta;
    private int posEta;
    private static ArrayList<ParlMember> mps = new ArrayList<ParlMember>(498);

    public ParlMember(int id0, String fore0, String sur0, String seat0, int amb0, int loy0, int pos0, Party par0) {
        mpId = id0;
        forename = fore0;
        surname = sur0;
        seat = seat0;
        ambition = amb0;
        ambEta = -5 + (int) (Math.random()* 11);
        if (amb0 + ambEta < 0) {
            visibleAmbition = 0;
        } else if (amb0 + ambEta > 100) {
            visibleAmbition = 100;
        } else {
            visibleAmbition = amb0 + ambEta;
        }
        loyalty = loy0;
        loyEta = -5 + (int) (Math.random()* 11);
        if (loy0 + loyEta < 0) {
            visibleLoyalty = 0;
        } else if (loy0 + loyEta > 100) {
            visibleLoyalty = 100;
        } else {
            visibleLoyalty = loy0 + loyEta;
        }
        position = pos0;
        posEta = -5 + (int) (Math.random()* 11);
        if (pos0 + posEta < 0) {
            visiblePosition = 0;
        } else if (pos0 + posEta > 100) {
            visiblePosition = 100;
        } else {
            visiblePosition = pos0 + posEta;
        }
        party = par0;
        party.increaseNumMps();
        mps.add(this);
        party.insertMpPos(this);
    }

    public void giveGovStatus() {
        if(this.party.areGovernment()) {
            this.governing = 1;
        } else if (this.party.areOpposition()) {
            this.opposition = 1;
        } else {
            this.governing = 0;
            this.opposition = 0;
        }
    }

    public static ArrayList<ParlMember> getMps() {
        return mps;
    }

    public int getMpId() { return  this.mpId; }

    public String getMpName(){
        return forename + " " + surname;
    }

    public String getSeat() {
        return seat;
    }

    public Party getParty() {return party; }

    public int getAmbition() {
        return ambition;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getPosition() {
        return position;
    }

    public int getVisibleAmbition() {
        return visibleAmbition;
    }

    public int getVisibleLoyalty() {
        return visibleLoyalty;
    }

    public int getVisiblePosition() {
        return visiblePosition;
    }

    public String toString() {
        return forename + " " + surname +  " is the MP for " + seat + ". Their party is the " + party.getPartyName() + " and they have policy preference " + visiblePosition + ", loyalty "
                + visibleLoyalty + ", and ambition " + visibleAmbition + ". Governing: " + governing + " Opposition: " + opposition;
    }

    public double getProbSup(int x) {
        return 1/(1 + Math.pow(Math.E, -(-.402*Math.abs(x - position )*(1 - governing) - .995*Math.abs( x - position )*(opposition)  +
                (-.435 *Math.abs( x - position ) -.05 * ambition + .8* loyalty )* governing - .7* (1 - governing) + 10)));
    }

    public int getBinaryVote(double p) {
        double y = Math.random();
        if (y < p) {
            return 1;
        }
        return 0;
    }

    public static int addVotes(int x, int playrVote) {
        int total = playrVote;
        for (int i = 0; i < mps.size(); i++) {
            total += mps.get(i).getBinaryVote(mps.get(i).getProbSup(x));
        }
        return total;
    }

    public void offerJob() {
        int x = (int) (.35 * this.ambition);
        if ((this.loyalty + x) > 100) {
            this.loyalty = 100;
        } else {
            this.loyalty += x;
        }
        if ((this.visibleLoyalty + x) > 100) {
            this.visibleLoyalty = 100;
        } else {
            this.visibleLoyalty += x;
        }
    }

    public static void generateMps() {
        mps.clear();
        for (int i = 0; i < 498; i++) {
            String fore = getRandomForename();
            String sur = getRandomSurname();
            String seat = Seat.getSeat(i);
            int amb = (int) (Math.random() * 101);
            int loy = (int) (Math.random() * 101);
            int pol = (int) (Math.random() * 101);
            Party par = Party.getClosestParty(pol);
            ParlMember mp = new ParlMember(i, fore, sur, seat, amb, loy, pol, par);
        }

        for (int i= 0; i < 498; i++) {
            mps.get(i).giveGovStatus();
        }
    }

    public static int getExpVotesFor(int x, int playrVote) {
        double expVotes = playrVote;
        for(int i = 0; i < 498; i++) {
            expVotes += mps.get(i).getProbSup(x);
        }
        return (int) expVotes;
    }

    public static ArrayList<ParlMember> selMpsProbSup(int n, int x, double cond0, double cond1) {
        ArrayList<ParlMember> mpsProbSup = new ArrayList<ParlMember>();
        for(int i = 0; i < 498; i++) {
            if((mps.get(i).getProbSup(x) > cond0) & (mps.get(i).getProbSup(x) < cond1)) {
                mpsProbSup.add(mps.get(i));
            }
        }
        ArrayList<ParlMember> selMps = new ArrayList<ParlMember>(n);
        if (mpsProbSup.size() > 0) {
            if (mpsProbSup.size() > n) {
                ArrayList<Integer> sel = RanNoRep.genRanNoRep(n, 0, mpsProbSup.size() - 1);
                for (int i = 0; i < n; i++) {
                    selMps.add(mpsProbSup.get(sel.get(i)));
                }
            } else {
                for (int i = 0; i < mpsProbSup.size(); i++) {
                    selMps.add(mpsProbSup.get(i));
                }
            }
        }
        return selMps;
    }

    public static void main(String[] args) {
        generateParties(3);
        generateMps();

        System.out.println("" + getExpVotesFor(50, 1));

        for (int i = 0; i < mps.size(); i++) {
            System.out.println(i + mps.get(i).toString() + mps.get(i).getProbSup(50));
        }

        mps.get(497).offerJob();
        System.out.println(497 + mps.get(497).toString() + mps.get(497).getProbSup(50));

        System.out.println(addVotes(50, 1));

    }
}

