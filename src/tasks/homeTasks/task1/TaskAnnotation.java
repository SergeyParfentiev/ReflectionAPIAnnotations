package tasks.homeTasks.task1;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TaskAnnotation {

    int a();

    int b();
}
