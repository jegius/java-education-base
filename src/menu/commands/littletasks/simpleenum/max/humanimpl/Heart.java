package menu.commands.littletasks.simpleenum.max.humanimpl;

import menu.commands.littletasks.simpleenum.max.HumanOrgans;
import menu.commands.littletasks.simpleenum.max.HumanOrgansType;

public class Heart implements HumanOrgans {
    private HumanOrgansType humanOrgansType;

    public Heart() {
        humanOrgansType = HumanOrgansType.HEART;
    }

    @Override
    public void works() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return humanOrgansType.getName() + " pumps blood";
    }
}