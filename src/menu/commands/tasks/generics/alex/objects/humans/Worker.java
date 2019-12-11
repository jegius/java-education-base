package menu.commands.tasks.generics.alex.objects.humans;

public class Worker extends Human {

    private String job;

    public Worker(String name, int age, String job){
        super(name,age);
        this.job = job;
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
                this.getAge() == worker.getAge() &&
                this.getJob() == worker.getJob();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.job;
    }
}
