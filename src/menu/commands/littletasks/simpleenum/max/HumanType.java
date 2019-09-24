package menu.commands.littletasks.simpleenum.max;

public enum HumanType {
    HEART("heart"),
    BRAIN("brain"),
    STOMACH("stomach"),
    LIVER("liver");

    private String name;

    HumanType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
