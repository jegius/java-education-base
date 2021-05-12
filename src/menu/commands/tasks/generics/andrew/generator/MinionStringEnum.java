package menu.commands.tasks.generics.andrew.generator;

public enum MinionStringEnum {
    LIGHT_SIDE("light"),
    DARK_SIDE("dark"),
    SIDE("side"),
    NAME("name"),
    AGE("age"),
    POWER("power"),
    HP("hp");

    private final String line;

    MinionStringEnum(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
