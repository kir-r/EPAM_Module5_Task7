import java.io.*;
import java.nio.file.Path;

public class Connector {
    Object deserialObject;
    public void writeObject(Object object) throws FileNotFoundException {
        String fileName = object.getClass().getSimpleName();
        System.out.println("Serialization of object " + fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\acer\\Desktop\\" + fileName + ".out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            System.out.println("Serialization finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readObject(String path) throws FileNotFoundException {
        //String fileName = object.getClass().getSimpleName();
        //Object deserialObject;
        //System.out.println("Deserialization of object " + fileName);

        System.out.println("Deserialization of object by path " + path);
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserialObject = objectInputStream.readObject();
            System.out.println("Deserialization finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
