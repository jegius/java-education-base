package menu.commands.tasks.generics.alex.objects.humans;

import java.util.List;
import java.util.Map;

public class Worker extends Human {

    private String job;

    public Worker(Map<String, String> values) {
        super(values.get("name"));
        this.job = values.get("job");
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
