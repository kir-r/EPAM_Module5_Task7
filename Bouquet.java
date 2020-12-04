import Flowers.Flower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bouquet implements Serializable {
    private int price;
    private List<Flower> flowers = new ArrayList<Flower>();

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bouquet addFlower(Flower flower) {
        flowers.add(flower);
        price += flower.getPrice();
        return this;
    }

    @Override
    public String toString() {
        return "Bouquet! " + "Price: " + price + "\n" +
                "flowers=" + flowers;
    }
}
