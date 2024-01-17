package menu.commands.tasks.objects.exercises.stu.manager;

public class Leader extends Manager {
    private Manager[] subordinates;

    public Leader(String firsname, String secondname, int age, Manager[] subordinates, int money) {
        super(firsname, secondname, age, money);
        this.subordinates = subordinates;
    }

    public void doWork(){
        this.me();
        System.out.println("Распределяет бюджет на перевозки"+" Зарабатывает "+this.money+" рубелй");

        for (Manager manager: subordinates){
            manager.doWork();
        }
    }
}
