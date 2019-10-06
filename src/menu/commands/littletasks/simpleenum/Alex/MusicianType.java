package menu.commands.littletasks.simpleenum.Alex;

public enum MusicianType {
    GUITAR("guitar"),
    DRUMS("drums"),
    BASS("bass"),
    KEYS("keys");

    private String name;

    MusicianType(String name) {
        this.name = name;
    }

    public String getMusicianTypeName() {
        return name;
    }
}
