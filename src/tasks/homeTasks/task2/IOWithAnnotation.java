package tasks.homeTasks.task2;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст
 * 2) метод, который выполнит сохранение.
 * Написать класс Saver,
 * который сохранит поле класса TextContainer в указанный файл
 */
public class IOWithAnnotation {

    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, IllegalAccessException {
        final Class<?> aClass = TextContainer.class;
        if (aClass.isAnnotationPresent(SaveTo.class)) {
            Method[] methods = aClass.getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    SaveTo saveTo = aClass.getAnnotation(SaveTo.class);

                    method.invoke(new TextContainer(), saveTo.path());
                }
            }
        } else {
            System.out.println("Empty Class Annotation");
        }
    }
}
