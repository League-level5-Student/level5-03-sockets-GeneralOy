package _01_Intro_To_Sockets.client;

import java.net.*;
import java.io.*;

public class ClientGreeter {

	public static void main(String[] args) {
		/**
		 * 1. Create a String for the ip address of the server. // If you don't know how
		 * to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig
		 * on windows.
		 */
		String serverip = "192.168.7.107";
		/** 2. Create an integer for the server's port number */
		int port = 8080;
		/** 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions. */
		try {
			Socket sock = new Socket(serverip, port);
			/**
			 * 4. Create an object of the Socket class. When initializing the object, pass
			 * in the ip address and the port number
			 */
			DataOutputStream DOS = new DataOutputStream(sock.getOutputStream());
			/**
			 * 5. Create a DataOutputStream object. When initializing it, use the Socket
			 * object you created in step 4 to call the getOutputStream() method.
			 */
			DOS.writeUTF("hello");
			/**
			 * 6. Use the DataOutputStream object to send a message to the server using the
			 * // writeUTF(String message) method
			 */
			DataInputStream DIS = new DataInputStream(sock.getInputStream());
			/**
			 * 7. Create a DataInputStream object. When initializing it, use the Server //
			 * object you created in step 4 to call the getInputStream() method.
			 */
			DIS.readUTF();
			/**
			 * 8. Use the DataInputStream object to print a message from the server using //
			 * the readUTF() method.
			 */
			sock.close();
			/** 9. Close the client's server object */
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
}
