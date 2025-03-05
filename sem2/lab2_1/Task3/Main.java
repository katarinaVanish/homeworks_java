package org.knit.sem2.lab2_1.Task3;

public class Main {
    public static void main(String[] args) {
        Transport businessCar = TransportFactory.getTransport("business");
        System.out.println(businessCar.getSpecifications());

        Transport familyVan = TransportFactory.getTransport("family");
        System.out.println(familyVan.getSpecifications());

        Transport motorbike = TransportFactory.getTransport("delivery");
        System.out.println(motorbike.getSpecifications());
    }
}
