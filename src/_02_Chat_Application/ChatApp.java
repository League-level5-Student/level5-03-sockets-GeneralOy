package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	JPanel mainPanel = new JPanel();
	JFrame mainFrame = new JFrame();
	JButton sendMessage = new JButton();
	JTextField textIn = new JTextField();
	JScrollPane mainPane = new JScrollPane();
	JTextArea textArea = new JTextArea();
	JLabel clientNum = new JLabel();
	
	Server server;
	Client client;
	public static void main(String[] args) {
		new ChatApp();
	}
	
	public ChatApp() {
		
		mainPanel.add(mainPane);
		mainFrame.add(mainPanel);
		
		mainPane.add(textArea);
		mainPanel.add(clientNum);
		mainPanel.add(textIn);
		mainPanel.add(sendMessage);
		mainFrame.setSize(200, 400);
		mainFrame.setVisible(true);
		textIn.setSize(200, 50);
	}
	
	
	
	
	
}
