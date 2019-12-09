package menu.commands.tasks.collections.fillingoututil;

import menu.commands.tasks.collections.List;

public class MaxFillingOutUtil extends FillingOutUtil {

    private static final int MAX_VALUE_OF_LENGTH = 10000;

    @Override
    public List fillList(List providedList, int length) throws Exception {
        for (int index = 0; index < length; index++) {
            int randomNumber = (int) (Math.random() * MAX_VALUE_OF_LENGTH);
            providedList.add(randomNumber);
        }
        return providedList;
    }
}
