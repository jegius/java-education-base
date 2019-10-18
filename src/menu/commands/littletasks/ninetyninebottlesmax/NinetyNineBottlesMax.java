package menu.commands.littletasks.ninetyninebottlesmax;

public class NinetyNineBottlesMax {

    private static final int QUANTITY = 122;
    private static final int NUMBER_STRING_LENGTH = 2;
    private static final int FROM_NUMBER_CHECK = 10;
    private static final int TO_NUMBER_CHECK = 20;
    private static final int OPERAND_FOR_CHECK_REMAINDER = 10;
    private static final int SINGLE_BOTTLE = 1;

    private static int checkQuantity(int quantityBottles) {
        String stringBottle = Integer.toString(quantityBottles);
        int number = quantityBottles;

        if (stringBottle.length() > NUMBER_STRING_LENGTH) {
            String twoLastNumbers = stringBottle.substring(stringBottle.length() - NUMBER_STRING_LENGTH);
            number = Integer.parseInt(twoLastNumbers);
        }
        return checkBottleNumber(number);
    }

    private static int checkBottleNumber(int value) {
        if (value > FROM_NUMBER_CHECK && value < TO_NUMBER_CHECK) {
            return 0;
        }
        switch (value % OPERAND_FOR_CHECK_REMAINDER) {
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

    public static void run() {

        StringBuilder stringBuilder = new StringBuilder();
        String[] bottleCase = {" бутылок", " бутылки", " бутылка"};
        for (int bottles = QUANTITY; bottles >= 1; --bottles) {
            int messageIndex = checkQuantity(bottles);

            if (bottles != SINGLE_BOTTLE) {
                stringBuilder
                        .append(bottles)
                        .append(bottleCase[messageIndex])
                        .append(" на столе,\n")
                        .append("Взял одну, распили,\n")
                        .append("Теперь осталось на столе\n")
                        .append(--bottles)
                        .append(bottleCase[checkQuantity(bottles - SINGLE_BOTTLE)])
                        .append(" пива\n")
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
}
