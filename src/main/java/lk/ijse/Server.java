package lk.ijse;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server Started");
            Socket localSocket =serverSocket.accept();

            System.out.println("Client accepted");
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client :"+message);

            localSocket.close();


        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
