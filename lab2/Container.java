package org.knit.lab2;

public class Container {
    private double capacity;
    private double remainingVolume;

    public Container(double capacity) {
        this.capacity = capacity;
        this.remainingVolume = capacity;
    }

    public void add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= remainingVolume) {
            remainingVolume -= shapeVolume;
            System.out.println("Фигура добавлена. Оставшийся объем: " + remainingVolume);
        } else {
            System.out.println("Недостаточно места для добавления фигуры. Оставшийся объем: " + remainingVolume);
        }
    }

    public double getRemainingVolume() {
        return remainingVolume;
    }
}
