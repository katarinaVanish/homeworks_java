package org.knit.lab10;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final List<T> elements;

    public Box() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public double sum() {
        double total = 0;
        for (T element : elements) {
            total += element.doubleValue();
        }
        return total;
    }
}
