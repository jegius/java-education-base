package menu.commands.littletasks.andrew.ninetyninebottles;

public enum NinetyNineBottlesConstant {
    BOTTLES_COUNT(99);

    private final int value;

    NinetyNineBottlesConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
