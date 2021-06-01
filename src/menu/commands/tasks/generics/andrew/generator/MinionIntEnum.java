package menu.commands.tasks.generics.andrew.generator;

public enum MinionIntEnum {
    MIN_AGE(18),
    MAX_AGE(50),
    MIN_POWER(15),
    MAX_POWER(150),
    MINION_HP(100),
    MINION_AMOUNT(4);

    private final int value;

    MinionIntEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
