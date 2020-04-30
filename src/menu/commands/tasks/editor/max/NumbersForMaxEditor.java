package menu.commands.tasks.editor.max;

public enum NumbersForMaxEditor {

    NUMBER_OF_LINE(1),
    INITIAL_AMOUNT_OF_LINES(0),
    LAST_INDEX_OF_SIZE(1),
    INITIAL_AMOUNT_OF_PATHS(0),
    FIRST_PATH_OF_CHOICE(1);

    private int value;

    NumbersForMaxEditor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
