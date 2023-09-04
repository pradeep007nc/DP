package backtracking;

//space n2 and time n!
public class NQueens {
    int[][] board;
    int N;
    public NQueens(int size){
        this.N = size;
        board = new int[size][size];
    }

    public boolean isSafe(int row, int col){
        int i, j;

        //check the left row of the board
        for(i=0;i<col;i++){
            if(board[row][i] == 1)
                return false;
        }

        //check upper diagonal of the board
        for (i=row,j=col; i>=0&&j>=0; i--,j--){
            if (board[i][j] == 1)
                return false;
        }

        //check lower diagonal of the board
        for (i=row,j=col; j>=0 && i<N;i++,j--){
            if (board[i][j] == 1)
                return false;
        }

        //if none of them is false then it is safe
        return true;
    }

    //recursively solve for n queens on the board
    public boolean solveNQueens(int col){

        //base case if all queens are placed
        if(col >= N)
            return true;

        //try placing queen in board one by one
        for (int i=0;i<N;i++){
            if (isSafe(i, col)){
                //place the queen
                board[i][col] = 1;

                if (solveNQueens(col+1))
                    return true;

                //if placing doesn't lead to solution
                //remove queen and backtrack
                board[i][col] = 0;
            }
        }

        //if cannot be placed
        return false;
    }

    public void printBoard(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if (board[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print("Q ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens(10);
        if (!queens.solveNQueens(0))
            System.out.println("solution is not possible");
        else
            queens.printBoard();
    }
}
