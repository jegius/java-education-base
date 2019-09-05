package menu.commands.littletasks.alexnurseryforcats;

import menu.commands.littletasks.alexnurseryforcats.families.Family;
import menu.commands.littletasks.alexnurseryforcats.families.Jacksons;
import menu.commands.littletasks.alexnurseryforcats.families.Nicksons;

public class AlexNurseryForCats {
    private static Family[] families = {
            new Nicksons(),
            new Jacksons()
    };


    public static void run() {
        for (Family family : families) {
            family.giveCatsToShelter();
//            family.deleteCatsFromCats();
        }
        CatShelter.getInstance().showAllCats();
    }


}
