package menu.commands.littletasks.simpleenum.max;

import menu.commands.littletasks.simpleenum.max.humanimpl.Brain;
import menu.commands.littletasks.simpleenum.max.humanimpl.Heart;
import menu.commands.littletasks.simpleenum.max.humanimpl.Liver;
import menu.commands.littletasks.simpleenum.max.humanimpl.Stomach;

class HumanOrgansFactory {

    static HumanOrgans createHumanOrgansByType(HumanOrgansType humanOrgansType) {
        switch (humanOrgansType) {
            case HEART:
                return new Heart();
            case BRAIN:
                return new Brain();
            case LIVER:
                return new Liver();
            case STOMACH:
                return new Stomach();
            default:
                System.out.println("Invalid organ of the body!");
                return null;
        }
    }
}

