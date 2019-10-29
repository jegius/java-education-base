package menu.commands.littletasks.simpleenum.max.humanimpl;

import menu.commands.littletasks.simpleenum.max.HumanOrgans;
import menu.commands.littletasks.simpleenum.max.HumanOrgansType;

public class Liver implements HumanOrgans {
    private HumanOrgansType humanOrgansType;

    public Liver() {
        humanOrgansType = HumanOrgansType.LIVER;
    }

    @Override
    public void works() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return humanOrgansType.getName() + " produces bile";
    }
}
