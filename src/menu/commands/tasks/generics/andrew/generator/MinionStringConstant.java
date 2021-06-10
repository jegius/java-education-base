package menu.commands.tasks.generics.andrew.generator;

public enum MinionStringConstant {
    LIGHT_SIDE("light"),
    DARK_SIDE("dark"),

    SIDE("side"),
    NAME("name"),
    OBJECT_NAME("objectName"),
    AGE("age"),
    POWER("power"),
    HP("hp"),
    EMPTY_STRING("");

    private final String line;

    MinionStringConstant(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
