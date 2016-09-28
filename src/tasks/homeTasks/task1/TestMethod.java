package tasks.homeTasks.task1;

class TestMethod {

    @TaskAnnotation(a=2, b=5)
    public void test(int a, int b) {
        System.out.println("a: " + a + " b: " + b);
    }
}
