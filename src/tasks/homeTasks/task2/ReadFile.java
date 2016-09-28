package tasks.homeTasks.task2;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String text;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Test.txt"));

        while ((text = bufferedReader.readLine()) != null) {
            System.out.println(text);
        }
    }
}
