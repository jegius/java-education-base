package menu.commands.tasks.generics.objects.humans;

public class Pupil extends Human {

    private String subject;

    public Pupil(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

}
