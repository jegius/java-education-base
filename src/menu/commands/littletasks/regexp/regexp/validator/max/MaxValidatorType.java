package menu.commands.littletasks.regexp.regexp.validator.max;

public enum MaxValidatorType {
    EMAIL("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+"),
    PHONE("^(\\+7|7|8|\\d{2}|[+]\\d{2})?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$"),
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

