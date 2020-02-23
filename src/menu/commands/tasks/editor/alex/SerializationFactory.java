package menu.commands.tasks.editor.alex;

import menu.commands.tasks.editor.alex.exceptions.SerializerException;

public class SerializationFactory {
    private static SerializationFactory instance;

    public static synchronized SerializationFactory getInstance() {
        if (instance == null) {
            instance = new SerializationFactory();
        }
        return instance;
    }

    public Serializer getSerializer(SerializationKind kind) throws SerializerException {
        switch (kind) {
            case JAVA:
                return new JavaSerializationService();
            default:
                throw new SerializerException();
        }
    }
}
