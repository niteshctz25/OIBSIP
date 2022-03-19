import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
//import java.lang.*;
import java.util.Scanner;

public class NumberGuessing {
	static int left = 0;
	static int totalAttempts = 0;	
	Scanner sc = new Scanner(System.in);

	void addAttempts() {
		int limit = 0 , totalAttempts = 0;
	
		JFrame frame = new JFrame();
	    int answer = JOptionPane.showConfirmDialog(frame, "Do you want to add more Attempts");
	    if (answer == JOptionPane.YES_OPTION) {
	    	String remain = JOptionPane.showInputDialog("Number of Attempts you want to add: ");
	    	guess(limit,remain);
	    } 
	    else if (answer == JOptionPane.NO_OPTION) {
	    	if (totalAttempts == 0) {
	    		JOptionPane.showMessageDialog(null,"Result Not Generated because, \n User didn't guess the number");
	    	}
	    	else {
	    		displayScore(left,totalAttempts);
	    	}
	    	
	    }
	}
	
	
	void guess(int limit ,String remain) {
	 
		totalAttempts = Integer.parseInt(remain);
		
		System.out.print("Random value from 1 to 100 is: ");
	    int random_num = (int)(Math.random()*100+1);
	    System.out.println(random_num);
	    left = Integer.parseInt(remain);
	    
		while(limit < left) {
		    String num = JOptionPane.showInputDialog("Guess the number: ");
		    
			if(random_num == Integer.parseInt(num)) {
				JOptionPane.showMessageDialog(null,"Entered/Guessed number matches the Random Number!!!");
				break;
		    }
		    else if(random_num > Integer.parseInt(num)) {
		    	JOptionPane.showMessageDialog(null,"Try Again!!! \n Entered/Guessed number is smaller than the Random number");
		    	JOptionPane.showMessageDialog(null,left-1 + " attempts left.");
		    }
		    else if(random_num < Integer.parseInt(num)) {
		    	JOptionPane.showMessageDialog(null,"Try Again!!! \n Entered/Guessed number is greater than the Random number");
		    	JOptionPane.showMessageDialog(null,left-1 + " attempts left.");
		    }
		    else {
		    	JOptionPane.showMessageDialog(null,"Try Again!!! \n Enter the number between 1 to 100.");
		    	JOptionPane.showMessageDialog(null,left-1 + " attempts left.");
		    }
			limit++;
			left--;
		}
		displayScore(left,totalAttempts);
	}
	
	void displayScore(int left, int totalAttempts) {
		double score = (left * 100)/totalAttempts;
		JOptionPane.showMessageDialog(null,"You got "+ score + "%");
	}
	
	public static void main(String[] args) {
		NumberGuessing n1 = new NumberGuessing();   
	    n1.addAttempts();
		
	}

}
