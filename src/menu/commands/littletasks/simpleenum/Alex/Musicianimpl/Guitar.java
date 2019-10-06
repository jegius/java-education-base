package menu.commands.littletasks.simpleenum.Alex.Musicianimpl;

import menu.commands.littletasks.simpleenum.Alex.Musician;
import menu.commands.littletasks.simpleenum.Alex.MusicianType;

public class Guitar implements Musician {
    private MusicianType musicianType;

    public Guitar() {
        musicianType = MusicianType.GUITAR;
    }

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I can play " + musicianType.getMusicianTypeName() + ". I have 6 strings.";
    }
}
