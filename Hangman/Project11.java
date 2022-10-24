import java.util.Scanner;
import java.awt.*;	
import javax.swing.*;
/******************************************************************************
 * 
 * Name:	Zain Rahman
 * Block:	F			
 * Date:	12/10/19		(put your SUBMISSION date here. Then if you turn in 
 *  						two versions I can tell which is more recent.)
 * 
 *  Program #11:	Hangman
 *  Description:
 *     Describe the program briefly in YOUR OWN WORDS.  Explain the problem 
 *     that it solves and any special features you added to the program. Use as
 *     many lines as it takes and don't make any one line too long. 
 * 
 ******************************************************************************/

public class Project11 extends JFrame
{
	private static Image Hangman = new ImageIcon("Hangman.png").getImage();
	private static int attempts = 6;
	private static String displayString = ""; 
	private static String displaySpace = "";
	private static String wrongGuess = "";
	
	public static void main(String args[])
	{
		Scanner console = new Scanner(System.in);
		
		// C - Create and display the window. Use YOUR class name, not SampleGraphics!
		Project11 window = new Project11();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Sample Graphics");			// Optional title
		window.setSize(1000, 770);					// Set the width and height of the window
		window.setVisible(true);	
		
		//get secret word
		System.out.print("Enter your word:  ");
		String word = console.nextLine();
		
		//build mod string
		String mod = "";
		//build display string
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == ' ')
			{
				displayString += " ";
			}
			else
			{
				displayString += "_";
			}
		}
		for(int o = 0; o < displayString.length(); o++)
		{
			displaySpace = displaySpace + displayString.charAt(o) + ' ';
		}
		
		System.out.println(displayString);
		window.repaint();
		while(attempts != 0)
		{
			while(displayString.indexOf('_') != -1)
			{
				//get a guess
				System.out.print("Enter your letter:  ");
				String guess = console.nextLine();
				char c = guess.charAt(0);
				if(displayString.indexOf(c) != -1)
				{
					System.out.println("You have already guessed the letter" + c + " guess again!");
				}
				//check if its a good guess
				else if(word.indexOf(c) != -1)
				{
					//updating the display string
					for(int p = 0; p < word.length(); p++)
					{
						if(c == word.charAt(p))
						{
							mod += word.charAt(p);
						}
						else
						{
							mod += displayString.charAt(p);
						}
						
					}
					displayString = mod;
					mod = "";
					System.out.println("Correct Guess! Letter " + c + " is in the string!");
				}
				else //bad guess
				{
					attempts --;
					System.out.println("Attempts remaining = " + attempts);
					window.repaint();
					System.out.println("Incorrect Guess! Letter " + c + " is not in the string!");
					wrongGuess += c;
				}
			
				System.out.println(displayString);
				displaySpace = "";
				for(int o = 0; o < displayString.length(); o++)
				{
					displaySpace = displaySpace + displayString.charAt(o) + ' ';
				}
				window.repaint();
			}
			attempts = 0;
		}
		if(displayString.indexOf('_') != -1)
		{
			System.out.print("You Lose");
		}
		else
		{
			System.out.print("You Win!");
		}
	}
	public void paint(Graphics g) 		
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 770);
		
		g.setColor(Color.black);
		if(attempts == 0)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Draw Body
			g.drawLine(415, 355, 415, 470);
			//Draw Left leg
			g.drawLine(415, 470, 365, 570);
			//Draw Right leg
			g.drawLine(415, 470, 465, 570);
			//Draw Left arm
			g.drawLine(415, 405, 365, 380);
			//Draw Right arm
			g.drawLine(415, 405, 465, 380);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else if(attempts == 1)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Draw Body
			g.drawLine(415, 355, 415, 470);
			//Draw Right leg
			g.drawLine(415, 470, 465, 570);
			//Draw Left arm
			g.drawLine(415, 405, 365, 380);
			//Draw Right arm
			g.drawLine(415, 405, 465, 380);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else if(attempts == 2)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Draw Body
			g.drawLine(415, 355, 415, 470);
			//Draw Left arm
			g.drawLine(415, 405, 365, 380);
			//Draw Right arm
			g.drawLine(415, 405, 465, 380);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else if(attempts == 3)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Draw Body
			g.drawLine(415, 355, 415, 470);
			//Draw Right arm
			g.drawLine(415, 405, 465, 380);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else if(attempts == 4)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Draw Body
			g.drawLine(415, 355, 415, 470);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else if(attempts == 5)
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
			g.drawOval(365, 255, 100, 100);
			//Left Eye
			g.drawOval(390, 290, 20, 10);
			//Right Eye
			g.drawOval(425, 290, 20, 10);
			//Smile
			g.drawArc(385, 290, 60, 40, 210, 120); 
		}
		else
		{
			//Draw Image
			g.drawImage(Hangman, 100, 100, 400, 550, this);
			//Draw Face
		}
		
		g.setFont(new Font("Helvetica", Font.PLAIN, + 80));
		g.drawString(displaySpace, 600, 500);
		g.setFont(new Font("Helvetica", Font.PLAIN, + 50));
		g.drawString("attempts = " + attempts, 500, 200);
		g.drawString("Wrong Guesses:", 500, 100);
		g.drawString(wrongGuess, 500, 150);
		if(attempts <= 0)
		{
			if(displayString.indexOf('_') != -1)
			{
				g.setColor(Color.red);
				g.fillRect(0, 0, 1000, 770);
				
				g.setColor(Color.black);
				g.drawString("You Lose!", 400, 385);
			}
			else
			{
				g.setColor(Color.red);
				g.fillRect(0, 0, 1000, 770);
				
				g.setColor(Color.black);
				g.drawString("You Win!", 400, 385);
		}
	}
	}



}
