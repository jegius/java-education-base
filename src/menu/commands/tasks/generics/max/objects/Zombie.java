package menu.commands.tasks.generics.max.objects;

import java.util.List;

public class Zombie extends Monster {

    private String zombiesDegreeDeath;

    public Zombie(List<String> values) {
        super(values.get(1));
        this.zombiesDegreeDeath = values.get(0);
    }

    public String getZombiesDegreeDeath() {
        return zombiesDegreeDeath;
    }

    public void setZombiesDegreeDeath(String zombiesDegreeDeath) {
        this.zombiesDegreeDeath = zombiesDegreeDeath;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.zombiesDegreeDeath;
    }
}
