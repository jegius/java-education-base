package objects.dns.employees;

public class RegionalManager extends Employee {
    private Director director;

    public RegionalManager(String firstName, String lastName, int age, String seniority, Director director) {
        super(firstName, lastName, age, seniority);
        this.director = director;
    }

    public void doWork() {
        this.introduceYourself();
        System.out.println("Осуществляет внезапную проверку Бориса на рабочем месте. Не найдя его, интересуется о нём у кладовщика Дениса.");
        director.doWork();
    }

}
