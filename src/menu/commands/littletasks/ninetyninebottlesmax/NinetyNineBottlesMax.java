package menu.commands.littletasks.ninetyninebottlesmax;

public class NinetyNineBottlesMax {

    public static void run() {

        StringBuilder stringBuilder = new StringBuilder();
        String[] bottleCase = {" бутылок", " бутылки", " бутылка"};
        for (int bottles = 99; bottles >= 1; --bottles) {

            if (bottles != 1) {
                stringBuilder
                        .append(bottles)
                        .append(bottleCase[checkBottleNumber(bottles)]).append(" на столе,\n")
                        .append("Взял одну, распили,\n")
                        .append("Теперь осталось на столе\n")
                        .append(--bottles)
                        .append(bottleCase[checkBottleNumber(bottles)]).append(" пива\n")
                        .append("----------------------------\n");
                ++bottles;
            } else {
                stringBuilder
                        .append("Только 1 бутылка пива,\n")
                        .append("Осталась на столе, всего одна,\n")
                        .append("Выпьем ее и останется 0 бутылок пива\n")
                        .append("Вечер окончен.\n")
                        .append("...\n");
            }
        }
        System.out.printf(stringBuilder.toString());
    }

    private static int checkBottleNumber(int value) {
        if (value > 10 && value < 20) {
            return 0;
        }
        switch (value % 10) {
            case 1:
                return 2;
            case 2:
            case 3:
            case 4:
                return 1;
            default:
                return 0;
        }
    }
}
