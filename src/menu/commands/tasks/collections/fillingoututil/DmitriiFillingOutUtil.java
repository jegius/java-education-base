package menu.commands.tasks.collections.fillingoututil;
import menu.commands.tasks.collections.List;

public class DmitriiFillingOutUtil extends FillingOutUtil {
    private static int MAX_VALUE_OF_NUMBER = 10000;
    @Override
    public List fillList(List providedList, int length) throws Exception {
        try {
            for (int index = 0; index < length; index++) {
                providedList.add(randomaizer());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providedList;

        }
    private long randomaizer(){
        return (long) (Math.random() * MAX_VALUE_OF_NUMBER);
    }
}
