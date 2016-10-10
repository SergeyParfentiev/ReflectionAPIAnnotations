package tasks.homeTasks.task3;

/*
Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
отмечены аннотацией @Save.
*/

public class SerializationWithAnnotation {
    public static void main(String[] args) throws Exception {
        Brother brother = new Brother("Vania", "Vovk", true, 25, "male", true);
        Sister sister = new Sister();
        Serializer serializer = new Serializer<>();

        serializer.toFile(brother);

        String fileName = brother.getClass().getSimpleName();

        serializer.fromFile(fileName, sister);

        System.out.println(sister.name);
        System.out.println(sister.surname);
        System.out.println(sister.age);
        System.out.println(sister.gender);
        System.out.println(sister.married);
    }
}
