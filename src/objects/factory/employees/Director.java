package objects.factory.employees;

public class Director extends Employee {

    private Master[] masters;

    public Director(String firstName,
             String lastName,
             String seniority,
             Master[] masters,
             int age) {
        super(firstName, lastName, seniority, age);
        this.masters = masters;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Директор поднял план и сообщил мастерам!");

        for (Master master : masters) {
            master.doWork();
        }
    }
}
