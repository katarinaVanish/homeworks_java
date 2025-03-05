package org.knit.sem2.lab2_1.Task1;

public class Task1 {
    public static void main(String[] args){
        Handler callCenter = new CallCenter();
        Handler manager = new Manager();
        Handler legalDepartment = new LegalDepartment();
        Handler director = new Director();

        callCenter.setNextHandler(manager);
        manager.setNextHandler(legalDepartment);
        legalDepartment.setNextHandler(director);

        Problem problem1 = new Problem("Долгое ожидание на линии", 1, "общая");
        Problem problem2 = new Problem("Ошибка в выписке счета", 2, "финансовая");
        Problem problem3 = new Problem("Юридическая ошибка в договоре", 3, "юридическая");
        Problem problem4 = new Problem("Финансовая махинация", 4, "финансовая");

        callCenter.handleComplaint(problem1);
        callCenter.handleComplaint(problem2);
        callCenter.handleComplaint(problem3);
        callCenter.handleComplaint(problem4);

    }

}
