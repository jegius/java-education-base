package menu.commands.tasks.objects.exercises.stu.manager;

public class Director extends Leader {
    private Leader[] leaders;

    public Director(String firsname, String secondname, int age, Leader[] leaders, int money) {
        super(firsname, secondname, age, leaders, money);
        this.leaders = leaders;
    }


    public void doWork() {
        this.me();
        System.out.println("Директор делает распределение бюджета на отделы"+" Зарабатывает "+this.money+" рубелй");

        for (Leader leader : leaders) {
            leader.doWork();
        }
    }
}
