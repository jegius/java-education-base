package menu.commands.tasks.editor.alex;

public enum SerializationKinds {
    JAVA("java");
    private String kind;

    SerializationKinds(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
}
