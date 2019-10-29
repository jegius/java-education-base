package menu.commands.littletasks.simpleenum.max;

import menu.commands.littletasks.simpleenum.Task;

import java.util.Objects;

public class MaxTask implements Task {

    @Override
    public void runTask() {
        try {
            Objects.requireNonNull(HumanOrgansFactory
                    .createHumanOrgansByType(getRandomType()))
                    .works();
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private HumanOrgansType getRandomType() {
        int upperBound = HumanOrgansType.values().length;
        int randomTypeIndex = (int) (Math.random() * upperBound);
        return HumanOrgansType.values()[randomTypeIndex];
    }
}