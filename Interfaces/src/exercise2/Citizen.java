package exercise2;

import java.util.regex.Pattern;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String birthDate;
    private String id;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }



    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
