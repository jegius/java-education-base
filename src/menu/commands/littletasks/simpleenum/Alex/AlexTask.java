package menu.commands.littletasks.simpleenum.Alex;

import menu.commands.littletasks.simpleenum.Task;

import java.util.Objects;

public class AlexTask implements Task {
    @Override
    public void runTask() {
        Objects.requireNonNull(MusicianFactory
                .createMusicianByType(getRandomType()))
                .play();
    }

    private MusicianType getRandomType() {
        int upperBound = MusicianType.values().length;
        int randomIndex = (int) (Math.random() * upperBound);
        return MusicianType.values()[randomIndex];
    }
}
