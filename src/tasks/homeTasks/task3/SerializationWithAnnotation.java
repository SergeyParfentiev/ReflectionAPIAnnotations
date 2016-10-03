package tasks.homeTasks.task3;

/*
Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
отмечены аннотацией @Save.
*/

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;

public class SerializationWithAnnotation {
    public static void main(String[] args) throws Exception {
        String fileName = "Person.dat";
        writeToFile(fileName);
        readFromFile(fileName);
    }

    private static void writeToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(new Person("Ann", "Vovk", 30, "female", true));
        }
    }

    private static void readFromFile(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            Person person = (Person) ois.readObject();
            for(Field field : person.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(Save.class)) {
                    System.out.println(field.getName() + ": " + field.get(person));
                }
            }

//            for (PropertyDescriptor pd : Introspector.getBeanInfo(Person.class).getPropertyDescriptors()) {
//                if (pd.getReadMethod() != null && !"class".equals(pd.getName()))
//                    System.out.println(pd.getName() + ": " + pd.getReadMethod().invoke(person));
//            }
        }
    }
}
