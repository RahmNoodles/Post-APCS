//Methods from view/controller that need change: 
// Create a getScore method to give score to view
// Constructor needs dimensions of board and score to give to controller
//Method to be able to add to score
//Method to return dimensions
//Method to set point in array
//Method to return point in array
//Move has zeros from model to board
//Board instance variables: two dimensional int array and score
public class StoredBoard
{
    int score;
    int board[][];
    int dimension;

    public StoredBoard(int dim)
    {
        score = 0;
        dimension = dim;
        board = new int[dimension][dimension];
    }
    public StoredBoard(int dim, int s)
    {
        score = s;
        dimension = dim;
        board = new int[dimension][dimension];
    }
    public StoredBoard(StoredBoard copy)
    {
        score = copy.score;
        dimension = copy.dimension;
        board = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j < dimension; j++)
            {
                board[i][j]= copy.board[i][j];
            }
        }
    }
    public int getNum(int x, int y)
    {
        if(x >= 0 && x < dimension && y >= 0 && y < dimension)
        {
            return board[x][y];
        }
        else
        {
            throw new IllegalArgumentException("X and Y values not valid");
        }
    }
    public void setNum(int x, int y, int num)
    {
         if(x >= 0 && x < dimension && y >= 0 && y < dimension)
        {
            board[x][y] = num;
        }
        else
        {
            throw new IllegalArgumentException("X and Y values not valid");
        }
    }
    public void addNum(int x, int y, int add)
    {
         if(x >= 0 && x < dimension && y >= 0 && y < dimension)
        {
            board[x][y] += add;
        }
        else
        {
            throw new IllegalArgumentException("X and Y values not valid");
        }
    }
    public int getDimension()
    {
        return dimension;
    }
    public int getScore()
    {
        return score;
    }
    public void addScore(int value)
    {
        score += value;
    }
    public boolean hasZeros()
    {
        boolean foundAZero = false;
        for(int i = 0; i < dimension && foundAZero == false; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if(board[i][j] == 0)
                    foundAZero = true;
            }
        }
        
        return foundAZero;   
    }
}
