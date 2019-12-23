package menu.commands.tasks.generics.alex.objects.humans;

import java.util.List;

public class Worker extends Human {

    private String job;

    public Worker(List <String> values) {
        super(values.get(1));
        this.job = values.get(0);
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        Worker worker = (Worker) obj;
        return this.getName() == worker.getName() &&
                this.getJob() == worker.getJob();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.job;
    }
}
