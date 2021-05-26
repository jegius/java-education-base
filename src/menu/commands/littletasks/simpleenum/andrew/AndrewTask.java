package menu.commands.littletasks.simpleenum.andrew;

import menu.commands.littletasks.simpleenum.Task;
import menu.commands.littletasks.simpleenum.andrew.WatchFactory;
import menu.commands.littletasks.simpleenum.andrew.WatchType;

import java.util.Objects;

public class AndrewTask implements Task {

    @Override
    public void runTask() {
        Objects.requireNonNull(WatchFactory.buildWatchByType(WatchType.DIGITAL_WATCH)).showTime();
    }
}
