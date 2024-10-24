package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task8 {
    public void execute(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("misc/grocery_items.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringJoiner sb = new StringJoiner("\n");
        while (scanner.hasNext()) {
            sb.add(scanner.nextLine());
        }
        scanner.close();

        Random random = new Random();
        String[] names = sb.toString().split("\n");

        int[] prices = new int[100];
        for (int i = 0; i <= 99; i++){
            prices[i] = random.nextInt(100) + 10;
        }

        ShopItem[] items = new ShopItem[100];
        for (int j = 0; j <= 99; j++){
            items[j] = new ShopItem(names[random.nextInt(50)],
                    prices[random.nextInt(50)], random.nextBoolean());
        }

        HashMap<ShopItem, Integer> itemCount = new HashMap<>();
        Arrays.sort(items, ItemComparator.byAvailableNamePrice());
        for (ShopItem item : items){
            System.out.println(item);
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }
//        for (ShopItem item : itemCount.keySet()){
//            System.out.println(item + " : " + itemCount.get(item) + " шт.");
//        }
        int totalDup = 0;
        for (int count : itemCount.values()){
            if (count > 1) {
                totalDup += count;
            }
        }
        System.out.print("Всего одинаковых позиций: ");
        System.out.println(totalDup);
    }
}
