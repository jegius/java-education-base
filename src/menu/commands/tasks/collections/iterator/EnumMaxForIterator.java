package menu.commands.tasks.collections.iterator;

public enum EnumMaxForIterator {

    INITIAL_AMOUNT(0),
    NOT_FOUND(-1);

    private int value;

    EnumMaxForIterator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
