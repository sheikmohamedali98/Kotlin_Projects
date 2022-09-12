package sudoku;

public class SudokuBusinessLogicProgram {
    static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board =
                {{7, 0, 2, 0, 5, 0, 6, 0, 0}, {0, 0, 0, 0, 0, 3, 0, 0, 0}, {1, 0, 0, 0, 0, 9, 5, 0, 0},
                        {8, 0, 0, 0, 0, 0, 0, 9, 0}, {0, 4, 3, 0, 0, 0, 7, 5, 0}, {0, 9, 0, 0, 0, 0, 0, 0, 8},
                        {0, 0, 9, 7, 0, 0, 0, 0, 5}, {0, 0, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 7, 0, 4, 0, 2, 0, 3}};
        printBoard(board);
        if(solveBoard(board)){
            System.out.println("SuccessFully");
        }else{
            System.out.println("loose");
        }

    }

    private static boolean isNumberRow(int[][] board, int row, int number) {
        for (int i = 0; i < SIZE; i++) {

            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberColumn(int[][] board, int column, int number) {
        for (int i = 0; i < SIZE; i++) {

            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInnerBox(int[][] board, int row, int column, int number) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {

                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int row, int column, int number) {

        return !isNumberRow(board, row, number) && !isNumberColumn(board, column, column) && !isNumberInnerBox(board, row, column, number);
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {

                    for (int numberToTry = 1; numberToTry <= SIZE; numberToTry++) {
                        if (isValidPlacement(board, row, col, numberToTry)) {
                            board[row][col] = numberToTry;
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------------------------");
            }
            for (int column = 0; column < SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(" " + board[row][column] + " ");

            }
            System.out.println();
        }

    }
}
