package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {

    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1", 6013);
            //change ip address to any ip or url

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }

            socket.close();
        } catch (IOException ioe){
            System.out.println("Shit got real");
            System.err.println(ioe);
        }
    }
}