import menu.ConsoleMenu;
import menu.MainMenuCommand;



public class App {

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu(MainMenuCommand.getInstance());
        menu.run();
        
    }
}
