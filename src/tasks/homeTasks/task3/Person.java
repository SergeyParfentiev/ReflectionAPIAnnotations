package tasks.homeTasks.task3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Person implements Externalizable {

    @Save
    private String firstName;
    private String secondName;

    @Save
    private int age;
    private String gender;

    @Save
    private boolean married;

    public Person() {

    }

    public Person(String firstName, String secondName, int age, String gender, boolean married) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.married = married;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMarried() {
        return married;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class) && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                    switch (field.getType().toString()) {
                        case "class java.lang.String":
                            String text = field.get(this).toString();
                            out.writeInt(text.getBytes().length);
                            out.write(text.getBytes());
                            break;
                        case "int":
                            out.writeInt((Integer) field.get(this));
                            break;
                        case "boolean":
                            out.writeBoolean((Boolean) field.get(this));
                            break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class) && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                    switch (field.getType().toString()) {
                        case "class java.lang.String":
                            int length = in.readInt();
                            byte[] buf = new byte[length];
                            in.read(buf);
                            field.set(this, new String(buf));
                            break;
                        case "int":
                            field.setInt(this, in.readInt());
                            break;
                        case "boolean":
                            field.setBoolean(this, in.readBoolean());
                            break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
