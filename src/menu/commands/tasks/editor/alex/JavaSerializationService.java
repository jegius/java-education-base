package menu.commands.tasks.editor.alex;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JavaSerializationService implements Serializer {
    File filesOutput = new File("/Users/alexperminov/IdeaProjects/java-education-base/out/files.data");

    @Override
    public void save(List<Path> files) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filesOutput))) {
            objectOutputStream.writeObject(files);
        } catch (IOException e) {
            System.out.println("Can't do serialization (write)");
            e.printStackTrace();
        }
    }

    @Override
    public List<Path> load() {
        List<Path> files = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filesOutput))) {
            files = (List<Path>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't do serialization (read)");
        }
        if (files != null) {
            return files;
        } else {
            return new ArrayList<>();
        }
    }
}
