package tasks.homeTasks.task2;

import java.io.*;

@SaveTo(path = "Test.txt")
public class TextContainer {

    public String text = "Annotation task two!!!";

    @Saver
    public void save(String fileName) throws IOException {

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(text);
            fileWriter.flush();

            System.out.println("File: " + fileName + "\nText: " + text);
        }
    }
}
