package menu.commands.tasks.generics.andrew.generator;

public enum MinionEnum {
    LIGHT_SIDE("Light"),
    DARK_SIDE("Dark"),
    MIN_AGE(18),
    MAX_AGE(50),
    MIN_POWER(15),
    MAX_POWER(150),
    MINION_HP(100);
    private int value;
    private String line = "";

    MinionEnum(int value) {
        this.value = value;
    }

    MinionEnum(String line) {
        this.line = line;
    }


    public int getValue() {
        return value;
    }

    public String getLine() {
        return line;
    }
}
