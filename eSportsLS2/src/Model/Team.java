package Model;

import java.util.ArrayList;

public class Team {
    private String team;
    private String nationality;
    private float winrate;
    private ArrayList<Player> players = new ArrayList();
    private int countersTotals;
    private boolean v = false;

    public Team() {
    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public float getWinrate() {
        return winrate;
    }
    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public int getCountersTotals() {
        return countersTotals;
    }
    public void setCountersTotals(int countersTotals) {
        this.countersTotals = countersTotals;
    }
    public boolean isV() {
        return v;
    }
    public void setV(boolean v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team='" + team + '\'' +
                ", nationality='" + nationality + '\'' +
                ", winrate=" + winrate +
                ", players=" + players +
                ", countersTotals=" + countersTotals +
                ", v=" + v +
                '}';
    }
}