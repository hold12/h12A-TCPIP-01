import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by tjc on 31/1/17.
 */
public class Client {
    public static void main(String args[]) throws Exception {
        String sentence;
        String modifiedSentence;

        while(true){
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("10.16.173.86", 5775);

            System.out.println("Local SocketAddress is: " + clientSocket.getLocalSocketAddress());
            System.out.print("Enter text:");

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            sentence = inFromUser.readLine();

            outToServer.writeBytes(sentence + "\n");

            modifiedSentence = inFromServer.readLine();

            System.out.println("Received from server: " + modifiedSentence + "\n");

            clientSocket.close();
        }

    }
}
