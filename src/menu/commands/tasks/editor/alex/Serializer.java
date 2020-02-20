package menu.commands.tasks.editor.alex;

import java.nio.file.Path;
import java.util.List;

public interface Serializer{
    void save(List<Path> files);
    List<Path> load();
}
