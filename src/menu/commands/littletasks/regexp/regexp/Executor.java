package menu.commands.littletasks.regexp.regexp;

public enum Executor {
    IVAN("Ivan"),
    ANDREW("Andrew"),
    ALEX("Alex"),
    MAX("Max");

    private String name;

    Executor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
