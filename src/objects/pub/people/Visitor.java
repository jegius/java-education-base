package objects.pub.people;

public class Visitor extends Human {

    private String seniority;

    public Visitor(String name,
                   String seniority,
                   int age) {
        super(name, seniority, age);
        this.seniority = seniority;
    }

    @Override
    void doWork() {
        this.introduceYourself();

        System.out.println("Посетитель забирает стакан");
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
}
