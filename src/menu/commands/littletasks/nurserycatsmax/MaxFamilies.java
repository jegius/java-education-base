package menu.commands.littletasks.nurserycatsmax;

import menu.commands.littletasks.nurserycatsmax.families.Depps;
import menu.commands.littletasks.nurserycatsmax.families.FamilyCat;
import menu.commands.littletasks.nurserycatsmax.families.Jacksons;

class MaxFamilies {
    private static FamilyCat[] families = {
            new Jacksons(),
            new Depps(),
    };

    static FamilyCat[] getFamilies() {
        return families;
    }
}