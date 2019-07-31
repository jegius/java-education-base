package objects.pub.people;

abstract class Human {
    private String name;
    private int age;

    Human (String name, int age){
        this.name = name;
        this.age = age;
    }

    public Human() {

    }

    abstract void doWork();

    void introduceYourself (){
        System.out.println("Я " + this.name + ", " + " мне " + this.age + " лет!");
    }
}