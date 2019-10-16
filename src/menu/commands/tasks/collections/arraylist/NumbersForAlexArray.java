package menu.commands.tasks.collections.arraylist;

public enum NumbersForAlexArray {
    INITIAL_ARRAY_SIZE(16),
    INITIAL_ELEMENT_OF_COPY(0),
    INITIAL_ELEMENT_OF_PASTE(0),
    ADDED_AMOUNT_FOR_ARRAY(16),
    FIRST_ELEMENT_OF_ARRAY(0),
    NOT_FOUND(-1);

    private int value;

    NumbersForAlexArray(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
