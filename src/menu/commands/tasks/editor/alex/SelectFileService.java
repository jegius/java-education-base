package menu.commands.tasks.editor.alex;

import java.nio.file.Path;

public class SelectFileService {
    private static SelectFileService instance;

    private SelectFileService() {
    }

    private Path filePath;

    public static synchronized SelectFileService getInstance() {
        if (instance == null) {
            instance = new SelectFileService();
        }
        return instance;
    }

    public AlexEditor getNewFile() {
        filePath = AlexEditorPaths.getInstance().newFile();
        return new AlexEditor(filePath);
    }

    public AlexEditor getSelectedFile() {
        filePath = AlexEditorPaths.getInstance().selectFile();
        return new AlexEditor(filePath);
    }
}
