package p1;

public class Listing {
    private String name;
    private int age;
    
    public Listing() {
        name = " ";
        age = 0;
    }
    
    public Listing(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void input(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public Listing clone() {
        return new Listing(name, age);
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
