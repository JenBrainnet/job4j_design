package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportForProgrammersTest {

    @Test
    void whenGenerateReportThenReturnCsv() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report report = new ReportForProgrammers(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(",")
                .append(parser.parse(worker.getHired())).append(",")
                .append(parser.parse(worker.getFired())).append(",")
                .append(worker.getSalary())
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
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(first);
        store.add(second);
        Report report = new ReportForProgrammers(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(first.getName()).append(",")
                .append(parser.parse(first.getHired())).append(",")
                .append(parser.parse(first.getFired())).append(",")
                .append(first.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> employee.getSalary() < 150))
                .isEqualTo(expected.toString());
    }

    @Test
    void whenNoEmployeesThenReturnOnlyHeader() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report report = new ReportForProgrammers(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true))
                .isEqualTo(expected.toString());
    }

}