package org.knit.lab3;

public class Guard extends Warrior {
    int defence;

    public Guard(String name, int x, int y, int attackPower, int defence) {
        super(name, x, y, attackPower);
        this.defence = defence;
    }

    @Override
    protected void decreaseHealth(int value){
        int hp = getHealth();
        hp = hp - value + defence;
        if (hp <= 0){
            setAlife(false);
            setHealth(0);
        }
        else {
            setHealth(hp);
        }
    }
}
