package menu.commands.littletasks.simpleenum.Alex.Musicianimpl;

import menu.commands.littletasks.simpleenum.Alex.Musician;
import menu.commands.littletasks.simpleenum.Alex.MusicianType;

public class Bass implements Musician {
    private MusicianType musicianType;

    public Bass() {
        musicianType = MusicianType.BASS;
    }

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I can play the " + musicianType.getMusicianTypeName() + ". I have 4 strings.";
    }
}
