package menu.commands.tasks.editor.Dmitrii;
import menu.Command;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.List;
import java.io.IOException;

public class DmitriiEditor {
    private static DmitriiEditor instance;

    public static synchronized DmitriiEditor getInstance() {
        if (instance == null) {
            instance = new DmitriiEditor();
        }
        return instance;
    }

    public DmitriiEditor Newfile() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        String relativePath =  fileSeparator + "input.txt";
        File newfile = new File(relativePath);
        if(newfile.createNewFile()){
            System.out.println(relativePath + " файл создан в корневой директории проекта");
        }else System.out.println("Файл " + relativePath + " уже существует в директории проекта");
        return null;
    }

    private void showText() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());
        System.out.println(lines);
        /*for (String x:lines)
        {

        }*/
    }

    public Command execute() throws IOException {
        return DmitriiEditorCommand.getInstance().execute();
    }
}
