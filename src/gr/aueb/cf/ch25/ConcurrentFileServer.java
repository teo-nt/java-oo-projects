package gr.aueb.cf.ch25;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ConcurrentFileServer implements Runnable {
    private final Socket socketFd;

    public ConcurrentFileServer(Socket socketFd) {
        this.socketFd = socketFd;
    }

    @Override
    public void run() {
        try (BufferedWriter outFd = new BufferedWriter(new OutputStreamWriter(socketFd.getOutputStream()));
                BufferedReader inFd = new BufferedReader(new InputStreamReader(socketFd.getInputStream())) ) {

            String filename = inFd.readLine();
            String line ;
            System.out.println(filename);
            File file = new File("C:/tmp/resources/" + filename);
            if (!file.exists()) {
                outFd.write("This file does not exist in the resources");
                outFd.flush();
                return;
            }
            BufferedReader fileReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            while ((line = fileReader.readLine()) != null) {
                outFd.write(line);
                outFd.newLine();
                outFd.flush();
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
