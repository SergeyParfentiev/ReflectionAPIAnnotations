package tasks.homeTasks.task3;

import java.io.*;
import java.lang.reflect.Field;
import java.util.StringTokenizer;

public class Serializer<T> {

    T object;

    public Serializer() {

    }

    public void toFile(T object) throws Exception{
        this.object = object;

        File fileName = new File(object.getClass().getSimpleName() + ".dat");
        Field[] fields = object.getClass().getDeclaredFields();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    fileWriter.write(field.getName() + " " + field.get(object).toString() + " ");
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void fromFile(String fileName, T object) throws Exception {
        String textFromFile;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".dat"));

        StringBuilder stringBuilder = new StringBuilder();

        while ((textFromFile = bufferedReader.readLine()) != null) {
            stringBuilder.append(textFromFile);
        }

        StringTokenizer st = new StringTokenizer(stringBuilder.toString(), " ");
        while (st.hasMoreTokens()) {
            Field field = object.getClass().getField(st.nextToken());
            if(field.isAnnotationPresent(Save.class)) {
                switch (field.getType().toString()) {
                    case "class java.lang.String":
                        field.set(object, st.nextToken());
                        break;
                    case "int":
                        field.setInt(object, Integer.parseInt(st.nextToken()));
                        break;
                    case "boolean":
                        field.setBoolean(object, Boolean.parseBoolean(st.nextToken()));
                        break;
                }
            } else {
                st.nextElement();
            }
        }
    }
}
