package menu.commands.littletasks.simpleenum.andrew;

import menu.commands.littletasks.simpleenum.Task;

import java.util.Objects;
import java.util.Random;

public class AndrewTask implements Task {

    @Override
    public void runTask() {
        WatchType getWatchType = randomWatchType();

        Objects.requireNonNull(WatchFactory.buildWatchByType(getWatchType)).showTime();
    }

    public WatchType randomWatchType(){
        Random random = new Random();
        int typeId = random.nextInt(WatchType.values().length);
        return WatchType.values()[typeId];
    }
}
