package menu.commands.tasks.collections.arraylist;

public enum DmitriiEnum {
    INITIAL_AMOUNT(0),
    START_POSITION_OF_INITIAL_ARRAY(0),
    START_POSITION_OF_NEW_ARRAY(0),
    INVALID_INDEX(-1);
    private int value;

    DmitriiEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
