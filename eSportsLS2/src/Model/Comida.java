package Model;

public class Comida {
    private String name;
    private int energetic_value;
    private float fat;

    public Comida() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnergetic_value() {
        return energetic_value;
    }
    public void setEnergetic_value(int energetic_value) {
        this.energetic_value = energetic_value;
    }
    public float getFat() {
        return fat;
    }
    public void setFat(float fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Model.Comida{" +
                "name='" + name + '\'' +
                ", energetic_value=" + energetic_value +
                ", fat=" + fat +
                '}';
    }
}