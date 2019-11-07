package menu.commands.tasks.collections.iterator;

public enum NumbersForAlexIterator {
    NOT_FOUND(-1),
    INITIAL_SIZE_OF_LIST(0);

    private int value;

    NumbersForAlexIterator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
