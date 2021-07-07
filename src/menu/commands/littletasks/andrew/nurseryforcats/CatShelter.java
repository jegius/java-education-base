package menu.commands.littletasks.andrew.nurseryforcats;

import java.util.List;

public class CatShelter {


    public static void printCats(List<Cat> cats, Class<?> getClassObject) {

        System.out.println("Family: " + getClassObject.getSimpleName());

        cats.forEach(System.out::println);

        System.out.println("==================================");
    }
}
