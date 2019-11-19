package menu.commands.littletasks.regexp.regexp.macher.alex;

public enum AlexRegExp {
    NUMBERS("\\b4[5-9][6-9]\\b|\\b[5-9][0-9][0-9]\\b|1[0-1][0-9][0-9]|1200\\b"),
    WORDS("\\bL\\w+m\\b"),
    SENTENCE("(?:\\s|\\b)-\\s?[а-яА-Яa-zA-Z\"']+[,\\.]"),
    DATE("\\b(?:0[0-9]|1[0-9]|2[0-9]|3[0-1]).(?:0[0-9]|1[0-2]).\\d\\d\\d\\d\\b"),
    TAG("<\\w+>(.*)<\\\\\\w+>");
    private String regExp;

    AlexRegExp(String regexp) {
        this.regExp = regexp;
    }

    @Override
    public String toString() {
        return regExp;
    }
}
