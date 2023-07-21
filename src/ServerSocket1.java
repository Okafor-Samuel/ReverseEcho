import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket1 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server created Successfully!");
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        String message;
        StringBuilder stringBuilder;
        do{
            message = bufferedReader.readLine();
           stringBuilder = new StringBuilder(message);
           stringBuilder.reverse();
           message = stringBuilder.toString();
           printStream.println(message);
        }while (!message.equals("sam"));

    }
}