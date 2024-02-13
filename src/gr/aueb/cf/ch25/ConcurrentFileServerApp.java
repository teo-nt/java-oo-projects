package gr.aueb.cf.ch25;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentFileServerApp {
    private static final int port = 21;

    public static void main(String[] args) {
        try (var serverSocketFd = new ServerSocket(port, 10, InetAddress.getLoopbackAddress())) {
            System.out.println("Server started...");
            while (true) {
                Socket connectedFd = serverSocketFd.accept();
                (new ConcurrentFileServer(connectedFd)).run();
                connectedFd.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
