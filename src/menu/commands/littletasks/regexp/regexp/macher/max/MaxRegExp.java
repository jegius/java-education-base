package menu.commands.littletasks.regexp.regexp.macher.max;

public enum MaxRegExp {
    NUMBERS("(\\b4[5-9][6-9]\\b|\\b4[6-9][0-9]\\b|\\b[5-9][0-9][0-9]\\b|\\b1[0-1][0-9][0-9]\\b|1200\\b)"),
    WORDS(""),

    private String regExp;

    MaxRegExp(String regExp) {
        this.regExp = regExp;
    }

    @Override
    public String toString() {
        return regExp;
    }
}
