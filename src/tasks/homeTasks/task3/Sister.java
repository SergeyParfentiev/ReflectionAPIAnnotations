package tasks.homeTasks.task3;

public class Sister {

    public String name;

    @Save
    public String surname;

    public boolean higherEducation;

    public int age;
    public String gender;

    @Save
    public boolean married;

    public Sister() {
    }

    public Sister(String name, String surname, boolean higherEducation, int age, String gender, boolean married) {
        this.name = name;
        this.surname = surname;
        this.higherEducation = higherEducation;
        this.age = age;
        this.gender = gender;
        this.married = married;
    }
}
