package menu.commands.littletasks.ninetyninebottles;

public class NinetyNineBottles  {

    public static void run() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int bottles = 99; bottles >= 0; --bottles) {
            stringBuilder
                    .append("Number: ")
                    .append(bottles)
                    .append("%n");
        }

        System.out.printf(stringBuilder.toString());
    }
}
