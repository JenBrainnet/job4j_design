package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.comparator.EmployeeSalaryDescComparator;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class ReportForHRTest {

    @Test
    void whenGenerateHrReportThenEmployeesSortedBySalaryDesc() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee first = new Employee("Ivan", now, now, 100);
        Employee second = new Employee("Petr", now, now, 300);
        Employee third = new Employee("Alex", now, now, 200);
        store.add(first);
        store.add(second);
        store.add(third);
        Comparator<Employee> comparator = new EmployeeSalaryDescComparator();
        Report report = new ReportForHR(store, comparator);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(second.getName()).append(" ")
                .append(second.getSalary())
                .append(System.lineSeparator())
                .append(third.getName()).append(" ")
                .append(third.getSalary())
                .append(System.lineSeparator())
                .append(first.getName()).append(" ")
                .append(first.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true))
                .isEqualTo(expected.toString());
    }

    @Test
    void whenFilterOnlyOneEmployeeThenReturnOnlyOneRow() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee first = new Employee("Ivan", now, now, 100);
        Employee second = new Employee("Petr", now, now, 200);
        store.add(first);
        store.add(second);
        Comparator<Employee> comparator = new EmployeeSalaryDescComparator();
        Report report = new ReportForHR(store, comparator);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(first.getName()).append(" ")
                .append(first.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> employee.getSalary() < 150))
                .isEqualTo(expected.toString());
    }

    @Test
    void whenNoEmployeesThenReturnOnlyHeader() {
        Store store = new MemoryStore();
        Comparator<Employee> comparator = new EmployeeSalaryDescComparator();
        Report report = new ReportForHR(store, comparator);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true))
                .isEqualTo(expected.toString());
    }

}