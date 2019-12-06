package menu.commands.littletasks.regexp.regexp.validator.max;

public enum MaxValidatorType {
    EMAIL("[]"),
    PHONE(""),
    CAR_NUMBER(""),
    IP_ADDRESS("");

    private String regExp;

    MaxValidatorType(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}
