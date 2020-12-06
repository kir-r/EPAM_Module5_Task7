package Vegetables;

import java.io.Serializable;

public abstract class Vegetables implements Serializable {
    private String name;
    private int calories;
    private int weight;

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vegetables(String name, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vegetable: " + name + "\n" +
                "calories: " + calories + "\n" +
                "weight: " + weight + "\n";
    }
}
