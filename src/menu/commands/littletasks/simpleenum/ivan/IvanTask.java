package menu.commands.littletasks.simpleenum.ivan;

import menu.commands.littletasks.simpleenum.Task;

import java.util.Objects;

public class IvanTask implements Task {

    @Override
    public void runTask() {
        Objects.requireNonNull(TransportFactory
                .createTransportByType(getRandomType()))
                .drive();
    }

    private TransportType getRandomType() {
        int upperBound = TransportType.values().length;
        int randomTypeIndex = (int) (Math.random() * upperBound);

        return TransportType.values()[randomTypeIndex];
    }
}
