package menu.commands.tasks.generics.alex.objects.dogs;

public class Dog {

    private String nickName;

    public Dog(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return this.nickName;
    }
}
