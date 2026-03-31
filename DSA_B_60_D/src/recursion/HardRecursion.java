package recursion;

public class HardRecursion {
    public static void main(String[] args) {
        // N-Queens problem
        int n = 4;
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                board[i][j] = '.';
            }
        }
        solveNQueens(board, 0, n);
    }
    public static void solveNQueens(char[][] board, int row, int n){

        // Base Case
        if(row == n){
            // print the board
            printBoard(board, n);
            return;
        }
        for(int col = 0; col<n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                // Recursion case
                solveNQueens(board, row + 1, n);
                // Backtrack
                board[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(char[][] board, int row, int col, int n){
        // check the row
//        for(int i = 0; i<n;i++){
//            if(board[row][i] == 'Q'){
//                return false;
//            }
//        }
        // check the column
        for(int i =0; i<n;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // check the upper left diagonal
        for(int i = row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // check the upper right diagonal
        for(int i = row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board, int n){
        for(char[] ch : board){
            for(char c: ch){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        System.out.println(" -------------------");
    }
}
