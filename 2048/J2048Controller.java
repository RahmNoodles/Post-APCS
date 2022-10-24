import java.util.Scanner;
import java.util.Random;
// Controller for Java 2048
// Author: Your Name Here
// This class translates user actions into operations on the model

public class J2048Controller 
{
    // Instance Variables
    int DIM;
    J2048Model model;
    J2048View view;
    public static long SEED;
    StoredBoard board;
    MenloStackBoard undoStack;

    // Constructors
    public J2048Controller()
    {
        undoStack = new MenloStackBoard(10);
        model = new J2048Model(SEED);
        view = new J2048View();
        DIM = 4;
        board = new StoredBoard(DIM);
        model.init(board);

    }

    // Methods
    public void start()
    {
        view.printStart(board);
    }

    public boolean gameLoop()
    {
        if(model.checkWin(board))
            {
                view.printGameOver(board);
                return false;
            }
        //String input = "";
        //if(s.hasNextLine())
        //{
        int move = view.getInput();
        //}
        if(move >= 0)
        {
            undoStack.push(new StoredBoard(board));
            model.move(board, move);
            model.spawn(board);
            view.printScore(board);
            view.draw(board);
        }
        else if(move == -3)
        {
            if(!undoStack.isEmpty())
            {
                board = undoStack.pop();
                view.printScore(board);
                view.draw(board);
            }
            else
            {
                view.printCannotUndo();
            }
        }
        else if(move == -1)
        {
            view.printQuit(board);
            return false;
        }
        else
        {
            view.printCommandNotRecognized();
        }
        return true;
    }

	public static void main(String[] args) 
    {
        J2048Controller controller = new J2048Controller();
        boolean run = true;
        controller.start();

        while(run)
        {
            run = controller.gameLoop();
        }
	}




    

}