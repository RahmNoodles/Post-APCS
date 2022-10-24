import java.util.Scanner;

// View for Java 2048
// Author: Your Name Here
//This class interacts with the user by printing the board to
// the screen along with the current score. It is the only class
// that should call System.out.print(). The View should not talk to the Model.

public class J2048View
{
    // Instance Variables
    Scanner s;
    // Constructors
    public J2048View()
    {
        s = new Scanner(System.in);
    }
    
    // Methods
    
    // Iterate over each element of board and print its value to the screen.
    // If the value is 0, print a "–" instead.
    public void printStart(StoredBoard board)
    {
        System.out.println("Starting game!");
        printScore(board);
        draw(board);
    }
    public void printGameOver(StoredBoard board)
    {
        System.out.println("Game over! Your score is " + board.getScore() + ".");
    }
    public void printQuit(StoredBoard board)
    {
        System.out.println("Your final score is " + board.getScore());
        System.out.println("Goodbye!");
    }
    public int getInput()
    {
        System.out.print("Move: ");
        String input = s.nextLine();
        if(input.equals("a"))
        {
            return 0;
        }
        if(input.equals("d"))
        {
            return 1;
        }
        if(input.equals("w"))
        {
            return 2;
        }
        if(input.equals("s"))
        {
            return 3;
        }
        if(input.equals("q"))
        {
            return -1;
        }
        if(input.equals("u"))
        {
            return -3;
        }
        return -2;
    }
    public void printScore(StoredBoard board)
    {
        System.out.println("Current Score: " + board.getScore());
        System.out.println("");
    }
    public void printCommandNotRecognized()
    {
        System.out.println("Command not recognized. Please try again.");
        System.out.println("");
    }
    public void printCannotUndo()
    {
        System.out.println("This is the first move you cannot undo. Please try again.");
        System.out.println("");
    }
    public void draw(StoredBoard board)
    {
        for(int y = 0; y < board.getDimension(); y ++)
        {
            for(int x = 0; x < board.getDimension(); x++)
            {
                if(board.getNum(x, y) == 0)
                {
                    System.out.printf("%5c", '-');
                }
                else
                {
                    System.out.printf("%5d", board.getNum(x, y));
                }
            }
            System.out.println("\n");
        }
        
    }

}