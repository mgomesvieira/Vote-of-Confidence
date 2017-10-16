package com.michaelGV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Party {
    private int partyId;
    private int position;
    private String name;
    private int numMps = 0;
    private String possessive;
    private static ArrayList<Party> partys = new ArrayList<Party>(3);
    private ArrayList<ParlMember> mpsInParty = new ArrayList<ParlMember>(200);

    public Party(int id0, int pos0) {
        partyId = id0;
        position = pos0;
    }

    public static ArrayList<Party> getPartys() {
        return partys;
    }

    public ArrayList<ParlMember> getMpsInParty() {
        return this.mpsInParty;
    }

    public int getPartyId() { return this.partyId; }

    public void increaseNumMps() {
        this.numMps++;
    }

    public void setPartyName(String nam0) {
        name = nam0;
    }

    public void setPossessive(String nam0) {
        possessive = nam0;
    }

    public int getPartyPosition() {
        return position;
    }

    public String getPartyName() {
        return name;
    }

    public String getPossessive() {
        return possessive;
    }

    public int getNumMps() {
        return numMps;
    }

    public void insertMpPos(ParlMember mp0) {
        mpsInParty.add(mp0);
    }

    public int getMedianMpPos() {
        Collections.sort(this.mpsInParty, PartyMpsPolicyComparator);
        if (this.mpsInParty.size() % 2 == 1) {
            int middle = (this.mpsInParty.size() + 1) / 2;
            return this.mpsInParty.get(middle).getVisiblePosition();
        } else {
            int middle = this.mpsInParty.size() / 2;
            return (this.mpsInParty.get(middle).getVisiblePosition() + this.mpsInParty.get(middle).getVisiblePosition()) / 2;
        }
    }

    public static Party getClosestParty(int x) {
        int distance = Math.abs(partys.get(0).getPartyPosition() - x);
        int idx = 0;
        for(int c = 1; c < partys.size(); c++){
            int cdistance = Math.abs(partys.get(c).getPartyPosition() - x);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return partys.get(idx);
    }

    public static Comparator<Party> PartyPositionComparator = new Comparator<Party>() {
        @Override
        public int compare(Party o1, Party o2) {

            int pos1 = o1.getPartyPosition();
            int pos2 = o2.getPartyPosition();

            return pos1 - pos2;
        }
    };

    public static Comparator<Party> PartyMpsComparator = new Comparator<Party>() {
        @Override
        public int compare(Party o1, Party o2) {

            int pos1 = o1.getNumMps();
            int pos2 = o2.getNumMps();

            //Descending Order
            return pos2 - pos1;
        }
    };

    public static Comparator<ParlMember> PartyMpsPolicyComparator = new Comparator<ParlMember>() {
        @Override
        public int compare(ParlMember o1, ParlMember o2) {

            int pos1 = o1.getVisiblePosition();
            int pos2 = o2.getVisiblePosition();

            return pos1 - pos2;
        }
    };

    public boolean areGovernment() {
        Collections.sort(partys, PartyMpsComparator);
        if(partys.get(0) == this) {
            return true;
        }
        return false;
    }

    public static Party getGovernment() {
        Collections.sort(partys, PartyMpsComparator);
        return partys.get(0);
    }

    public static Party getOpposition() {
        Collections.sort(partys, PartyMpsComparator);
        return partys.get(1);
    }

    public boolean areOpposition() {
        Collections.sort(partys, PartyMpsComparator);
        if(partys.get(1) == this) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "The Party Position of the " + getPartyName() + " is " + getPartyPosition();
    }

    public static void generateParties(int n) {
        partys.clear();
        ArrayList<Integer> ranPos = RanNoRep.genRanNoRep(n, 0, 100);
        for(int i = 0; i < n; i++) {
            int ran0 = ranPos.get(i);
            partys.add(i, new Party(i, ran0));
        }

        Collections.sort(partys, PartyPositionComparator);

        partys.get(0).setPartyName("Workers Party");
        partys.get(0).setPossessive("has");
        partys.get(1).setPartyName("Liberals");
        partys.get(1).setPossessive("have");
        partys.get(2).setPartyName("Royalists");
        partys.get(2).setPossessive("have");
    }

    public static void main(String[] args) {
        generateParties(3);

        for(int i = 0; i < 3; i++) {
            System.out.println(partys.get(i).toString());
        }
        System.out.println("The closest party to 50 are the " + getClosestParty(50).getPartyName());
    }
}
