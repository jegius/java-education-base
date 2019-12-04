package menu.commands.tasks.generics.objects.humans;

public class Worker extends Human {

    private String job;

    public Worker(String name, int age, String job){
       super(name,age);
       this.job = job;
    }

    public String getJob() {
        return job;
    }
}
