package menu.commands.littletasks.andrew.ninetyninebottles;

public enum Constant {
    BOTTLES_COUNT(99),
    RUS_BOTTLES_MODULO(10),
    DRINK_BOTTLE_COUNT(1),
    RUS_SUFFIX_LAST_FIVE_BOTTLES(5),
    LAST_BOTTLE(1),
    RUS_SUFFIX_LAST_TEN_BOTTLES(10),
    RUS_SUFFIX_LAST_TWENTY_BOTTLES(20);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
