import menu.ConsoleMenu;
import menu.MainMenuCommand;
import menu.commands.tasks.collections.arraylist.AlexArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        AlexArrayList ales = new AlexArrayList();
        ales.add(1222);
        ales.add(1234);
        ales.add(153);
        ales.quickSort();
        for (int i = 0; i < 3; i++) {
            System.out.println(ales.get(i));
        }
        ConsoleMenu menu = new ConsoleMenu(MainMenuCommand.getInstance());
        menu.run();
    }
}
