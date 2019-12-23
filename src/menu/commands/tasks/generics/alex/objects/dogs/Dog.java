package menu.commands.tasks.generics.alex.objects.dogs;

import menu.commands.tasks.generics.alex.objects.Creature;

public class Dog extends Creature {

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
