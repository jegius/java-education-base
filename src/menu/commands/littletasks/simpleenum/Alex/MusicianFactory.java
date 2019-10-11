package menu.commands.littletasks.simpleenum.Alex;

import menu.commands.littletasks.simpleenum.Alex.Musicianimpl.Bass;
import menu.commands.littletasks.simpleenum.Alex.Musicianimpl.Drums;
import menu.commands.littletasks.simpleenum.Alex.Musicianimpl.Guitar;
import menu.commands.littletasks.simpleenum.Alex.Musicianimpl.Keys;

public class MusicianFactory {
    static Musician createMusicianByType(MusicianType musicianType) {
        switch(musicianType) {
            case BASS:
                return new Bass();
            case DRUMS:
                return new Drums();
            case GUITAR:
                return new Guitar();
            case KEYS:
                return new Keys();
            default:
                System.out.println("There's no such musician");
                return null;
        }
    }
}
