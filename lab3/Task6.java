package org.knit.lab3;

public class Task6 {
    public static void main(String[] args) {
        Mage mage = new Mage("Триунин", 1, 1, 30);
        System.out.println(mage);
        Priest priest = new Priest("Арвель", 2, 2, 15);
        System.out.println(priest);
        Warrior warrior = new Warrior("Грувид", 1, 2, 40);
        System.out.println(warrior);
        Warrior tank = new Guard("Пандав", 3, 1,20, 10);
        System.out.println(tank);

        System.out.println(" I раунд!");
        mage.castSpell(warrior);
        priest.moveTo(3, 4);
        warrior.attack(mage);
        tank.attack(mage);

        System.out.println("\n II раунд!");
        mage.castSpell(tank);
        priest.heal(warrior);
        warrior.attack(mage);
        tank.attack(priest);

        System.out.println("\n III раунд!");
        warrior.attack(mage);
        priest.heal(mage);
        tank.attack(warrior);

        System.out.println(mage);
        System.out.println(priest);
        System.out.println(warrior);
        System.out.println(tank);
    }
}
