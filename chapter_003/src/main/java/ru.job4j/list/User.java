package ru.job4j.list;

import java.util.List;

public class User implements Comparable<User> {

    private Integer id, age;
    private String name, city;
    User() {

    }
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    public void add(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public int getAge() {
        return age;
    }
    public int getId() {

        return id;
    }
    public String getName() {

        return name;
    }
    public String getCity() {

        return city;
    }


}
