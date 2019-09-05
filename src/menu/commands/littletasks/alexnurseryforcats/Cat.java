package menu.commands.littletasks.alexnurseryforcats;

public class Cat {
    private int age;
    private String color;
    private String name;

    public Cat(int age,
               String color,
               String name) {
        this.age = age;
        this.color = color;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setAge(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{"
                + name + " " + age + " " + color +
                "}";
    }
}
