import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input your message : ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            String message;
            do{
                message = keyboard.readLine();
                printStream.println(message);
                message = bufferedReader.readLine();
                System.out.println("Message from server "+message);
            }while (!message.equals("sam"));

        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
