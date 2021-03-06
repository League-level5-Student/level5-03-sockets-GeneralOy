package _01_Intro_To_Sockets.server;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ServerGreeter extends Thread {
	/** 1. Create an object of the ServerSocket class */
	ServerSocket sockServ;
	Socket sock;

	public ServerGreeter() throws IOException {
		System.out.println("test1");
		/**
		 * 2. Initialize the ServerSocket object. In the parameters, you must define the
		 * port at which the server will listen for connections.
		 */
		sockServ = new ServerSocket(8080, 60000);
		run();
		/**
		 * *OPTIONAL* you can set a time limit for the server to wait by using the
		 * ServerSocket's setSoTimeout(int timeInMilliSeconds) method
		 */
	}

	public void run() {
		System.out.println("test2");
		/** 3. Create a boolean variable and initialize it to true. */
		boolean looper = true;
		/**
		 * 4. Make a while loop that continues looping as long as the boolean created in
		 * the previous step is true.
		 */
		while (looper) {
			System.out.println("3");
			/**
			 * 5. Make a try-catch block that checks for two types Exceptions:
			 * SocketTimeoutException and IOException. // Put steps 8 - 15 in the try block.
			 */
			try {
				System.out.println("4--");
				/** 8. Let the user know that the server is waiting for a client to connect. */
				JOptionPane.showMessageDialog(null, "Server is waiting for client connection");
				/**
				 * 9. Create an object of the Socket class and initialize it to
				 * serverSocket.accept(); Change serverSocket to match the ServerSocket member
				 * variable you created in step 1. The program will wait here until either a
				 * client connects or the timeout expires.
				 */
				sock = sockServ.accept();
				/** 10. Let the user know that the client has connected. */
				JOptionPane.showMessageDialog(null, "Connection established to client");
				/**
				 * 11. Create a DataInputStream object. When initializing it, use the Socket
				 * object you created in step 9 to call the getInputStream() method.
				 */
				DataInputStream Dis1 = new DataInputStream(sock.getInputStream());
				/**
				 * 12. Print the message from the DataInputStream object using the readUTF()
				 * method
				 */
				System.out.println(Dis1.readUTF()); 
				/**
				 * 13. Create a DataOutputStream object. When initializing it, use the Server
				 * object you created in step 9 to call the getOutputStream() method.
				 */
				DataOutputStream Dos = new DataOutputStream(sock.getOutputStream());
				/**
				 * 14. Use the DataOutputStream object to send a message to the client using the
				 * writeUTF(String message) method.
				 */
				Dos.writeUTF("Boo.");
				/* 15. Close the client server */
				sock.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Socket Timeout Exception" + e.getStackTrace());
				JOptionPane.showMessageDialog(null, "Socket Timeout Exception");
				looper = false;
			} catch (IOException f) {
				System.out.println("IO Exception" + f.getStackTrace());
				JOptionPane.showMessageDialog(null, "IO Exception");
				looper = false;
			}
		}

		/**
		 * 6. If the program catches a SockeTimeoutException, let the user know about it
		 * and set loop's boolean variable to false.
		 */

		/**
		 * 7. If the program catches a IOException, let the user know about it and set
		 * the loop's boolean variable to false.
		 */

	}

	public static void main(String[] args) {
		// 16. In a new thread, create an object of the ServerGreeter class and start
		// the thread. Don't forget the try-catch.*/
		Thread t1 = new Thread(() -> {
			try {
				ServerGreeter greeter = new ServerGreeter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();

	}
}
