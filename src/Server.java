import java.io.*;
import java.net.*;

public class Server {

	public static void main(String args[]) throws Exception {

		String clientSentence;
		String dosomethingSentence;

		ServerSocket welcomeSocket = new ServerSocket(5775);

		while(true) {
			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();

			System.out.println(clientSentence);

			dosomethingSentence = new StringBuilder(clientSentence).reverse().toString();

			outToClient.writeBytes(dosomethingSentence + "\n");
		}

	}

}
