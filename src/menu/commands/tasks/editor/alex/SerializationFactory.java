package menu.commands.tasks.editor.alex;

public class SerializationFactory {
    private static SerializationFactory instance;
    private Serializer serializer;
    public static synchronized SerializationFactory getInstance(){
        if(instance == null){
            instance = new SerializationFactory();
        }
        return instance;
    }

    public SerializationFactory selectSerializer(int choice){
        switch(choice){
            case 1: serializer = new JavaSerializationService();
        }
        return this;
    }

    public Serializer getSerializer(){
        return serializer;
    }
}
