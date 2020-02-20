package menu.commands.tasks.generics.max;

public enum EnumForMonsters {

    MONSTERS_NAME ("monstersName"),
    GHOSTS_NAME("ghostsName"),
    ZOMBIES_DEGREE_DEATH ("zombiesDegreeDeath"),
    VAMPIRE_VULNERABILITY ("vampireVulnerability"),
    ANGEL_WINGS ("angelWings"),
    DEMON_HORNS ("demonHorns"),

    INITIAL_AMOUNT(0),
    START_POSITION_OF_INITIAL_ARRAY(0),
    START_POSITION_OF_NEW_ARRAY(0),
    ELEMENTS_OF_ARRAY (16),
    NEW_NUMBER_ELEMENTS_OF_ARRAY (16);

    private String fieldName;
    private int value;

    EnumForMonsters(String fieldName) {
        this.fieldName = fieldName;
    }

    EnumForMonsters(int value) {
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getValue() {
        return value;
    }
}
