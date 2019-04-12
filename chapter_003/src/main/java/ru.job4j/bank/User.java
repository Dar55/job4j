package ru.job4j.bank;

public class User implements Comparable<User>{

    private String name, passport;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }

    public void eqauls() {}
@Override
    public int hashCode() {return 0;}
}
