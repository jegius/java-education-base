package menu.commands.tasks.generics.max.objects;

public class Ghost {

    private String ghostsName;

    public Ghost(String ghostsName) {
        this.ghostsName = ghostsName;
    }

    public String getGhostsName() {
        return ghostsName;
    }

    public void setGhostsName(String ghostsName) {
        this.ghostsName = ghostsName;
    }

    @Override
    public String toString() {
        return ghostsName;
    }
}
