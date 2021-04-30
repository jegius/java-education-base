package menu.commands.tasks.generics.andrew;

public enum ArrayListGenericEnum {

    INIT_SIZE(16),
    CUT_RATE(4);

    private int value;
    private String field;

    ArrayListGenericEnum(int value) {
        this.value = value;
    }

    ArrayListGenericEnum(String field) {
        this.field = field;
    }

    public int getValue() {
        return value;
    }

    public String getField() {
        return field;
    }
}
