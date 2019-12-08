package menu.commands.tasks.generics.alex.objects.dogs;

public class PetDog extends Dog {

    private String familyName;

    public PetDog(String nickName, String familyName) {
        super(nickName);
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        PetDog petDog = (PetDog) obj;
        return this.getNickName() == petDog.getNickName() &&
                this.getFamilyName() == petDog.getFamilyName();
    }

    @Override
    public String toString() {
        return super.toString() + " lives with " + this.familyName;
    }
}
