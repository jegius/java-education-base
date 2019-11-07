package menu.commands.tasks.collections.linkedlist;

public enum EnumMaxList {
    INITIAL_AMOUNT(0),
    INVALID_INDEX (-1);

    private int value;

    EnumMaxList(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
