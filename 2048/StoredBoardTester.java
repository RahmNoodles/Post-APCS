public class StoredBoardTester 
{
    public static void main(String[] args) 
    {
        int dim = 4;
        StoredBoard board = new StoredBoard(dim);
        if(board.getNum(1, 3) != 0)
        {
            System.out.println("Board isn't at 0");
        }
        board.setNum(1, 3, 4);
        if(board.getNum(1, 3) != 4)
        {
            System.out.println("Board.setNum is not working");
        }
        board.setNum(1, 3, -8);
        if(board.getNum(1, 3) != -8)
        {
            System.out.println("Board.setNum replacing or negative is not working");
        }
        board.setNum(0, 0, 4);
        if(board.getNum(0, 0) != 4)
        {
            System.out.println("Board isn't working at index 0, 0");
        }
        board.setNum(dim - 1, dim - 1, 4);
        if(board.getNum(dim - 1, dim - 1) != 4)
        {
            System.out.println("Board isn't working at index 3, 3");
        }
        int start = board.getNum(0, 0);
        board.addNum(0, 0, 4);
        if(board.getNum(0, 0) != start + 4)
        {
            System.out.println("Board.addNum is not working");
        }
        if(board.getDimension() != dim)
        {
            System.out.println("Board.getDimension is not working");
        }
        if(board.getScore != 0)
        {
            System.out.println("Score is not starting at 0");
        }
        board.addScore(4);
        if(board.getScore() != 4)
        {
            System.out.println("Add score or get score is not working");
        }
        System.out.println("All tests finished");
    }
}