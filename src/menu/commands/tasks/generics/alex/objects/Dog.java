package menu.commands.tasks.generics.alex.objects;

public class Dog extends Creature {

    String nickName;

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return this.nickName;
    }
}
