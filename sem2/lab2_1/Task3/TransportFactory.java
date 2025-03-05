package org.knit.sem2.lab2_1.Task3;

public class TransportFactory {
    public static Transport getTransport(String type) {
        switch (type.toLowerCase()) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Неизвестный тип транспортного средства: " + type);
        }
    }
}
