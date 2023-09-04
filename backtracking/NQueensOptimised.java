package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptimised {

    public void solve(int col,
                      int n,
                      int[] upperDiag,
                      int[] lowerDiag,
                      int[] thisRow,
                      List<List<String>> ans,
                      char[][] board ){
        if(col>=n){
            ans.add(construct(board));
            return;
        }

        for(int row=0; row<n;row++){
            if(upperDiag[row+col]!='Q' &&
                    lowerDiag[board.length-1 + (col-row)]!='Q' &&
                    thisRow[row]!='Q'
            ){
                board[row][col]='Q';
                upperDiag[row+col]='Q';
                lowerDiag[n-1 + (col-row)]='Q';
                thisRow[row]='Q';

                solve(col+1, n, upperDiag, lowerDiag, thisRow, ans, board);

                board[row][col]='.';
                upperDiag[row+col]='.';
                lowerDiag[n-1 + (col-row)]='.';
                thisRow[row]='.';
            }
        }
    }

    public List < String > construct(char[][] board){
        List<String> str1=new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            String s= new String(board[i]);
            str1.add(s);
        }
        return str1;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';

        int[] upperDiag = new int[2*n-1];
        int[] lowerDiag = new int[2*n-1];
        int[] thisRow = new int[n];

        solve(0, n, upperDiag, lowerDiag, thisRow, ans, board);
        return ans;
    }

    public static void main(String[] args) {
        NQueensOptimised queens = new NQueensOptimised();
        System.out.println(queens.solveNQueens(4));
    }
}
