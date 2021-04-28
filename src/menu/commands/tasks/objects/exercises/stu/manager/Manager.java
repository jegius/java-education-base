package menu.commands.tasks.objects.exercises.stu.manager;

public class Manager extends People {
    public int money;

    public Manager(String firsname, String secondname, int age, int money) {
        super(firsname, secondname, age);
        this.money = money;
    }

    @Override
    void doWork() {
        this.me();
        System.out.println("Менеджер ищет грузоперевозки"+" Зарабатывает "+this.money+" рубелй");
    }
    public int getmoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
