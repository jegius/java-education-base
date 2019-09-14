package menu.commands.littletasks.alexnurseryforcats;

import menu.commands.littletasks.alexnurseryforcats.families.Family;
import menu.commands.littletasks.alexnurseryforcats.families.FamilyImp;

public class AlexNurseryForCats {
    private static Family[] families = new Family[10];


    public static void run() {
        AlexNurseryForCats.createFamilies();
        for (Family family : families) {
            family.giveCatsToShelter();
        }
        CatShelter.getInstance().showAllCats();
    }

    private static void createFamilies() {
        for (int index = 0; index < families.length; index++) {
            families[index] = new FamilyImp();
        }
    }
}
