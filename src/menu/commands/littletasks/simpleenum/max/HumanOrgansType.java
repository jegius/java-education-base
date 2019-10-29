package menu.commands.littletasks.simpleenum.max;

public enum HumanOrgansType {
    HEART("Heart"),
    BRAIN("Brain"),
    LIVER("Liver"),
    STOMACH("Stomach");

    private String name;

    HumanOrgansType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
