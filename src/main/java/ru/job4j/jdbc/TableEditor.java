package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName(properties.getProperty("driver_class"));
            String url = properties.getProperty("url");
            String login = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void execute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(String tableName) {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s();", tableName);
        execute(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format("DROP TABLE IF EXISTS %s;", tableName);
        execute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type);
        execute(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
        execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        execute(sql);
    }

    public void printTableSchema(String tableName) {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format("SELECT * FROM %s LIMIT 1", tableName));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(buffer);
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                throw new IllegalStateException("File app.properties not found");
            }
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {
            String tableName = "users";
            tableEditor.dropTable(tableName);

            tableEditor.createTable(tableName);
            tableEditor.printTableSchema(tableName);

            tableEditor.addColumn(tableName, "id", "SERIAL PRIMARY KEY");
            tableEditor.printTableSchema(tableName);

            tableEditor.addColumn(tableName, "name", "VARCHAR(255)");
            tableEditor.printTableSchema(tableName);

            tableEditor.renameColumn(tableName, "name", "full_name");
            tableEditor.printTableSchema(tableName);

            tableEditor.dropColumn(tableName, "full_name");
            tableEditor.printTableSchema(tableName);

            tableEditor.dropTable(tableName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
