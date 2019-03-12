package ru.job4j.list;

public class User {
    private Integer id;
    private String name, city;


    public void add (Integer id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId (){
        return id;
    }
    public String getName (){
        return name;
    }
    public String getCity (){
        return city;
    }
}
