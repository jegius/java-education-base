package menu.commands.littletasks.simpleenum.andrew;

import menu.commands.littletasks.simpleenum.andrew.watches.ClassicWatch;
import menu.commands.littletasks.simpleenum.andrew.watches.DigitalWatch;

public class WatchFactory {

    public static WatchTime buildWatchByType(WatchType watchType) {
        switch (watchType) {
            case DIGITAL_WATCH:
                return new DigitalWatch();
            case CLASSIC_WATCH:
                return new ClassicWatch();
            default:
                System.out.println("Watch not construct");
                return null;
        }
    }
}
