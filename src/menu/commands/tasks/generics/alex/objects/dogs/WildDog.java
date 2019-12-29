package menu.commands.tasks.generics.alex.objects.dogs;

import java.util.Map;

public class WildDog extends Dog {

    private String area;

    public WildDog(Map<String, String> values) {
        super(values.get("nickName"));
        this.area = values.get("area");
    }

    public String getArea() {
        return area;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        WildDog wildDog = (WildDog) obj;
        return this.getNickName() == wildDog.getNickName() &&
                this.getArea() == wildDog.getArea();
    }

    @Override
    public String toString() {
        return super.toString() + " lives in the " + this.area;
    }
}
