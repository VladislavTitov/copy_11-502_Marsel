package ru.itis.model;

import java.util.List;

public class User {
    private Long id;
    private int age;
    private String name;
    private List<Auto> autos;

    public User() {
    }

    public User(Long id, int age, String name, List<Auto> autos) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.autos = autos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}
