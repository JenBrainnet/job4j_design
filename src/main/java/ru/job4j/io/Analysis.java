package ru.job4j.io;

import java.io.*;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            boolean isAvailable = true;
            String startTime = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];
                if (isErrorStatus(status) && isAvailable) {
                    isAvailable = false;
                    startTime = time;
                } else if (!isErrorStatus(status) && !isAvailable) {
                    isAvailable = true;
                    writer.println(startTime + ";" + time + ";");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isErrorStatus(String status) {
        return "400".equals(status) || "500".equals(status);
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }

}
