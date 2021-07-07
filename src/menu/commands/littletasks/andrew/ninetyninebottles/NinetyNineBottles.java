package menu.commands.littletasks.andrew.ninetyninebottles;

public class NinetyNineBottles {

    private int bottlesCount;

    public void setBottlesCount(int bottlesCount) {
        this.bottlesCount = bottlesCount;
    }

    public int getBottlesCount() {
        return bottlesCount;
    }

    public static void run() {
        NinetyNineBottles ninetyNineBottles = new NinetyNineBottlesBuilder()
                .setBottles(Constant.BOTTLES_COUNT.getValue()).build();
        StringBuilder stringBuilder = new StringBuilder();

        while (ninetyNineBottles.getBottlesCount() > 1) {
            stringBuilder
                    .append(ninetyNineBottles.getBottlesCount())
                    .append(bottlesRusSuffix(ninetyNineBottles.getBottlesCount()))
                    .append(" пива на столе,\n")
                    .append("Взял одну, распили,\n")
                    .append("Теперь на столе осталось,\n");

            ninetyNineBottles.setBottlesCount(
                    ninetyNineBottles.getBottlesCount() - Constant.DRINK_BOTTLE_COUNT.getValue()
            );

            stringBuilder
                    .append(ninetyNineBottles.getBottlesCount())
                    .append(bottlesRusSuffix(ninetyNineBottles.getBottlesCount()))
                    .append(" пива\n\n");
        }
        stringBuilder.append("Только 1 бутылка пива\n" +
                "Осталась на столе, всего одна\n" +
                "Выпьем ее и останется 0 бутылок пива\n" +
                "Вечер окончен.");

        System.out.println(stringBuilder.toString());
    }

    private static String bottlesRusSuffix(int bottlesCount) {
        int bottlesMod = bottlesCount % Constant.RUS_BOTTLES_MODULO.getValue();

        if (bottlesCount >= Constant.RUS_SUFFIX_LAST_TEN_BOTTLES.getValue() &&
                bottlesCount < Constant.RUS_SUFFIX_LAST_TWENTY_BOTTLES.getValue()) {
            return " бутылок";
        }
        if (bottlesCount == Constant.LAST_BOTTLE.getValue() ||
                bottlesMod == Constant.LAST_BOTTLE.getValue()) {
            return " бутылка";
        }
        if (bottlesMod < Constant.RUS_SUFFIX_LAST_FIVE_BOTTLES.getValue() &&
                bottlesMod > Constant.LAST_BOTTLE.getValue()) {
            return " бутылки";
        } else {
            return " бутылок";
        }
    }
}
