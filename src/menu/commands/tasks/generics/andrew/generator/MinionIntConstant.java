package menu.commands.tasks.generics.andrew.generator;

public enum MinionIntConstant {
    MIN_AGE(18),
    MAX_AGE(50),
    MIN_POWER(15),
    MAX_POWER(150),
    MINION_HP(100),
    MINION_AMOUNT(4),
    FIRST_ROUND(1),
    HP_WHEN_MINION_DEAD(0),
    DEFEAT_ARMY_LENGTH(0);

    private final int value;

    MinionIntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
