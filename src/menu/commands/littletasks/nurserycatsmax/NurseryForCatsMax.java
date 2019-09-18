package menu.commands.littletasks.nurserycatsmax;

import menu.commands.littletasks.nurserycatsmax.families.FamilyCat;

public class NurseryForCatsMax {

    public static void run() {
        for (FamilyCat family : MaxFamilies.getFamilies()) {
            family.giveCatsToShelter();
        }

        CatShelterSingleton.getInstance().showAllCats();
    }
}