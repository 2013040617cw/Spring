package com.cuiwei.domain;

public class Account {
    private Integer id;
    private String name;
    private Double meney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMeney() {
        return meney;
    }

    public void setMeney(Double meney) {
        this.meney = meney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meney=" + meney +
                '}';
    }
}
