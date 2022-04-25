/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: MindRune - child class from Drop, one of a kind dropped by Goblin
 */
package game.goodies;

public class MindRune extends Drop {
    // Fields
    private int age;
    private String origin;

    // Constructors
    public MindRune() {
    }

    public MindRune(String name, Scarcity scarcity, int age, String origin) {
        super(name, scarcity);
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
                "name='" + super.getName() + '\'' +
                ", scarcity='" + super.getScarcity() + '\'' +
                ", age=" + age +
                ", origin='" + origin + '\'' +
                '}';
    }
}
