package objects.factory.employees;

public class Employee extends Human {

    private String seniority;

    public Employee(String firstName,
             String lastName,
             String seniority,
             int age) {
        super(firstName, lastName, age);
        this.seniority = seniority;
    }

    @Override
    void doWork() {
        this.introduceYourself();

        System.out.println("Работник вытачивает детали");
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
}
