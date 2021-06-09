package menu.commands.tasks.editor.Dmitrii;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.List;
import java.io.IOException;

public class DmitriiEditor {

    private void showText() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());
        System.out.println(lines);
        /*for (String x:lines)
        {

        }*/
    }
}
