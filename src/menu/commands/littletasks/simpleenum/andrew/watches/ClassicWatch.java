package menu.commands.littletasks.simpleenum.andrew.watches;

import menu.commands.littletasks.simpleenum.andrew.WatchTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClassicWatch implements WatchTime {

    @Override
    public void showTime() {
        System.out.println("Show classic watch: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
