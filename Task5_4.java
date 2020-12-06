/*Выполнить задания из Internal Java Lab OOP in Java, сохраняя объекты приложения в одном или нескольких файлах с
применением механизма сериализации. Объекты могут содержать поля, помеченные как static, а также transient.
Для изменения информации и извлечения информации в файле создать специальный класс коннектор с необходимыми для
выполнения этих задач методами.*/

import Vegetables.Cucumber;
import Vegetables.Onion;
import Vegetables.Tomato;
import Vegetables.Vegetables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Task5_4 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Salad salad = new Salad();
        Cucumber cucumber = new Cucumber(10, 100);
        Tomato tomato  = new Tomato(15, 110);
        Onion onion = new Onion(20, 70);

        salad.addIngredient(cucumber).addIngredient(tomato).addIngredient(onion);
        System.out.println("Total calories: " + salad.getTotalCalories());

        salad.getIngredients().sort(Comparator.comparing(Vegetables::getWeight)); //сортировка по весу овоща;
        System.out.println("\nVegetables sorted by weight");
        for (Vegetables veg : salad.getIngredients()) {
            System.out.println(veg);
        }
        /*try {
            System.out.println("\nSearching by calorie range.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter lowest value of calories:");
            int lowest = Integer.parseInt(reader.readLine());
            System.out.println("Enter highest value of calories:");
            int highest = Integer.parseInt(reader.readLine());

            int count = 0;
            for (Vegetables veg : salad.getIngredients()) {
                if (veg.getCalories() >= lowest && veg.getCalories() <= highest) {
                    System.out.println("Here's your vegetable in this calorie range: " + veg.getName());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry, our salad doesn't contain it");
            }
        } catch (Exception e) {
            System.out.println("Something gone wrong");
        }*/

        Connector connector = new Connector();
        try {
            System.out.println("Enter the path to serialize an object: ");
            connector.writeObject(salad, reader.readLine());  //сериализация;
            System.out.println("Enter the path to serialize a second object: ");
            connector.writeObject(cucumber, reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Enter the path where is object to deserialize: ");
            connector.readObject(reader.readLine());  //десериализация;
            System.out.println(connector.deserialObject.getClass().getSimpleName() + ": " + connector.deserialObject);
            System.out.println("Enter the path where is second object to deserialize: ");
            connector.readObject(reader.readLine());
            System.out.println(connector.deserialObject.getClass().getSimpleName() + ": " + connector.deserialObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cleanUp();
    }
    public static void cleanUp() throws IOException {
        reader.close();
    }
}
