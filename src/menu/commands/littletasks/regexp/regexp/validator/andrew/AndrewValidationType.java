package menu.commands.littletasks.regexp.regexp.validator.andrew;

public enum AndrewValidationType {

    EMAIL("[\\w]+@[\\w]+\\.[a-zA-Z]+"),
    PHONE("^(\\+7|8)+\\d{10}"),
    //TODO Ошибка пробелов
    CAR_NUMBER("[А-Я]( |)+\\d{3}( |)[А-Я]{2}( |)\\d{2,3}"),
    IP("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

    private final String regExp;

    AndrewValidationType(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}
