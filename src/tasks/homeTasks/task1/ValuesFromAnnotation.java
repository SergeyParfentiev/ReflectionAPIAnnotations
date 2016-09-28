package tasks.homeTasks.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Создать аннотацию, которая принимает параметры для метода. Написать код, который вызовет метод,
//помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
public class ValuesFromAnnotation {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        final Class<?> aClass = TestMethod.class;

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(TaskAnnotation.class)) {
                TaskAnnotation an = method.getAnnotation(TaskAnnotation.class);
//                System.out.println(an.a() + " " + an.b());
//                System.out.println(method.getName());
                method.invoke(new TestMethod(), an.a(), an.b());
//                TestMethod task1 = new TestMethod();
//                task1.test(an.a(), an.b());
            }
        }

    }
}
