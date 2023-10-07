package prac.TicTacToe;

public class TicTacToe {

    public static void main(String[] args) {
        String[] data = {"XOX","O X","X O"};
        System.out.println(new TicTacToe().validTicTacToe(data));
    }

    public boolean validTicTacToe(String[] board) {
        char[][] game = new char[3][3];
        for(int i=0;i<3;i++){
            game[i] = board[i].toCharArray();
        }

        int[] freq = new int[2];
        for(char[] i: game){
            for(char ch: i){
                if(ch == 'X')
                    freq[0]++;
                else if(ch == 'O')
                    freq[1]++;
            }
        }

        if(freq[1] > freq[0])
            return false;

        else if(freq[1] == freq[0])
            return !checkTicTacToe(game);

        else if(freq[0] - freq[1] == 1)
            return checkTicTacToe(game);

        else
            return false;
    }

    private boolean checkTicTacToe(char[][] game){
        int row, col;
        for(int i=0;i<3;i++){
            row = 0;
            col = 0;
            for(int j=0;j<3;j++){
                if(game[i][j] == 'X')
                    row++;
                if(game[j][i] == 'X')
                    col++;
            }
            if(row == 3)
                return true;
            if(col == 3)
                return true;
        }
        return checkDiagonal(game);
    }

    private boolean checkDiagonal(char[][] game){
        int lDiag = 0, rDiag = 0;
        for(int i=0, index=0;i<3;i++, index++){
            if(game[index][i] == 'X')
                lDiag++;
            if(game[i][index] == 'X')
                rDiag++;
        }
        if(lDiag == 3)
            return true;
        if(rDiag == 3)
            return true;

        return false;
    }
}
