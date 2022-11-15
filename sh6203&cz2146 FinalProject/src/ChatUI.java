package edu.nyu.ce.shengwei_zhangce;

import javax.swing.*;
import javax.swing.GroupLayout.*;

import java.net.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author shengweihuang
 * @netID sh6203
 *
 */

public class ChatUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	private JButton exitButton;
	private JScrollPane chatScroll;
	private JScrollPane typeScroll;
	private JScrollPane userScroll;
	private JLabel chatLabel;
	private JLabel typeLabel;
	private JLabel userLabel;
	public static JTextArea chatTXT;
	public static JTextArea typeTXT;
	public static JTextArea userTXT;

	public static String msg;
	public static String clientName;
	public static DatagramSocket ds;
	public static MulticastSocket clientSocket;
	public static InetAddress targetAddr;

	public ChatUI() {
		enterButton = new JButton();
		exitButton = new JButton();
		chatScroll = new JScrollPane();
		typeScroll = new JScrollPane();
		userScroll = new JScrollPane();
		chatLabel = new JLabel();
		typeLabel = new JLabel();
		userLabel = new JLabel();
		chatTXT = new JTextArea();
		typeTXT = new JTextArea();
		userTXT = new JTextArea();

		int windowClose = WindowConstants.EXIT_ON_CLOSE;
		setDefaultCloseOperation(windowClose);

		enterButton.setText("Enter");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = typeTXT.getText();
				
				
				System.out.print("I'm here............"+ txt);
				
				if (!txt.equals("")) {
					msg = clientName + ": " + txt;
					try {
						byte[] buffer;
						buffer = msg.getBytes();
						InetAddress hostAddr = InetAddress.getByName(ChatRoomConstants.IP_ADDR_1);
						DatagramPacket p = new DatagramPacket(buffer, buffer.length, hostAddr,
								ChatRoomConstants.PORT_1);
						ds.send(p);
					} catch (Exception exception) {
						System.out.println("send error msg");
						exception.printStackTrace();
					}
				}
			}
		});

		chatTXT.setEditable(false);
		chatTXT.setColumns(ChatRoomConstants.COLUMN_SIZE);
		Font f1 = new Font("Times", ChatRoomConstants.NOT_BOLD, ChatRoomConstants.WORD_SIZE);
		chatTXT.setFont(f1);
		chatTXT.setRows(ChatRoomConstants.ROW_SIZE);
		Cursor c = new Cursor(Cursor.TEXT_CURSOR);
		chatTXT.setCursor(c);
		chatScroll.setViewportView(chatTXT);

		typeTXT.setColumns(ChatRoomConstants.COLUMN_SIZE);
		Font f2 = new Font("Arial", ChatRoomConstants.BOLD, ChatRoomConstants.WORD_SIZE);
		typeTXT.setFont(f2);
		typeTXT.setRows(ChatRoomConstants.ROW_SIZE);
		typeScroll.setViewportView(typeTXT);

		Font f3 = new Font("Arial", ChatRoomConstants.BOLD, ChatRoomConstants.WORD_SIZE);
		chatLabel.setFont(f3);
		chatLabel.setText("type words here");
		exitButton.setText("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = clientName + " exists from the chatting room";
				byte[] buffer = txt.getBytes();
				try {
					InetAddress hostAddr = InetAddress.getByName(ChatRoomConstants.IP_ADDR_1);
					DatagramPacket p = new DatagramPacket(buffer, buffer.length, hostAddr, ChatRoomConstants.PORT_1);
					ds.send(p);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				try {
					InetAddress hostAddr = InetAddress.getByName(ChatRoomConstants.IP_ADDR_2);
					DatagramPacket p = new DatagramPacket(buffer, buffer.length, hostAddr, ChatRoomConstants.PORT_2);
					ds.send(p);
					clientSocket.leaveGroup(targetAddr);
					ds.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				setVisible(false);
				ChatRoomMain chat = new ChatRoomMain();
				chat.setVisible(true);
			}
		});

		Font f4 = new Font("Arial", ChatRoomConstants.BOLD, ChatRoomConstants.WORD_SIZE);
		typeLabel.setFont(f4);
		typeLabel.setText("chat window");

		userTXT.setEditable(false);
		userTXT.setColumns(ChatRoomConstants.COLUMN_SIZE);
		Font f5 = new Font("Arial", ChatRoomConstants.BOLD, ChatRoomConstants.USER_WINDOW_SIZE);
		userTXT.setFont(f5);
		userTXT.setRows(ChatRoomConstants.ROW_SIZE);
		userScroll.setViewportView(userTXT);

		Font f6 = new Font("Arial", ChatRoomConstants.BOLD, ChatRoomConstants.WORD_SIZE);
		userLabel.setFont(f6);
		userLabel.setText("Online Users");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		getContentPane().setLayout(groupLayout);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(23, 23, 23)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(chatScroll)
								.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGap(50, 50, 50)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(userLabel)
								.addComponent(userScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(chatLabel)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(typeScroll, GroupLayout.PREFERRED_SIZE, 326,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(73, 73, 73).addComponent(exitButton)))
								.addGap(0, 163, Short.MAX_VALUE)))
				.addContainerGap()));

		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(typeLabel)
								.addComponent(userLabel))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chatScroll, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(userScroll, GroupLayout.PREFERRED_SIZE, 199,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(chatLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(typeScroll, GroupLayout.PREFERRED_SIZE, 199,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(exitButton)))
						.addContainerGap()));

		pack();
		this.setLocationRelativeTo(null);
	}
}
