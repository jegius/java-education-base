package menu.commands.littletasks.regexp.regexp.macher;

public class TextStore {
    private static TextStore instance;

    public static TextStore getInstance() {
        if (instance == null) {
            instance = new TextStore();
        }

        return instance;
    }

    private String text;
    private TextStore() {
        this.text = "Lorem Ipsum - это текст-\"рыба\", часто используемый в \n" +
                "печати и вэб-дизайне. Lorem Ipsum является стандартной\n" +
                " \"рыбой\" для текстов на латинице с начала XVI века.\n" +
                " В то время некий безымянный печатник создал большую \n" +
                "коллекцию размеров и форм шрифтов, используя Lorem Ipsum\n" +
                "для распечатки образцов. Lorem Ipsum не только успешно пережил\n" +
                "без заметных изменений пять веков, Lrem но и перешагнул в электронный\n" +
                "дизайн. Его популяризации в новое время послужили публикация листов\n" +
                "Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время,\n" +
                "программы электронной вёрстки типа Aldus PageMaker,\n" +
                "в шаблонах которых используется Lorem Ipsum. Lrem";
    }


    public String getText() {
        return text;
    }
}
