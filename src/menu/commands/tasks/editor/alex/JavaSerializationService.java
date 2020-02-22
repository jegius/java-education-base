package menu.commands.tasks.editor.alex;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class JavaSerializationService implements Serializer {
    File filesOutput = new File("./out/files.data");

    @Override
    public void save(List<String> files) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filesOutput))) {
            objectOutputStream.writeObject(files);
        } catch (IOException e) {
            System.out.println("Can't do serialization (write)");
            e.printStackTrace();
        }
    }

    @Override
    public List<String> load() {
       if(!filesOutput.exists()){
           try {
               Files.createFile(filesOutput.toPath());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
        List<String> files = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filesOutput))) {
            files = (List<String>) objectInputStream.readObject();
        } catch (EOFException e){
            System.out.println("U use this program for the first time");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't do serialization (read)");
        }
            return files;
    }
}
