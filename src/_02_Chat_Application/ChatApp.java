package _02_Chat_Application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ChatApp implements ActionListener {
	String messageLog = "";
	JPanel mPanel = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	JLabel messages = new JLabel();
	JFrame mainFrame = new JFrame();
	// Add another scroll panel to list users currently on the app; also add
	// usernames(joptionpane/etc. that takes an input @ beginning)
	JButton sendMessage = new JButton();
	JTextField textIn = new JTextField();
	// JLabel clientNum = new JLabel();

	JTextArea textArea = new JTextArea();

	JScrollPane mainPane = new JScrollPane(textArea);
	JScrollPane messagePane = new JScrollPane(messages);

	// Server server;
	// Client client;
	public static void main(String[] args) {
		new ChatApp();
	}

	public ChatApp() {

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);

		mainFrame.add(mPanel);
		//WORK HERE - GridBagLayout is not working correctly; see resources
		/*
		 * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
		 * https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
		 * 
		 * */
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 5;
		mPanel.add(messagePane, c);
		textArea.setLineWrap(true);
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 3;
		c.gridheight = 2;
		mPanel.add(mainPane, c);
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 3;
		c.gridheight = 1;
		mPanel.add(sendMessage, c);
		sendMessage.addActionListener(this);

		sendMessage.setText("Send Message");
		sendMessage.setPreferredSize(new Dimension(200, 50));

		mainPane.setVisible(true);
		mainPane.setPreferredSize(new Dimension(450, 500));
		mainPane.createVerticalScrollBar();
		//mainFrame.setSize(500, 500);
		mainFrame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == sendMessage) {
			if (!textArea.getText().trim().isEmpty()) {
				System.out.println(textArea.getText());

				messageLog = /*userName + ": " + */messageLog + "<br>" + textArea.getText();
				messages.setText("<html>" + messageLog + "<html>");
				textArea.setText("");
			}
		}
	}

}
