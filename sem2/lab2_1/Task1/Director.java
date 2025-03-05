package org.knit.sem2.lab2_1.Task1;


class Director extends Handler {
    @Override
    protected boolean canHandle(Problem problem) {
        return problem.getSeverity() >= 4;
    }

    @Override
    protected void processComplaint(Problem problem) {
        System.out.println("Директор лично рассмотрел и решил проблему: " + problem.getDescription());
    }
}
