import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            InetAddress ip = InetAddress.getByName("127.0.0.1");

            String message = "";
            while (!message.equals("Over")) {
                message = input.readLine();

                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, 5000);
                socket.send(packet);
            }

            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
