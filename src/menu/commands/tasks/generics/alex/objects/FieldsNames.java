package menu.commands.tasks.generics.alex.objects;

public enum FieldsNames {
    NAME("name"),
    SUBJECT("subject"),
    JOB("job"),
    NICKNAME("nickName"),
    AREA("area"),
    FAMILY_NAME("familyName");

    private String fieldName;

    FieldsNames(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return fieldName;
    }
}
