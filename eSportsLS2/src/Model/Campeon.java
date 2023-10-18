package Model;

public class Campeon {
    private String name;
    private String counter_picks;

    public Campeon() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCounter_picks() {
        return counter_picks;
    }
    public void setCounter_picks(String counter_picks) {
        this.counter_picks = counter_picks;
    }

    @Override
    public String toString() {
        return "Model.Campeon{" +
                "name='" + name + '\'' +
                ", counter_picks='" + counter_picks + '\'' +
                '}';
    }
}