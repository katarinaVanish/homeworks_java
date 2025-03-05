package org.knit.sem2.lab2_1.Task1;

public class Problem {
    private String description;
    private int severity; // 1 - простая, 2 - средняя, 3 - сложная, 4 - критическая
    private String category; // Категория жалобы (финансовая, техническая, юридическая, общая)

    public Problem(String description, int severity, String category) {
        this.description = description;
        this.severity = severity;
        this.category = category;
    }

    public int getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
