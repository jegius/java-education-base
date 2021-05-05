package menu.commands.tasks.generics.andrew.generator;

public enum MinionStringEnum {
    LIGHT_SIDE("Light"),
    DARK_SIDE("Dark");

    private final String line;

    MinionStringEnum(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
