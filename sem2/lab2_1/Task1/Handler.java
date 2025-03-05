package org.knit.sem2.lab2_1.Task1;

// Абстрактный класс обработчика
abstract class Handler {
    protected Handler nextHandler; // Следующий обработчик в цепочке


    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleComplaint(Problem problem) {
        if (canHandle(problem)) {
            processComplaint(problem);
        } else if (nextHandler != null) {
            nextHandler.handleComplaint(problem);
        } else {
            System.out.println("Жалоба не может быть решена. Мы свяжемся с вами позже.");
        }
    }

    protected abstract boolean canHandle(Problem problem);
    protected abstract void processComplaint(Problem problem);
}

