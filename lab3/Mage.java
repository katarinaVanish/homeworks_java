package org.knit.lab3;

public class Mage extends Player implements SpellCaster{
    private int castPower;
    private int castRadius;

    public Mage(String name, int x, int y, int castPower){
        super(name, x, y);
        this.castPower = castPower;
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
    public void castSpell(Player player) {
        int lastHealth = player.getHealth();
        player.decreaseHealth(castPower);
        if (player.getAlife()){
            System.out.printf("%s атакован заклинанием мага! Здоровье: %d --> %d%n",
                    player.getName(), lastHealth, player.getHealth());
        } else {
            System.out.printf("%s убит заклинанием мага!%n",
                    player.getName());
        }
    }
}
