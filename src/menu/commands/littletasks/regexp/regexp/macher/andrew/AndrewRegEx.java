package menu.commands.littletasks.regexp.regexp.macher.andrew;

public enum AndrewRegEx {
    NUMBERS("[4][5-9][6-9]|[5-9][0-9][0-9]|[1][0-1][0-9][0-9]|1200"),
    WORDS("L+\\w+m"),
    SYMBOLS("-+[a-zA-Zа-яА-Я0-9]+[,|\\.]"),
    VALID_DATE("(01|0[1-9]|[1-2][0-9]|3[0-1])\\.(01|0[1-9]|1[0-2])\\.\\d{1,4}"),
    NO_VALID_DATE("(00|3[2-9]|[4-9][0-9]|\\d{3,})\\.(00|1[3-9]|[2-9][0-9]|\\d{3,})\\.\\d{1,}"),
    TAGS("<\\w+>.+?<\\\\\\w+>");

    private final String regEx;

    AndrewRegEx(String regEx) {
        this.regEx = regEx;
    }

    @Override
    public String toString() {
        return regEx;
    }
}
