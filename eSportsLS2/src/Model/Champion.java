package Model;

public class Champion {
    private String name;

    public Champion() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model.Champion{" +
                "name='" + name + '\'' +
                '}';
    }
}