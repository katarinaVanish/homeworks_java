package org.knit.lab5;

import java.util.Comparator;

public interface ItemComparator extends Comparator<ShopItem> {
    static Comparator<ShopItem> byName(){
        return Comparator.comparing(ShopItem::getName);
    }

    static Comparator<ShopItem> byPrice(){
        return Comparator.comparingInt(shopItem -> shopItem.getPrice());
    }

    static Comparator<ShopItem> byAvailable(){
        return Comparator.comparing(shopItem -> shopItem.isAvailable());
    }

    static Comparator<ShopItem> byAvailableNamePrice(){
        return Comparator.comparing(ShopItem::getName).thenComparing(ShopItem::getPrice).thenComparing(ShopItem::isAvailable);

    }
}
