import java.util.ArrayList;

public class Jugador {
    private String name;
    private int total_kills;
    private int total_assistances;
    private int total_deaths;
    private String nationality;
    private String main_position;
    private ArrayList<Legend> main_legends = new ArrayList();
    private float winrate;
    private float KDA;

    public Jugador() {
    }

    public float getWinrate() {
        return winrate;
    }
    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }
    public float getKDA() {
        return KDA = ((total_kills + total_assistances) * 0.5f) / total_deaths;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "name='" + name + '\'' +
                ", total_kills=" + total_kills +
                ", total_assistances=" + total_assistances +
                ", total_deaths=" + total_deaths +
                ", nationality='" + nationality + '\'' +
                ", main_position='" + main_position + '\'' +
                ", main_legends=" + main_legends +
                '}';
    }
}