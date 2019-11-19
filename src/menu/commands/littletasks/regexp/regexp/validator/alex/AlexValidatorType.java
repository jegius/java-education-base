package menu.commands.littletasks.regexp.regexp.validator.alex;

public enum AlexValidatorType {
    EMAIL("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+"),
    PHONE("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"),
    CAR_NUMBER("[АаВвЕеКкМмНнОоРрСсТтУуХх]\\d{3}[АаВвЕеКкМмНнОоРрСсТтУуХх]{2}\\d{2,3}"),
    IP_ADDRESS("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    private String regExp;

    AlexValidatorType(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}
