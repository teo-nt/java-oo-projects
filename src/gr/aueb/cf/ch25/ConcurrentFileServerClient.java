package gr.aueb.cf.ch25;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConcurrentFileServerClient {
    private final static int port = 21;

    public static void main(String[] args) {
        String path = "";
        StringBuilder content = new StringBuilder();
        String line = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert the path of the file to print its content: ");
        path = sc.next().trim();


        try (Socket socketFd = new Socket("127.0.0.1", port);
             BufferedWriter outFd = new BufferedWriter(new OutputStreamWriter(socketFd.getOutputStream()));
             BufferedReader inFd = new BufferedReader(new InputStreamReader(socketFd.getInputStream()))) {

            outFd.write(path);
            outFd.newLine();
            outFd.flush();
            while ((line = inFd.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
