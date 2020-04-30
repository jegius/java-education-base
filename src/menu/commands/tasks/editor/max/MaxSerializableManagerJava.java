package menu.commands.tasks.editor.max;

import java.io.*;
import java.util.List;

public class MaxSerializableManagerJava implements MaxSerializableManager {

    private File fileJava = new File ("./out/listFiles.data");

    public MaxSerializableManagerJava() {
    }

    @Override
    public void save(List<String> paths) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileJava))) {
            objectOutputStream.writeObject(paths);
        } catch (IOException e) {
            System.out.println("Impossible to save");
            e.printStackTrace();
        }
    }

    @Override
    public List<String> load() {
        List<String> files = null;
        if (fileJava.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileJava))) {
                files = (List<String>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist");
        }
        return files;
    }
}
