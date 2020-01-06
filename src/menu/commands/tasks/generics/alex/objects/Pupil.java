package menu.commands.tasks.generics.alex.objects;

import java.util.Map;

public class Pupil extends Human {

    String subject;

    public Pupil(Map<String, String> values) {
        fillFields(this, values);
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object object) {
        String thisClassName = this.getClass().getName();
        String objectClassName = object.getClass().getName();
        if (!thisClassName.equals(objectClassName)) {
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
