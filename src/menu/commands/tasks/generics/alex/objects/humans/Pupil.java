package menu.commands.tasks.generics.alex.objects.humans;

public class Pupil extends Human {

    private String subject;

    public Pupil(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        Pupil pupil = (Pupil) obj;
        return this.getName() == pupil.getName() &&
                this.getAge() == pupil.getAge() &&
                this.getSubject() == pupil.getSubject();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.subject;
    }
}
