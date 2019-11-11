package menu.commands.tasks.collections.fillingoututil;

import menu.commands.tasks.collections.List;

public class AlexFillingOutUtil extends FillingOutUtil {

    private static final int MAX_VALUE_OF_NUMBER = 10000;

    @Override
    public List fillList(List providedList, int length) {

        try {
            for (int index = 0; index < length; index++) {
                providedList.add(randomNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providedList;
    }

    private long randomNumber() {
        return (long) (Math.random() * MAX_VALUE_OF_NUMBER);
    }
}
