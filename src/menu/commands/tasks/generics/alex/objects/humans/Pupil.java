package menu.commands.tasks.generics.alex.objects.humans;

import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class Pupil extends Human {

    private String subject;

    public Pupil(Map<String, String> values) {
        super(values.get(NAME.getName()));
        this.subject = values.get(SUBJECT.getName());
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.getClass().getName().equals(object.getClass().getName())) {
            return false;
        }
        Pupil pupil = (Pupil) object;
        String thisName = this.getName();
        String objectName = pupil.getName();
        String thisSubject = this.getSubject();
        String objectSubject = pupil.getSubject();
        return thisName == objectName &&
                thisSubject == objectSubject;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.subject;
    }
}
