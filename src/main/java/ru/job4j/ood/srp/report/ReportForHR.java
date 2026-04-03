package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportForHR implements Report {

    private final Store store;
    private final Comparator<Employee> comparator;

    public ReportForHR(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        store.findBy(filter).stream()
                .sorted(comparator)
                .forEach(e -> text.append(e.getName()).append(" ")
                        .append(e.getSalary())
                        .append(System.lineSeparator()));
        return text.toString();
    }

}
