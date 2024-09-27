package org.knit.lab2;

public class Task4 {
    public void execute(){
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
        Shape cube = new Cube(3);       // Создаем куб со стороной 3container.add(sphere);  // Проверяем, можно ли добавить сферу

        container.add(sphere);
        container.add(cube);

        Shape cylinder = new Cylinder(10, 5);
        container.add(cylinder);
    }
}
