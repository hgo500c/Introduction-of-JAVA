package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollDice extends JFrame {
    //an array of image names of dice pictures
    private String images[]={"die1.png","die2.png","die3.png","die4.png",    
    "die5.png","die6.png"};
    private JPanel imagePanel;    
    private JPanel buttonPanel;  
    private JButton rollButton;
     private JLabel image1=new JLabel();
    private JLabel image2=new JLabel();  // for the dice img 
    private JLabel result=new JLabel();
    private ImageIcon dice1;        
    private ImageIcon dice2; // for the img icon  
    private Die dice=new Die(6);
    public RollDice(){   
            setTitle("Dice");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
            setLayout(new BorderLayout());
            buildImagePanel();  
            buildButtonPanel();                    
            add(imagePanel, BorderLayout.CENTER);   
            add(buttonPanel, BorderLayout.SOUTH);           
            pack(); 
            setVisible(true);
            
    }
    

    private void buildButtonPanel(){
    buttonPanel=new JPanel();    
    rollButton=new JButton("Roll Dice");   
    rollButton.addActionListener(new ButtonListener());  
    buttonPanel.add(rollButton);  
    buttonPanel.add(result);
    }  
    private class ButtonListener implements ActionListener{
    
            @Override
            
            public void actionPerformed(ActionEvent e){     
            	   int number = 0;
                    dice.roll();            
                    dice1=new ImageIcon(images[dice.getValue()]);  
                    number = dice.getValue();
                    dice.roll();
                    dice2=new ImageIcon(images[dice.getValue()]);
                    number =number+dice.getValue()+2;
                    image1.setIcon(dice1);            
                    image2.setIcon(dice2); 
                    result.setText("Result:"+number);
            }
            
    }
  
    private void buildImagePanel(){    
    	    int number = 0;
            imagePanel=new JPanel();        
            dice.roll();    
            number = dice.getValue();
            dice1=new ImageIcon(images[dice.getValue()]); 
            dice.roll();   
            number = number +dice.getValue()+2;
            dice2=new ImageIcon(images[dice.getValue()]);   
            image1.setIcon(dice1);          
            image2.setIcon(dice2);           
            imagePanel.add(image1);
            imagePanel.add(image2);
            
    }
	

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	
	}
}
