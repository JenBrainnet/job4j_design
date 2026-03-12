package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    boolean shouldStopServer = false;
                    for (String line = input.readLine(); line != null && !line.isEmpty(); line = input.readLine()) {
                        if (line.contains("msg=Bye")) {
                            shouldStopServer = true;
                        }
                        System.out.println(line);
                    }

                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    output.flush();
                    if (shouldStopServer) {
                        server.close();
                    }
                }
            }
        }
    }

}
