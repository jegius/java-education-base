package menu.commands.tasks.collections.linkedlist;

public enum DmitriiEnum {
    INITIAL_AMOUNT(0),
    INITIAL_SIZE(0),
    INVALID_INDEX(-1);

    private int value;

    DmitriiEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
