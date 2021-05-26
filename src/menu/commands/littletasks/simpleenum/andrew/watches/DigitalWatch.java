package menu.commands.littletasks.simpleenum.andrew.watches;

import menu.commands.littletasks.simpleenum.andrew.WatchTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatch implements WatchTime {
    @Override
    public void showTime() {
        System.out.println("Show digital watch: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
    }
}
