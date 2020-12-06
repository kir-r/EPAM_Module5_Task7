/*Выполнить задания из Internal Java Lab OOP in Java, сохраняя объекты приложения в одном или нескольких файлах с
применением механизма сериализации. Объекты могут содержать поля, помеченные как static, а также transient.
Для изменения информации и извлечения информации в файле создать специальный класс коннектор с необходимыми для
выполнения этих задач методами.*/


import ElectricalAppliance.ElectricalAppliance;
import ElectricalAppliance.Fridge;
import ElectricalAppliance.Iron;
import ElectricalAppliance.Shaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Task5_3 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Shaver shaver = new Shaver(true, 1000, "Sharp LTD");
        Iron iron = new Iron(false, 2000,"Ariston LTD");
        Fridge fridge = new Fridge(true, 3000, "Daewoo Inc");

        ArrayList<ElectricalAppliance> list = new ArrayList<ElectricalAppliance>();
        list.add(shaver);
        list.add(iron);
        list.add(fridge);

        int totalPowerConsumption = 0;
        for (ElectricalAppliance ea : list) {
            if (ea.isPluggedIn()) { //если включен в розетку;
                totalPowerConsumption += ea.getPowerСonsumption();
            }
        }
        System.out.println("Total power consumption is " + totalPowerConsumption + " watt.");

        list.sort(Comparator.comparing(ElectricalAppliance :: getPowerСonsumption));
        System.out.println("\nElectrical appliances sorted by power consumption, from lowest to highest");
        for (ElectricalAppliance ea : list) {
            System.out.println(ea);
        }
        /*try {
            System.out.println("\nSearching by power consumption.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter lowest value of power consumption:");
            int lowest = Integer.parseInt(reader.readLine());
            System.out.println("Enter highest value of power consumption:");
            int highest = Integer.parseInt(reader.readLine());

            int count = 0;
            for (ElectricalAppliance ea : list) {
                if (ea.getPowerСonsumption() >= lowest && ea.getPowerСonsumption() <= highest) {
                    System.out.println("Here's your electrical appliance in this power consumption range: " + ea.getName());
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
            connector.writeObject(shaver, reader.readLine());  //сериализация;
            System.out.println("Enter the path to serialize a second object: ");
            connector.writeObject(fridge, reader.readLine());
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
