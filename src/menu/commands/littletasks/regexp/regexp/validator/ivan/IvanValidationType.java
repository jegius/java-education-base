package menu.commands.littletasks.regexp.regexp.validator.ivan;

public enum IvanValidationType {
    EMAIL("[\\w]+@[\\w]+\\.[\\w]{1,3}"),
    PHONE(""),
    CAR_NUMBER(""),
    IP_ADDRESS("");

    private String regExp;

    IvanValidationType(String regexp) {
        this.regExp = regexp;
    }

    public String getRegExp() {
        return regExp;
    }
}
