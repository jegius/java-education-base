package menu.commands.tasks.editor.max;

import java.util.List;

public interface MaxSerializableManager {
    void save(List<String> paths);
    List<String> load();
}
