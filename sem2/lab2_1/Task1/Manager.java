package org.knit.sem2.lab2_1.Task1;

class Manager extends Handler {
    @Override
    protected boolean canHandle(Problem problem) {
        return problem.getSeverity() == 2 &&
                (problem.getCategory().equals("финансовая") || problem.getCategory().equals("техническая"));
    }

    @Override
    protected void processComplaint(Problem problem) {
        System.out.println("Менеджер решил проблему: " + problem.getDescription());
    }
}
