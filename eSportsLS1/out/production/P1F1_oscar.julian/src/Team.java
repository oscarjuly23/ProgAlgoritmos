import java.util.ArrayList;

public class Team {
    private String team;
    private float winrate;
    private ArrayList<Jugador> jugadores = new ArrayList();

    public Team() {
    }

    public float getWinrate() {
        return winrate;
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }


    @Override
    public String toString() {
        return "Team{" +
                "team='" + team + '\'' +
                ", winrate=" + winrate +
                ", jugadors=" + jugadores +
                '}';
    }
}