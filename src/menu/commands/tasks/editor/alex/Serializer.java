package menu.commands.tasks.editor.alex;

import java.util.List;

public interface Serializer{
    void save(List<String> files);
    List<String> load();
}
