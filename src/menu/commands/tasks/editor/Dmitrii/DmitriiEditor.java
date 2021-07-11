package menu.commands.tasks.editor.Dmitrii;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DmitriiEditor {
    private static DmitriiEditor instance;


    public static synchronized DmitriiEditor getInstance() {
        if (instance == null) {
            instance = new DmitriiEditor();
        }
        return instance;
    }

    public void getFilePath() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        Path path = Paths.get("./out/" + choice);
        showText(path.toString());
    }
//    public DmitriiEditor Newfile() {1
//
//
//        String fileSeparator = System.getProperty("file.separator");
//        String relativePath =  fileSeparator + "input.txt";
//        File newfile = new File(relativePath);
//        if(newfile.createNewFile()){
//            System.out.println(relativePath + " файл создан в корневой директории проекта");
//        }else System.out.println("Файл " + relativePath + " уже существует в директории проекта");
//        return null;
//    }

    public void showText(String filePath) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
