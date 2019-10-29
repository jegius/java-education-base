package menu.commands.littletasks.simpleenum.max.humanimpl;

import menu.commands.littletasks.simpleenum.max.HumanOrgans;
import menu.commands.littletasks.simpleenum.max.HumanOrgansType;

public class Stomach implements HumanOrgans {
    private HumanOrgansType humanOrgansType;

    public Stomach() {
        humanOrgansType = HumanOrgansType.STOMACH;
    }

    @Override
    public void works() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return humanOrgansType.getName() + " digests food";
    }
}
