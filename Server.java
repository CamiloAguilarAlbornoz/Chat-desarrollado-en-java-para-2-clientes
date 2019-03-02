package co.edu.uptc.prgr3.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket socket;
	private Socket firstClient;
	private Socket secondClient;
	private String messageFromFirstClient;
	private String messageFromSecondClient;

	public Server() throws IOException {
		socket = new ServerSocket(31510);
		firstClient = socket.accept();
		secondClient = socket.accept();
		while(true)
			getMessage();
	}
	
	public void getMessage() throws IOException {
		messageFromFirstClient = createInPut(firstClient).readUTF();
		messageFromSecondClient = createInPut(secondClient).readUTF();
		if (!messageFromFirstClient.equals(null))
			createOutPut(secondClient).writeUTF(messageFromFirstClient);
		if (!messageFromSecondClient.equals(null))
			createOutPut(firstClient).writeUTF(messageFromSecondClient);
	}

	private DataOutputStream createOutPut(Socket socket) throws IOException {
		return new DataOutputStream(socket.getOutputStream());
	}
	
	private DataInputStream createInPut(Socket socket) throws IOException {
		return new DataInputStream(socket.getInputStream());
	}
}
