package tasks.homeTasks.task3;

public class Brother {

    @Save
    public String name;

    @Save
    public String surname;

    public boolean higherEducation;

    @Save
    public int age;
    public String gender;

    @Save
    public boolean married;

    public Brother() {

    }

    public Brother(String name, String surname, boolean higherEducation, int age, String gender, boolean married) {
        this.name = name;
        this.surname = surname;
        this.higherEducation = higherEducation;
        this.age = age;
        this.gender = gender;
        this.married = married;
    }
}
