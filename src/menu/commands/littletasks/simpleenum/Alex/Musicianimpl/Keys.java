package menu.commands.littletasks.simpleenum.Alex.Musicianimpl;

import menu.commands.littletasks.simpleenum.Alex.Musician;
import menu.commands.littletasks.simpleenum.Alex.MusicianType;

public class Keys implements Musician {
    private MusicianType musicianType;

    public Keys() {
        musicianType = MusicianType.KEYS;
    }

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I can play the " + musicianType.getMusicianTypeName();
    }
}
