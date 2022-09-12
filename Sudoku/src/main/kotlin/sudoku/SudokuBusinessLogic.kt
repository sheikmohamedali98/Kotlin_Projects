package sudoku

/*


7 0 2 |0 5 0 |6 0 0
0 0 0 |0 0 3 |0 0 0
1 0 0 |0 0 9 |5 0 0
--------------------
8 0 0 |0 0 0 |0 9 0
0 4 3 |0 0 0 |7 5 0
0 9 0 |0 0 0 |0 0 8
--------------------
0 0 9 |7 0 0 |0 0 5
0 0 0 |2 0 0 |0 0 0
0 0 7 |0 4 0 |2 0 3
Successfull
7 3 2 |4 5 8 |6 1 9
9 5 6 |1 7 3 |8 2 4
1 8 4 |6 2 9 |5 3 7
--------------------
8 7 1 |5 6 4 |3 9 2
6 4 3 |8 9 2 |7 5 1
2 9 5 |3 1 7 |4 6 8
--------------------
3 2 9 |7 8 6 |1 4 5
4 1 8 |2 3 5 |9 7 6
5 6 7 |9 4 1 |2 8 3
 */
open class SudokuBusinessLogic {
    val SIZE: Int = 9;

    public fun isNumberInRow(board: Array<IntArray>, row: Int, number: Int): Boolean {
        for (i in 0 until SIZE) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public fun isNumberInColumn(board: Array<IntArray>, column: Int, number: Int): Boolean {
        for (i in 0 until SIZE) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    public fun inNumberBox(board: Array<IntArray>, number: Int, row: Int, column: Int): Boolean {
        var localBoxRow: Int = row - row % 3;
        var localBoxColumn: Int = column - column % 3;
        for (i in localBoxRow until localBoxRow.plus(3)) {
            for (j in localBoxColumn until localBoxColumn.plus(3)) {
                if (board[i][j] == number) {
                    return true
                }
            }
        }
        return false;
    }

    public fun validatePlacement(board: Array<IntArray>,row:Int,column:Int,number:Int):Boolean{
        return !isNumberInRow(board,row,number)&&!isNumberInColumn(board, column,number)&&!inNumberBox(board,number,row,column)
    }

    public fun solveBoard(board: Array<IntArray>):Boolean{
        for(row in 0 until SIZE){
            for( column in 0 until SIZE){
                if(board[row][column] == 0){
                    for(newNumber in 1 ..SIZE){
                        if(validatePlacement(board,row,column,newNumber)){
                            board[row][column] = newNumber
                            if(solveBoard(board)){
                                return true;
                            }else{
                                board[row][column] = 0
                            }
                        }
                    }
                    return false;
                }//if number 0
            }//inner for
        }//outer for
        return true;
    }

    public fun printBoard(board: Array<IntArray>) {
        for (row in 0 until SIZE) {
            if (row % 3 == 0 && row != 0) {
                println("--------------------")
            }
            for (col in 0 until SIZE) {
                if (col % 3 == 0 && col != 0) {
                    print("|")
                }
                print("${board[row][col]} ")
            }
            println()
        }
    }
}
