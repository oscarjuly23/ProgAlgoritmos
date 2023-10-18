package Model;

import java.util.ArrayList;

public class Player {
    private String name;
    private String main_position;
    private ArrayList<Player> main_champion = new ArrayList();

    public Player() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMain_position() {
        return main_position;
    }
    public void setMain_position(String main_position) {
        this.main_position = main_position;
    }
    public ArrayList<Player> getMain_champion() {
        return main_champion;
    }
    public void setMain_champion(ArrayList<Player> main_champion) {
        this.main_champion = main_champion;
    }

    @Override
    public String toString() {
        return "Model.Player{" +
                "name='" + name + '\'' +
                ", main_position='" + main_position + '\'' +
                ", main_champion=" + main_champion +
                '}';
    }
}