package menu.commands.tasks.editor.max;

public enum MaxSerializationType {
    JAVA("Java"),
    XML("XML");

    private String name;

    MaxSerializationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
