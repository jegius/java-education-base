package menu.commands.littletasks.nurserycatsmax;

import menu.commands.littletasks.nurserycatsmax.families.FamilyCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NurseryForCatsMax {
    private static List<FamilyCat> families = new ArrayList<>(Arrays.asList(
            MaxFamilies.getFamilies()
    ));

    public static void run() {
        for (FamilyCat family : families) {
            family.giveCatsToShelter();
        }

        CatShelterSingleton.getInstance().showAllCats();
    }
}
