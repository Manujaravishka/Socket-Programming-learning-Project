package lk.ijse;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket remoteSocket = new Socket("localhost",3000);
            DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());

            dataOutputStream.writeUTF("Hello Server");
            dataOutputStream.flush();
            remoteSocket.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}