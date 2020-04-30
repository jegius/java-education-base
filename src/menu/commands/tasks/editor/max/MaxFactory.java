package menu.commands.tasks.editor.max;

public class MaxFactory {
    public static MaxSerializableManager createSerializationManager(MaxSerializationType type) throws Exception {
        switch (type) {
            case XML:
                return new MaxSerializableManagerXML();
            case JAVA:
                return new MaxSerializableManagerJava();
            default:
                throw new Exception();
        }
    }
}
