package menu.commands.tasks.generics.alex.objects.humans;

import java.util.List;
import java.util.Map;

public class Pupil extends Human {

    private String subject;

    public Pupil(Map <String, String> values) {
        super(values.get("name"));
        this.subject = values.get("subject");
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
