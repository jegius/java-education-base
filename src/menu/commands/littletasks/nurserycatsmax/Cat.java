package menu.commands.littletasks.nurserycatsmax;

public class Cat {
    private String name;
    private String age;
    private int weight;
    private String temperament;

    Cat(String name, String age, int weight, String temperament) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.temperament = temperament;
    }

    public String getName() { return name; }

    public void setName() { this.name = name; }

    public String getAge() { return age; }

    public void setAge() { this.age = age; }

    public int getWeight() { return weight; }

    public void setWeight() { this.weight = weight; }

    public String getTemperament() { return temperament; }

    public void setTemperament() { this.temperament = temperament; }

    @Override
    public String toString() {
        return "[" + this.name + ", " +
                this.age + " years old, " +
                this.weight + " kg, " +
                this.temperament + "]";
    }
}

