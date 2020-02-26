package menu.commands.tasks.editor.alex;

public enum SerializationKind {
    JAVA("java"),
    XML("XML");
    private String kind;

    SerializationKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
}
