package edu.nyu.ce.shengwei_zhangce;

import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Ce Zhang
 * @netID cz2146
 */
public class ChatRoomMain extends JFrame {

	private static final long serialVersionUID = 1L;
	static String name;

	/**
	 * Creates the Chat application
	 */
	public ChatRoomMain() {

		this.setTitle("ChatMainRoom");
		this.setUndecorated(true);
		start();
		this.getContentPane().add(new JTextField("type your name"), BorderLayout.NORTH);
		this.getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
	}

	// set two button in here
	private JButton loginjButton;
	private JButton exitjButton;
	private JLabel jTextArea;

	/**
	 * This method will be used in the constructor to initialize the form.
	 */
	private void start() {
		jTextArea = new JLabel();
		loginjButton = new JButton();
		exitjButton = new JButton();

		Loginjubutton(); // log in button

		exitjubutton(); // exit button

		Basicform();// basic layer

		text();

		pack();
	}

	public void Loginjubutton() {
		loginjButton.setFont(new Font("Arial", 30, 25));
		loginjButton.setText("Login to the chat room");
		loginjButton.setSize(500, 400);
		loginjButton.setVerticalAlignment(SwingConstants.BOTTOM);
		loginjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				new UserClient();
			} // check them on the same action
		});
	}

	public void exitjubutton() {
		exitjButton.setFont(new Font("Arial", 5, 20));
		exitjButton.setText("Exit");
		exitjButton.setSize(500, 400);
		exitjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				System.exit(1);
			} // check them on the same action
		});
	}

	public void text() {
		jTextArea.setFont(new Font("Arial", 70, 70));
		jTextArea.setText("Login Page");
	} // set the window name

	public void Basicform() {
		GroupLayout BasicForm = new GroupLayout(getContentPane());
		getContentPane().setLayout(BasicForm);
		BasicForm.setHorizontalGroup(BasicForm.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(BasicForm.createSequentialGroup().addContainerGap(450, Short.MAX_VALUE)
						.addComponent(exitjButton).addContainerGap(100, Short.MAX_VALUE))
				.addGroup(BasicForm.createSequentialGroup().addGap(180, 180, 180).addComponent(loginjButton)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(BasicForm.createSequentialGroup().addContainerGap(60, Short.MAX_VALUE).addComponent(jTextArea)
						.addContainerGap(100, Short.MAX_VALUE))

		);
		BasicForm.setVerticalGroup(BasicForm.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(BasicForm.createSequentialGroup().addContainerGap(250, Short.MAX_VALUE)
						.addComponent(loginjButton).addGap(180, 180, 180).addComponent(exitjButton).addGap(50, 50, 50))
				.addComponent(jTextArea).addGap(100, 100, 100));
	} // set the two group to place the two button and title

	public static void main(String args[]) {
		
		
		
		System.out.println("Hello World!..............................................");
		
		// This is the chat room main.
		try {
			for (UIManager.LookAndFeelInfo text : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(text.getName())) {
					UIManager.setLookAndFeel(text.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ChatRoomMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ChatRoomMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ChatRoomMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(ChatRoomMain.class.getName()).log(Level.SEVERE, null, ex);
		}
		// throw all the exception here

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatRoomMain().setVisible(true);
			}
		}); // display the form.
	}
}
