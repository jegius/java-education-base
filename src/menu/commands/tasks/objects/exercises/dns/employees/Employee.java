package menu.commands.tasks.objects.exercises.dns.employees;

public class Employee extends Human {
    private String seniority;

    public Employee(String firstName, String lastName, int age, String seniority) {
        super(firstName, lastName, age);
        this.seniority = seniority;
    }

    @Override
    void doWork() {
        this.introduceYourself();
        if (!seniority.equals("Кладовщик")) {
            System.out.println("Занимается продажей, выкладыванием товара и выполняет работу за Бориса. Универсальный продавец!");
        } else {
            System.out.println("Сортирует товар на складе, жестко и принципиально не прикрывает Бориса перед региональным менеджером.");
        }
    }
}
