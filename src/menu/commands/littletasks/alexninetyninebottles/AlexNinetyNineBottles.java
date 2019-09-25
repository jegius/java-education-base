package menu.commands.littletasks.alexninetyninebottles;

public class AlexNinetyNineBottles {
    private static double checkValue(int value) {
        double initialNumber = value;
        if (value > 15) {
            double compareNumber = initialNumber / 10;
            compareNumber = Math.floor(compareNumber);
            compareNumber *= 10;
            return initialNumber - compareNumber;
        }
        return initialNumber;
    }

    private static int chooseTheWord(double check) {
        if (check < 5 && check > 1) {
            return 1;
        } else if (check == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void run() {
        String[] bottleString = {"бутылок", "бутылки", "бутылка"};
        StringBuilder stringBuilder = new StringBuilder();

        for (int bottles = 99; bottles > 0; --bottles) {

            if (bottles == 1) {

                stringBuilder
                        .append("Только 1 бутылка пива\n")
                        .append("Осталась на столе, всего одна\n")
                        .append("Выпьем ее и останется 0 бутылок пиива\n")
                        .append("Вечер окончен. ")
                        .append("%n");
            } else {

                stringBuilder
                        .append(bottles)
                        .append(" ")
                        .append(bottleString[chooseTheWord(checkValue(bottles))])
                        .append(" пива на столе,\n")
                        .append("Взял одну, распили,\n")
                        .append("теперь на столе осталось ")
                        .append(bottles - 1)
                        .append("%n");
            }
        }
        System.out.printf(stringBuilder.toString());
    }
}
