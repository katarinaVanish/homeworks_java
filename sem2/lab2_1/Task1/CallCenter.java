package org.knit.sem2.lab2_1.Task1;


class CallCenter extends Handler {
    @Override
    protected boolean canHandle(Problem problem) {
        return problem.getSeverity() == 1 &&
                (problem.getCategory().equals("общая") || problem.getCategory().equals("техническая"));
    }

    @Override
    protected void processComplaint(Problem problem) {
        System.out.println("Колл-центр решил проблему: " + problem.getDescription());
    }
}

