import Candies.Candy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gift implements Serializable {
    private int weight;
    private List<Candy> candiesList = new ArrayList<>();

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Candy> getCandiesList() {
        return candiesList;
    }

    public void setCandiesList(List<Candy> candiesList) {
        this.candiesList = candiesList;
    }

    public Gift addCandy (Candy candy) {
        candiesList.add(candy);
        weight += candy.getWeight();
        return this;
    }

    @Override
    public String toString() {
        return "Gift weight: " + weight + "\n" +
                "candiesList: " + candiesList + "\n";
    }
}
