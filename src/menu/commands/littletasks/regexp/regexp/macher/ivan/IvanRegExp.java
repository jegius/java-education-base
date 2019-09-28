package menu.commands.littletasks.regexp.regexp.macher.ivan;

public enum IvanRegExp{
    LOREM("Lo?rem"),
    NUMBERS("\\d{1,3}");

    private String regExp;

    IvanRegExp(String regexp) {
        this.regExp = regexp;
    }

    @Override
    public String toString() {
        return regExp;
    }
}
