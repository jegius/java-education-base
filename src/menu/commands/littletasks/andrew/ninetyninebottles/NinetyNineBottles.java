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
        NinetyNineBottles ninetyNineBottles = new NinetyNineBottlesBuilder().setBottles(99).build();
        StringBuilder stringBuilder = new StringBuilder();
        while (ninetyNineBottles.getBottlesCount() > 1) {
            stringBuilder
                    .append(ninetyNineBottles.getBottlesCount())
                    .append(bottlesRusEnding(ninetyNineBottles.getBottlesCount()));
            stringBuilder
                    .append(" пива на столе,\n")
                    .append("Взял одну, распили,\n")
                    .append("Теперь на столе осталось,\n");
            ninetyNineBottles.setBottlesCount(ninetyNineBottles.getBottlesCount() - 1);
            stringBuilder
                    .append(ninetyNineBottles.getBottlesCount())
                    .append(bottlesRusEnding(ninetyNineBottles.getBottlesCount()));
            stringBuilder.append(" пива\n\n");
        }
        stringBuilder.append("Только 1 бутылка пива\n" +
                "Осталась на столе, всего одна\n" +
                "Выпьем ее и останется 0 бутылок пива\n" +
                "Вечер окончен.");
        System.out.println(stringBuilder.toString());
    }

    private static String bottlesRusEnding(int bottlesCount) {
        if (bottlesCount >= 10 && bottlesCount < 20) {
            return " бутылок";
        }
        int bottlesMod = bottlesCount % 10;
        if (bottlesCount == 1 || bottlesMod == 1) {
            return " бутылка";
        }
        if (bottlesMod < 5 && bottlesMod > 1) {
            return " бутылки";
        } else {
            return " бутылок";
        }
    }
}
