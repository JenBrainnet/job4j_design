package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String line = input.readLine();
                    System.out.println(line);
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String message = extractMessage(line);
                    switch (message) {
                        case "Hello" -> output.write("Hello\n".getBytes());
                        case "Exit" -> server.close();
                        default -> output.write("What\n".getBytes());
                    }
                    while ((line = input.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }
                    output.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Server error", e);
        }
    }

    private static String extractMessage(String line) {
        int start = line.indexOf("msg=");
        if (start == -1) {
            return "";
        }
        start += 4;
        int end = line.indexOf('&', start);
        if (end == -1) {
            end = line.indexOf(' ', start);
        }
        return line.substring(start, end);
    }

}
