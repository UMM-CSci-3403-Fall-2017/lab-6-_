package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args){
        try {
            ServerSocket sock = new ServerSocket(6013);

            while(true){
                System.out.println("Got a request!");
                Socket client = sock.accept();

                //PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                OutputStream out = client.getOutputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

//                String line;
//                while(true){
//                    line = reader.readLine();
//
//                    if(line == null){
//                        break;
//                    }
//
//                    writer.println(line);
//                    System.out.println(line);
//                }

                int nextByte;
                while((nextByte = reader.read()) != -1){
                    //writer.print((char) nextByte);
                    out.write(nextByte);
                    System.out.println((char) nextByte);
                }
                //writer.println();
                System.out.println(nextByte);

                client.close();
            }
        } catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}