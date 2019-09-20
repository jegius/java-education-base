package menu.commands.littletasks.simpleenum.Alex.Musicianimpl;

import menu.commands.littletasks.simpleenum.Alex.Musician;
import menu.commands.littletasks.simpleenum.Alex.MusicianType;

public class Drums implements Musician {
    private MusicianType musicianType;

    public Drums() {
        musicianType = MusicianType.DRUMS;
    }

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I can play the " + musicianType.getMusicianTypeName() + ". I have 2 sticks.";
    }
}
