package menu.commands.tasks.collections.iterator;

public enum EnumDmitrii {
    INITIAL_SIZE_OF_LIST(0),
    NOT_FOUND(-1);

    private int value;

    EnumDmitrii(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
