package menu.commands.tasks.editor.andrew;

public enum AndrewEditorFields {
    FILE_NAME_DESCRIPTION("Text file"),
    FILE_NAME_EXTENSIONS("txt"),
    EMPTY_PATH("");

    private final String field;

    AndrewEditorFields(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
