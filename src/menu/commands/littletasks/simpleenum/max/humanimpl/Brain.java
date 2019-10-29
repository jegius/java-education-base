package menu.commands.littletasks.simpleenum.max.humanimpl;

import menu.commands.littletasks.simpleenum.max.HumanOrgans;
import menu.commands.littletasks.simpleenum.max.HumanOrgansType;

public class Brain implements HumanOrgans {
    private HumanOrgansType humanOrgansType;

    public Brain() {
        humanOrgansType = HumanOrgansType.BRAIN;
    }

    @Override
    public void works() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return humanOrgansType.getName() + " exerts centralized control over a body's other organs";
    }
}
