package com.example.demo;
public class Player   {
    private String name;
    private int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;


    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void deductMoney(int amount) {
        money -= amount;
    }

    public boolean hasEnoughMoney(int amount) {
        return money >= amount;
    }
}
