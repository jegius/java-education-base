package menu.commands.littletasks.andrew.nurseryforcats;

public enum CatsConstant {
    COUNT_CATS_GENERATE(3),
    CATS_AGE_MIN(1),
    CATS_AGE_MAX(18);

    private final int value;

    CatsConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
