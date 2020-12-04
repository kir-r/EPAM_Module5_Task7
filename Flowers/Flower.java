package Flowers;

import java.io.Serializable;

public abstract class Flower implements Serializable {
    private String name;
    private int price;
    private Freshness Fresh;
    private int stem;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public Freshness getFresh() {
        return Fresh;
    }
    public int getStem() {
        return stem;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setFresh(Freshness fresh) {
        Fresh = fresh;
    }
    public void setStem(int stem) {
        this.stem = stem;
    }

    public Flower(String name, int price, Freshness fresh, int stem) {
        this.name  = name;
        this.price = price;
        Fresh = fresh;
        this.stem = stem;
    }

    @Override
    public String toString() {
        return "Flower " + name + "\n" +
                "price: " + price + "\n" +
                "Fresh: " + Fresh + "\n" +
                "stem: " + stem + "\n";
    }

    public enum Freshness
    {
        AbsolutelyFresh,
        MediumFresh,
        NotFresh;
    }
}
