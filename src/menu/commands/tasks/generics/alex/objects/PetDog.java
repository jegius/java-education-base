package menu.commands.tasks.generics.alex.objects;

import java.util.Map;

public class PetDog extends Dog {

    String familyName;

    public PetDog(Map<String, String> values) {
        fillFields(this, values);
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public boolean equals(Object object) {
        String thisClassName = this.getClass().getName();
        String objectClassName = object.getClass().getName();
        if (!thisClassName.equals(objectClassName)) {
            return false;
        }
        PetDog petDog = (PetDog) object;
        String thisNickName = this.getNickName();
        String objectNickName = petDog.getNickName();
        String thisFamilyName = this.getFamilyName();
        String objectFamilyName = petDog.getFamilyName();

        return thisNickName == objectNickName &&
                thisFamilyName == objectFamilyName;
    }

    @Override
    public String toString() {
        return super.toString() + " lives with " + this.familyName;
    }
}
