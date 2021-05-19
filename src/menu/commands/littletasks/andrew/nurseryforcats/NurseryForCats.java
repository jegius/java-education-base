package menu.commands.littletasks.andrew.nurseryforcats;

import menu.commands.littletasks.andrew.nurseryforcats.families.FamilyCat;
import menu.commands.littletasks.andrew.nurseryforcats.families.Ivanov;
import menu.commands.littletasks.andrew.nurseryforcats.families.Petrov;

import java.util.Arrays;

public class NurseryForCats {

    private static final FamilyCat[] families = {
            new Ivanov(),
            new Petrov()
    };

    public static void run() {
        Arrays.stream(families).forEach(familyCat -> familyCat.sendToTheShelter(familyCat.getClass()));
    }
}
