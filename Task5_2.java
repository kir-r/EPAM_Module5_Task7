/*Выполнить задания из Internal Java Lab OOP in Java, сохраняя объекты приложения в одном или нескольких файлах с
применением механизма сериализации. Объекты могут содержать поля, помеченные как static, а также transient.
Для изменения информации и извлечения информации в файле создать специальный класс коннектор с необходимыми для
выполнения этих задач методами.*/

import Candies.Candy;
import Candies.Mars;
import Candies.Snickers;
import Candies.Twix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Task5_2 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Snickers snickers = new Snickers(100, 1000, "Nestle Inc");
        Mars mars = new Mars(90, 800, "Tesla Inc");
        Twix twix = new Twix(80, 700, "Mars Inc");

        Gift gift = new Gift();
        gift.addCandy(snickers).addCandy(mars).addCandy(twix);
        System.out.println("Total weight: " + gift.getWeight());
        gift.getCandiesList().sort(Comparator.comparing(Candy::getManufacturer));
        System.out.println("\nSorted gift by manufacturer");
        for (Candy candy : gift.getCandiesList()) {
            System.out.println(candy);
        }
        /*try {
            System.out.println("\nSearching by sugar value.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter lowest value of sugar:");
            int lowest = Integer.parseInt(reader.readLine());
            System.out.println("Enter highest value of sugar:");
            int highest = Integer.parseInt(reader.readLine());

            int count = 0;
            for (Candy candy : gift.getCandiesList()) {
                if (candy.getSugar() >= lowest && candy.getSugar() <= highest) {
                    System.out.println("Here's your candy in this sugar value range: " + candy.getName());
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
            connector.writeObject(gift, reader.readLine());  //сериализация;
            System.out.println("Enter the path to serialize a second object: ");
            connector.writeObject(mars, reader.readLine());
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
