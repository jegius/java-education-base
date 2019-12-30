package menu.commands.tasks.generics.alex.objects.dogs;

import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class PetDog extends Dog {

    private String familyName;

    public PetDog(Map<String, String> values) {
        super(values.get(NICKNAME.getName()));
        this.familyName = values.get(FAMILY_NAME.getName());
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.getClass().getName().equals(object.getClass().getName())) {
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
