package menu.commands.littletasks.ninetyninebottlesmax;

import java.util.Arrays;

public class NinetyNineBottlesMax {
    private static void checkLastNumberString() {
        int [] numbers = new int [99];
        for (int index = 1; index < 99; index++) {
            numbers[index] = index;
        }
        Arrays.toString(numbers);

    }

    public static void run() {

        StringBuilder stringBuilder = new StringBuilder();
        String[] bottleCase = {"бутылок", "бутылки", "бутылка"};
        for (int bottles = 99; bottles >= 1; --bottles) {

            if (bottles != 1) {
                stringBuilder
                        .append(bottles)
                        .append("бутылок на столе,\n")
                        .append("Взял одну, распили,\n")
                        .append("Теперь осталось на столе\n")
                        .append(--bottles)
                        .append(" бутылок пива\n")
                        .append("----------------------------\n");
                ++bottles;
            }

            else {
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
}
