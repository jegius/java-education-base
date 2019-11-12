package menu.commands.tasks.collections.linkedlist;

public enum NumbersForAlexLinkedList {
    INITIAL_SIZE(0),
    NOT_FOUND(-1),
    INITIAL_ID(0);

    private int value;

    NumbersForAlexLinkedList(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
