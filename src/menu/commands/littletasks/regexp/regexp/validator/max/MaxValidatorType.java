package menu.commands.littletasks.regexp.regexp.validator.max;

public enum MaxValidatorType {
    EMAIL("^(.)+@(.)+\\..+$"),
    PHONE("^((8|\\+7|\\+44)[\\-]?)?(\\(?\\d{3}\\)?[\\-]?)?[\\d\\-]{7,10}$"),
    CAR_NUMBER("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}|\\d{2,3}"),
    IP_ADDRESS("([0-9]{1,3}[\\.]){3}[0-9]{1,3}");

    private String regExp;

    MaxValidatorType(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}

