import Vegetables.Vegetables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Salad implements Serializable {
    private List<Vegetables> ingredients = new ArrayList<Vegetables>();
    private int totalCalories;

    public List<Vegetables> getIngredients() {
        return ingredients;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setIngredients(List<Vegetables> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Salad addIngredient(Vegetables vegetables) {
        ingredients.add(vegetables);
        totalCalories += vegetables.getCalories();
        return this;
    }

    @Override
    public String toString() {
        return "Salad with ingredients: " + ingredients + "\n" +
                "totalCalories: " + totalCalories + "\n";
    }
}
