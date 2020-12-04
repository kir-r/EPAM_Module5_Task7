/*Выполнить задания из Internal Java Lab OOP in Java, сохраняя объекты приложения в одном или нескольких файлах с
применением механизма сериализации. Объекты могут содержать поля, помеченные как static, а также transient.
Для изменения информации и извлечения информации в файле создать специальный класс коннектор с необходимыми для
выполнения этих задач методами.*/

import Flowers.Chrysanthemum;
import Flowers.Flower;
import Flowers.Gypsophila;
import Flowers.Iris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Task5 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Chrysanthemum firstChrys = new Chrysanthemum(100, Flower.Freshness.AbsolutelyFresh, 500);
        Chrysanthemum secondChrys = new Chrysanthemum(70, Flower.Freshness.MediumFresh, 450);
        Chrysanthemum thirdChrys = new Chrysanthemum(90, Flower.Freshness.AbsolutelyFresh, 350);
        Gypsophila gypsophila = new Gypsophila(50, Flower.Freshness.AbsolutelyFresh, 300);
        Iris iris = new Iris(70, Flower.Freshness.AbsolutelyFresh, 350);
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(firstChrys).addFlower(secondChrys).addFlower(thirdChrys).addFlower(gypsophila).addFlower(iris);
        System.out.println("Total price: " + bouquet.getPrice());

        bouquet.getFlowers().sort(Comparator.comparing(Flower::getFresh)); //сортировка по свежести;
        System.out.println("Sorted by freshness: ");
        for (Flower flower : bouquet.getFlowers()) {
            System.out.println(flower);
        }
        /*try {
            System.out.println("\nSearching by stem length.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter shortest value of stem:");
            int shortest = Integer.parseInt(reader.readLine());
            System.out.println("Enter longest value of stem:");
            int longest = Integer.parseInt(reader.readLine());

            int count = 0;
            for (Flower flower : bouquet.getFlowers()) {
                if (flower.getStem() >= shortest && flower.getStem() <= longest) {
                    System.out.println("Here's your flower in this stem length range: " + flower.getName());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry, we don't have it");
            }
        } catch (Exception e) {
            System.out.println("Something gone wrong");
        }*/

        Connector connector = new Connector();
        try {
            System.out.println("Enter the path to serialize an object: ");
            connector.writeObject(bouquet, reader.readLine());  //сериализация;
            System.out.println("Enter the path to serialize a second object: ");
            connector.writeObject(gypsophila, reader.readLine());
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
    }
}
