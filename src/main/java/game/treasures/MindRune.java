package game.treasures;

public class MindRune extends Drop {
    // Fields
    private int age;
    private String origin;

    // Constructors
    public MindRune() {
    }

    public MindRune(String name, int age, String origin) {
        super(name);
        this.age = age;
        this.origin = origin;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // Getters
    public int getAge() {
        return age;
    }

    public String getOrigin() {
        return origin;
    }

    // ToString
    @Override
    public String toString() {
        return "MindRune{" +
                "age=" + age +
                ", origin='" + origin + '\'' +
                '}';
    }
}
