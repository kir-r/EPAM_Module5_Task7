package Candies;

import java.io.Serializable;

public abstract class Candy implements Serializable {
    private String name;
    private int weight;
    private double sugar;
    private String manufacturer;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getSugar() {
        return sugar;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Candy(String name, int weight, double sugar, String manufacturer) {
        this.name = name;
        this.weight = weight;
        this.sugar = sugar;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Candy " + name + "\n" +
                "weight: " + weight + "\n" +
                "sugar: " + sugar + "\n" +
                "manufacturer: " + manufacturer + "\n";
    }
}
