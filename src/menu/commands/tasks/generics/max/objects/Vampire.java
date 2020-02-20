package menu.commands.tasks.generics.max.objects;

import java.util.List;

public class Vampire extends Monster {

    private String vampireVulnerability;

    public Vampire(List<String> values) {
        super(values.get(1));
        this.vampireVulnerability = values.get(0);
    }

    public String getVampireVulnerability() {
        return vampireVulnerability;
    }

    public void setVampireVulnerability(String vampireVulnerability) {
        this.vampireVulnerability = vampireVulnerability;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.vampireVulnerability;
    }
}
