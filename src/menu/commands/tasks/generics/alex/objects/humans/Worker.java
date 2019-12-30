package menu.commands.tasks.generics.alex.objects.humans;

import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class Worker extends Human {

    private String job;

    public Worker(Map<String, String> values) {
        super(values.get(NAME.getName()));
        this.job = values.get(JOB.getName());
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.getClass().getName().equals(object.getClass().getName())) {
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
