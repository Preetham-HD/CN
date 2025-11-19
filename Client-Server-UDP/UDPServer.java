import java.io.*;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(5000);
            System.out.println("UDP Server started. Waiting for messages...");

            byte[] buffer = new byte[1024];
            String message = "";

            while (!message.equals("Over")) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Client: " + message);
            }

            System.out.println("Closing server...");
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
