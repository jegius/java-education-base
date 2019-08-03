package menu.commands.tasks.objects.exercises.dns.employees;

public class Director extends Employee {

    private Employee[] subordinates;

    public Director(String firstName, String lastName, int age, String seniority, Employee[] subordinates) {
        super(firstName, lastName, age, seniority);
        this.subordinates = subordinates;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Борис тырит видеокарты со склада, играет дома в ARK, ездит в баню с бабами и выращивает универсальных продавцов через вайбер.");
        for (Employee employee : subordinates) {
            employee.doWork();
        }
    }
}
