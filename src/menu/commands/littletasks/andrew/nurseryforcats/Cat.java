package menu.commands.littletasks.andrew.nurseryforcats;

public class Cat {
    private final String name;
    private final int age;
    private final CatBreed breed;

    public Cat(String name, int age, CatBreed breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed=" + breed +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CatBreed getBreed() {
        return breed;
    }
}
