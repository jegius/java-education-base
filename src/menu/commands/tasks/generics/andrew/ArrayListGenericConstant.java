package menu.commands.tasks.generics.andrew;

public enum ArrayListGenericConstant {

    INIT_SIZE(16),
    CUT_RATE(4);

    private final int value;

    ArrayListGenericConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
