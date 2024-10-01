package org.knit.lab3;

public class Task6 {
    public static void main(String[] args) {
        Mage mage = new Mage("Триунин", 1, 1, 30);
        Priest priest = new Priest("Арвель", 2, 2, 15);
        Warrior warrior = new Warrior("Грувид", 1, 2, 40);
        mage.castSpell(warrior);
        warrior.attack(mage);
        warrior.attack(mage);
        warrior.attack(mage);
        priest.heal(mage);

    }
}
