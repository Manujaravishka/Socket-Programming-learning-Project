package lk.ijse;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket remoteSocket = new Socket("localhost",3000);
            DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(remoteSocket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            dataOutputStream.writeUTF("Typing input : "+msg);


            dataOutputStream.flush();

            String message = dataInputStream.readUTF();
            System.out.println("Client : "+message);

            remoteSocket.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}