package org.knit.lab3;

public abstract class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int x;
    private int y;
    private boolean isAlife;

    protected abstract void increaseHealth(int value);
    protected abstract void decreaseHealth(int value);

    protected Player(String name, int x, int y){
        this.name = name;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.x = x;
        this.y = y;
        this.isAlife = true;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean getAlife(){
        return isAlife;
    }
    public void setAlife(boolean isAlife){
        this.isAlife = isAlife;
    }
}