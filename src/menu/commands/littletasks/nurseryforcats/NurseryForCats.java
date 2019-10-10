package menu.commands.littletasks.nurseryforcats;

import menu.commands.littletasks.nurseryforcats.families.Family;
import menu.commands.littletasks.nurseryforcats.families.Nicksons;

public class NurseryForCats {
    private static Family[] families = {
            new Nicksons()
    };

    public static void run() {
        for (Family family : families) {
            family.giveCatsToShelter();
        }

        CatShelter catShelter = new CatShelter();
        catShelter.showAllCats();
    }
}
