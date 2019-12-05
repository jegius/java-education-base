package menu.commands.littletasks.regexp.regexp.macher.max;

public enum MaxRegExp {
    NUMBERS("(\\b4[5-9][6-9]\\b|\\b4[6-9][0-9]\\b|\\b[5-9][0-9][0-9]\\b|\\b1[0-1][0-9][0-9]\\b|1200\\b)"),
    WORDS("\\b[lL]\\w+[mM]\\b"),
    SENTENCE("([-].+?[.,]+)"),
    DATE("\\b(0[1-9]|1[0-9]|2[0-9]|3[0-1])[.](0[1-9]|1[0-2])[.](19[0-9][0-9]|20[0-1][0-9]|2020)"),
    INVALID_DATE("\\b(3[2-9]|\\b4[0-9])[.](1[3-9]|\\b2[0-9])[.](202[1-9]|\\b)/g"),
    TAGS("");

    private String regExp;

    MaxRegExp(String regExp) {
        this.regExp = regExp;
    }

    @Override
    public String toString() {
        return regExp;
    }
}
