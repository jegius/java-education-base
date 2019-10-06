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
        this.text = "Lorem Ipsum - это <span> текст-\"рыба\", часто используемый в \n" +
                "печати и вэб-дизайне. Lorem <span> Это Html tag span <\\span> Ipsum является стандартной\n" +
                " \"рыбой\" для текстов на латинице с начала XVI века.\n" +
                " В то время некий 16.10.1991 безымянный 9.77.0000 печатник создал большую \n" +
                "коллекцию размеров и форм шрифтов, используя Lorem Ipsum\n" +
                "<p>Это html element p<\\p>, используя Lorem Ipsum\n" +
                "для распечатки обр457азцов. Lorem Ipsum не только успешно пережил\n" +
                "без заметных изменений пять веков, Lrem но и перешагнул в электронный\n" +
                "дизайн. Его <\\p> популяриз777ации в <div>Это HTML тег Did<\\div> новое время послужили публ12.06.2011икация листов\n" +
                "Letraset с образцами Lor1200em <\\span> Ipsum в 60-х годах и, в более недавнее время,\n" +
                "программы электронной вёрстки типа Aldus PageMaker,\n" +
                "в шаблонах <\\span> которых использу 99.99.9999 ется Lorem Ipsum.<\\p> Lrem";
    }

    public String getText() {
        return text;
    }
}
