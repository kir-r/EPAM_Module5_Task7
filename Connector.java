import java.io.*;

public class Connector {
    Object deserialObject;

    public void writeObject(Object object, String path) throws FileNotFoundException {
        String fileName = object.getClass().getSimpleName();
        System.out.println("Serialization of object " + fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName + ".out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            System.out.println("Serialization finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object readObject(String path) throws FileNotFoundException {
        System.out.println("Deserialization of object by path " + path);
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserialObject = objectInputStream.readObject();
            System.out.println("Deserialization finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deserialObject;
    }
}
