package runner;

import java.io.IOException;

import co.edu.uptc.prgr3.net.Server;

public class Main {
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
