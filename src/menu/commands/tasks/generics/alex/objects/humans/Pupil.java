package menu.commands.tasks.generics.alex.objects.humans;

import java.util.List;

public class Pupil extends Human {

    private String subject;

    public Pupil(List<String> values) {
        super(values.get(1));
        this.subject = values.get(0);
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

                this.getSubject() == pupil.getSubject();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.subject;
    }
}
