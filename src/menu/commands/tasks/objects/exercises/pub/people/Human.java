package menu.commands.tasks.objects.exercises.pub.people;

abstract class Human {
    private String name;
    private String seniority;
    private int age;

    Human (String name, String seniority, int age){
        this.name = name;
        this.seniority = seniority;
        this.age = age;
    }

    public Human() {
    }

    abstract void doWork();

    void introduceYourself (){
        System.out.println("Я " + this.name + " - " + this.seniority + ", мне " + this.age + " лет!");
    }
}