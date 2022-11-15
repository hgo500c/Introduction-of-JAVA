package PartII;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel; //the top of the panel
	WordList wordList; //add in the word list
	JList list;
	private JTextArea wordsArea; // text area
	DefaultListModel samplemodel; //model place

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set the size correctly
		this.setSize(500, 300);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 200);


		//panel at the top
		topPanel = new JPanel();
		
		  JLabel findLabel = new JLabel("Find: "); //label for the find
	       JTextField findplace = new JTextField(); // for the field 
	       findplace.setPreferredSize(new Dimension(200, 35));
	       JButton clearbutton = new JButton("Clear"); //this is for the clear
		// there should be objects in the top panel
	       topPanel.add(findLabel); //add to panel of the top
	       topPanel.add(findplace);//add to panel of the top
	       topPanel.add(clearbutton);//add to panel of the top
		
		// There should probably be something passed into the JScrollPane

		samplemodel = new DefaultListModel(); 
		list = new JList(samplemodel);
		 wordsArea = new JTextArea();
	       // create scroll and add text area to scroll
	       JScrollPane scrollarea = new JScrollPane(wordsArea);
	       JPanel wholepanel = new JPanel(new BorderLayout()); //whole panel
	       // and of course you will want them to be properly aligned in the frame
	       wholepanel.add(topPanel, BorderLayout.NORTH); //put the top and scroll in to the panel
	       wholepanel.add(scrollarea, BorderLayout.CENTER);
	       add(wholepanel);
	       // add key listener for text field
	       createMenus(); //add the creat 
	       findplace.addKeyListener(
	    	  new KeyListener() {

	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                   find(findplace.getText());
	               }
	           } //only has pressed

	           @Override
	           public void keyTyped(KeyEvent e) {

	           }

	           @Override
	           public void keyReleased(KeyEvent e) {

	           }
	       }

	       );

	       // get a clear buutton in here 
	       clearbutton.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	               findplace.setText("");
	               find("");

	           }
	       }
	       );
	}
	
	private void createMenus() {
		/* add a "File" menu with:
		 * "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		   JMenuBar MenuBar = new JMenuBar();
	       JMenu file = new JMenu("File");
	       JMenuItem open = new JMenuItem("Open");
	       JMenuItem exit = new JMenuItem("Exit");
	       file.add(open);
	       file.add(exit); // add into the menu selection
	       MenuBar.add(file);
	       setJMenuBar(MenuBar);
		
		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}

		/* ExitActionListener that will exit the file chooser */
		class ExitActionListener implements ActionListener {
	           public void actionPerformed(ActionEvent e) {

	               System.exit(0);
	           }
	       }
	       open.addActionListener(new OpenActionListener());
	       exit.addActionListener(new ExitActionListener());
	   }
	

	private void find(String s){
		List searchResult = null; // figure out from WordList how to get this
		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
		 wordsArea.setText("");
	       List searchResultt = wordList.find(s); //try to find the string in teh list
	       for (Object word : searchResultt)
	           wordsArea.setText(wordsArea.getText() + word.toString() + "\n"); //loop the list
	}
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					List searchResult = null; // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box

				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
