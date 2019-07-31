package objects.pub.people;

abstract class Employee extends Human {
    private int experience;
    private int salary;


    public Employee(String name, int age) {
        super(name, age);
        this.experience = experience;
        this.salary = salary;
    }

    public Employee(int experience, int salary) {
        super();
    }

    abstract void doWork();

    @Override
    void introduceYourself (){
        System.out.println("Я работаю " + this.experience + " лет и получаю " + this.salary);
    }
}