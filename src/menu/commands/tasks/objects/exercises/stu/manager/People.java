package menu.commands.tasks.objects.exercises.stu.manager;

abstract class People {
    private String firsname;
    private String secondname;
    private int age;

    People(String firsname, String secondname, int age) {
        this.firsname = firsname;
        this.secondname = secondname;
        this.age = age;
    }

    abstract void doWork();

    void me() {
        System.out.println("Меня зовут " + this.firsname + " " + this.secondname + " мне " + this.age + " Лет.");
    }
}
