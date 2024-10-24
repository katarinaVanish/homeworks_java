package org.knit.lab5;

import java.util.Comparator;

public interface ItemComparator extends Comparator<ShopItem> {
    static Comparator<ShopItem> byName(){
        return Comparator.comparing(shopItem -> shopItem.name);
    }

    static Comparator<ShopItem> byPrice(){
        return Comparator.comparingInt(shopItem -> shopItem.price);
    }

    static Comparator<ShopItem> byAvailable(){
        return Comparator.comparing(shopItem -> shopItem.available);
    }

    static Comparator<ShopItem> byAvailableNamePrice(){
        return byAvailable().reversed().thenComparing(byName()).thenComparing(byPrice());
    }
}
