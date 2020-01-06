package menu.commands.tasks.generics.alex.objects;

import java.util.Map;

public class Worker extends Human {

    String job;

    public Worker(Map<String, String> values) {
        fillFields(this, values);
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object object) {
        String thisClassName = this.getClass().getName();
        String objectClassName = object.getClass().getName();
        if (!thisClassName.equals(objectClassName)) {
            return false;
        }
        Worker worker = (Worker) object;
        String thisName = this.getName();
        String objectName = worker.getName();
        String thisJob = this.getJob();
        String objectJob = worker.getJob();
        return thisName == objectName &&
                thisJob == objectJob;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.job;
    }
}
