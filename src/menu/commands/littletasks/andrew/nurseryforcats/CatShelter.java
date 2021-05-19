package menu.commands.littletasks.andrew.nurseryforcats;

import java.util.List;

public class CatShelter {


    public static void printCats(List<Cat> cats, Class<?> cClass) {
        System.out.println("Family: " + cClass.getSimpleName());
        cats.forEach(System.out::println);
        System.out.println("==================================");
    }
}
