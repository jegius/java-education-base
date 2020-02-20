package menu.commands.tasks.generics.max.objects;

public class Monster {
    private String monstersName;

    public Monster(String monstersName) {
        this.monstersName = monstersName;
    }

    public String getMonstersName() {
        return monstersName;
    }

    public void setMonstersName(String monstersName) {
        this.monstersName = monstersName;
    }

    @Override
    public String toString() {
        return monstersName;
    }
}
