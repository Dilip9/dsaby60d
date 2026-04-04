package recursion;

import java.util.ArrayList;
import java.util.List;

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
        char[][] sudokuBoard = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},

                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},

                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        sudokuSolver(sudokuBoard);
        // Rat in a Maze problem
        // input data for maze
        int [][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        // visited array to keep track of visited cells
        boolean[][] visited = {{false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}};
        int n1 = maze.length;
        List<String> solution = new ArrayList<>();
        String path = "";;
        solveRatInMaze(maze, 0, 0, path, visited, solution);   // row=0, col=0 is the starting point of the maze
        solveRatInMazeII(maze, 0,0,path,solution);
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

    public static boolean sudokuSolver(char[][] board){
        return solveSudoku(board, 0, 0);
    }
    public static boolean solveSudoku(char[][] board, int row, int col){
        // base Case
        if(row==9){
            System.out.println("Sudoku solved successfully!");
            printBoard(board, 9);
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        // if the cell is already filled, move to the next cell
        if(board[row][col] != '.'){
            return solveSudoku(board, nextRow, nextCol);
        }
        for(char digit = '1';digit<='9';digit++){
            if(isSafeSudoku(board, row, col, digit)){
                board[row][col] =  digit;
                if(solveSudoku(board, nextRow, nextCol)){
                    return true;
                }
                // backtrack
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isSafeSudoku(char[][] board, int row, int col, char digit){
        // Horizontal
        for(int i=0;i<9;i++){
            if(board[row][i] == digit){
                return false;
            }
        }
        //vertical
        for(int i = 0;i<9;i++){
            if(board[i][col] == digit){
                return false;
            }
        }
        // 3 X 3 or grid check
        int sRow = (row/3)*3;
        int sCol = (col/3)*3;
        for(int i = sRow; i<=sRow+2; i++){
            for(int j = sCol;j<=sCol+2; j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveRatInMaze(int[][] maze, int row, int col, String path, boolean[][] visited, List<String> solution) {

        helper(maze, row, col, path, visited, solution);
    }
    public static void helper(int[][] maze, int row, int col, String path, boolean[][] visited, List<String> solution){

        int n = maze.length;  // number of rows
        int m = maze[0].length; // number of columns
        // Base case
        if( row<0 || col<0|| row >= n || col >= m || maze[row][col] == 0 || visited[row][col]){
            return;
        }
        if(row==n-1 && col == m-1){
            // print the path
            solution.add(path);
            System.out.println("Path to go to the destination ::: "+path);
            return;
        }
        visited[row][col] = true;
        // Move in all direction
        // down recursion
        helper(maze, row+1, col, path+"D", visited,solution);
        // left recursion
        helper(maze, row, col-1, path+"L", visited,solution);
        // right recursion
        helper(maze, row, col+1, path+"R", visited,solution);
        // up recursion
        helper(maze, row-1, col, path+"U", visited,solution);
        // backtrack
        visited[row][col]=false;
    }

    public static void solveRatInMazeII(int[][] maze, int row, int col, String path, List<String> solution){
        helperII(maze, row, col, path, solution);
    }
    public static void helperII(int[][] maze, int row, int col, String path, List<String> solution){
        int n = maze.length;  // number of rows
        int m = maze[0].length; // number of columns
        // Base Case
        if(row<0 || col<0 || row>=n || col>= m || maze[row][col] == 0 || maze[row][col] == -1){
            return;
        }
        if(row == n-1 && col == m-1){
            solution.add(path);
            System.out.println("Path to go to the destination in variations II ::: "+path);
            return;
        }
        maze[row][col] = -1;  // mark the cell as visited by changing its value to -1, so that we don't need a separate visited array
        // recursion cases
        // Down recursion
        helperII(maze, row+1, col, path+"D", solution);
        // Left recursion
        helperII(maze, row, col-1, path+"L", solution);
        // Right recursion
        helperII(maze, row, col+1, path+"R", solution);
        // Up recursion
        helperII(maze, row-1, col, path+"U", solution);
        maze[row][col] = 1; // backtrack by marking the cell as unvisited again
    }
}
