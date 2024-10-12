package org.knit.lab3;

public class Priest extends Player implements Healer {
    private int healPower;

    public Priest(String name, int x, int y, int healPower){
        super(name, x, y);
        this.healPower = healPower;
    }

    @Override
    protected void increaseHealth(int value){
        int hp = getHealth();
        hp += value;
        int maxHp = getMaxHealth();
        if (hp > maxHp){
            setHealth(maxHp);
        }
        else {
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
    public void heal(Player player){
        int lastHealth = player.getHealth();
        if (lastHealth == 0){
            System.out.println("Священник " + getName() + "пытается воскресить мертвого! Безуспешно...");
        }
        else {
            player.increaseHealth(healPower);

            System.out.printf("%s получил лечение от священника " + getName() + "! Здоровье: %d --> %d%n",
                    player.getName(), lastHealth, player.getHealth());
        }
    }

}
