package org.knit.lab3;

public class Warrior extends Player implements Attacker {
    private int attackPower;

    public Warrior(String name, int x, int y, int attackPower){
        super(name, x, y);
        this.attackPower = attackPower;
    }

    @Override
    protected void increaseHealth(int value) {
        int hp = getHealth();
        hp += value;
        int maxHp = getMaxHealth();
        if (hp > maxHp){
            setHealth(maxHp);
        }
        else{
            setHealth(hp);
        }
    }

    @Override
    protected void decreaseHealth(int value){
        int hp = getHealth();
        hp -= value;
        if (hp <= 0){
            setAlife(false);
            setHealth(0);
        }
        else {
            setHealth(hp);
        }
    }

    @Override
    public void attack(Player player) {
        int lastHealth = player.getHealth();
        player.decreaseHealth(attackPower);
        if (player.getAlife()){
            System.out.printf("%s атакован воином " + getName() + "! Здоровье: %d --> %d%n",
                    player.getName(), lastHealth, player.getHealth());
        } else {
            System.out.printf("%s убит атакой воина!%n",
                    player.getName());
        }
    }
}
