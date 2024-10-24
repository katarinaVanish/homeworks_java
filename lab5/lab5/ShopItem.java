package org.knit.lab5;

import static java.util.Objects.hash;

public class ShopItem {
    String name;
    int price;
    boolean available; // (не) в наличии

    public ShopItem(String name, int price, boolean available){
        this.name = name;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString(){ // товар N руб. - (не) в наличии
        StringBuilder string = new StringBuilder();
        string.append(name).append(" ").append(price).append(" руб.");
        if (available){
            string.append(" - в наличии");
        } else { string.append(" - не в наличии"); }

        return string.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (this.getClass() == o.getClass()){
            ShopItem item = (ShopItem) o;
            if (this.name.equals(item.name) &&
                    this.price == item.price &&
                    this.available == item.available){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return hash(name, price, available);
    }

}
