import java.util.Random;
//Model for Java 2048
//Author: Your Name Here
//This class initializes the pieces and also
//spawns a new piece every time the board is moved.
//The Model also moves the pieces on the board and
//determines if the game has been won.

public class J2048Model 
{
     // Instance variables
     Random r;
     
     // Constructors
     public J2048Model(long seed)
     {
         r = new Random(seed);
     }

     // Methods
     // Fill board with two 2s in random locations.
     /*
     * init must be implemented using the java equivalent
     *      of the following pseudo code
     * count = 0
     * do while count < 2
     *     x = Random.nextInt(0, board.length)
     *     if board[x] == 0
     *         board[x] = 2
     */
    public void init(StoredBoard board) 
{
    int counter = 0;
    do
    {
        int x = r.nextInt(board.getDimension());
        int y = r.nextInt(board.getDimension());
        if (board.getNum(x, y) == 0)
        {
            board.setNum(x, y, 2);
            counter++;
        }
    } while (counter < 2);
}

    public void left(StoredBoard board)
    {
        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int q = 0; q < board.getDimension(); q++)
            {
                for(int j = 0; j < board.getDimension() - 1; j++)
                {
                    if(board.getNum(j, y) == 0)
                    {
                        board.setNum(j, y, board.getNum(j+1, y));
                        board.setNum(j+1, y, 0);
                    }
                }
            }
        }
        
        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int i = 0; i < board.getDimension() - 1; i++)
            {
                
                if(board.getNum(i, y) == board.getNum(i+1, y))
                {
                    board.addNum(i, y, (board.getNum(i+1, y)));
                    board.setNum(i+1, y, 0);
                    board.addScore(board.getNum(i, y));
                }
            }
        }
        
        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int q = 0; q < board.getDimension(); q++)
            {
                for(int j = 0; j < board.getDimension() - 1; j++)
                {
                    if(board.getNum(j, y) == 0)
                    {
                        board.setNum(j, y, board.getNum(j+1, y));
                        board.setNum(j+1, y, 0);
                    }
                }
            }
        }
    }
    public void right(StoredBoard board)
    {
        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int k = board.getDimension(); k > 0; k--)
            {
                for(int j = board.getDimension() - 1; j > 0; j--)
                {
                    if(board.getNum(j, y) == 0)
                    {
                        board.setNum(j, y, board.getNum(j-1, y));
                        board.setNum(j-1, y, 0);
                    }
                }
            }
        }

        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int i = board.getDimension() -1; i > 0; i--)
            {
                if(board.getNum(i, y) == board.getNum(i-1, y))
                {
                    board.addNum(i, y, board.getNum(i-1, y));
                    board.setNum(i-1, y, 0);
                    board.addScore(board.getNum(i, y));
                }
            }
        }
        
        for(int y = 0; y < board.getDimension(); y++)
        {
            for(int k = board.getDimension(); k > 0; k--)
            {
                for(int j = board.getDimension() - 1; j > 0; j--)
                {
                    if(board.getNum(j, y) == 0)
                    {
                        board.setNum(j, y, board.getNum(j-1, y));
                        board.setNum(j-1, y, 0);
                    }
                }
            }
        }
    }

    public void down(StoredBoard board)
    {
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int k = board.getDimension(); k > 0; k--)
            {
                for(int j = board.getDimension() - 1; j > 0; j--)
                {
                    if(board.getNum(x, j) == 0)
                    {
                        board.setNum(x, j, board.getNum(x, j-1));
                        board.setNum(x, j-1, 0);
                    }
                }
            }
        }

        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int i = board.getDimension() -1; i > 0; i--)
            {
                if(board.getNum(x, i) == board.getNum(x, i-1))
                {
                    board.addNum(x, i, board.getNum(x, i-1));
                    board.setNum(x, i-1, 0);
                    board.addScore(board.getNum(x, i));
                }
            }
        }
        
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int k = board.getDimension(); k > 0; k--)
            {
                for(int j = board.getDimension()- 1; j > 0; j--)
                {
                    if(board.getNum(x, j) == 0)
                    {
                        board.setNum(x, j, board.getNum(x, j-1));
                        board.setNum(x, j-1, 0);
                    }
                }
            }
        }
    }

    public void up(StoredBoard board)
    {
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int q = 0; q < board.getDimension(); q++)
            {
                for(int j = 0; j < board.getDimension() - 1; j++)
                {
                    if(board.getNum(x, j) == 0)
                    {
                        board.setNum(x, j, board.getNum(x, j+1));
                        board.setNum(x, j+1, 0);
                    }
                }
            }
        }
        
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int i = 0; i < board.getDimension() - 1; i++)
            {
                
                if(board.getNum(x, i) == board.getNum(x, i+1))
                {
                    board.addNum(x, i, board.getNum(x, i+1));
                    board.setNum(x, i+1, 0);
                    board.addScore(board.getNum(x, i));
                }
            }
        }
        
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int q = 0; q < board.getDimension(); q++)
            {
                for(int j = 0; j < board.getDimension() - 1; j++)
                {
                    if(board.getNum(x, j) == 0)
                    {
                        board.setNum(x, j, board.getNum(x, j+1));
                        board.setNum(x, j+1, 0);
                    }
                }
            }
        }
    }

    public void move(StoredBoard board, int direction)
    {
        if(direction == 0)
        {
            left(board);
        }
        else if(direction == 1)
        {
            right(board);
        }
        else if(direction == 2)
        {
            up(board);
        }
        else if(direction == 3)
        {
            down(board);
        }
    }

    // Spawns a new value in an empty space on the board
    // 10% chance of a 4, 90% chance of a 2
    
    /*
     * spawn must be implemented using the java equivalent
     *      of the following pseudo code
     * x = 0
     * do while board[x] != 0
     *     x = Random.nextInt(board.length)
     * testVal = Random.nextDouble()
     * if testVal < 0.900
     *     board[x] = 2
     * else
     *     board[x= = 4
     */

    public boolean checkWin(StoredBoard board)
    {
        for(int x = 0; x < board.getDimension(); x++)
        {
            for(int y = 0; y < board.getDimension(); y++)
            {
                if(board.getNum(x, y) == 0)
                {
                    return false;
                }
                if(x < board.getDimension() -1 && board.getNum(x, y) == board.getNum(x+1, y))
                {
                    return false;
                }
                if(y < board.getDimension() - 1 && board.getNum(x, y) == board.getNum(x, y+1))
                {
                    return false;
                }
            }
        }
        return true;
    } 

    public void spawn(StoredBoard board)
    {
        if(board.hasZeros())
        {
            int x = 0;
            int y = 0;
            do
            {
                x = r.nextInt(board.getDimension());
                y = r.nextInt(board.getDimension());
            } while (board.getNum(x, y) != 0);
            board.setNum(x, y, (r.nextDouble() < 0.900) ? 2 : 4);
        }
    }

}