package menu.commands.tasks.objects.exercises.pub.people;

abstract class Human {
    String name;
    int age;

    Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    abstract void doWork();

    void introduceYourself (){
        System.out.println("Я " + this.name + ", мне " + this.age + " лет!");
    }
}
