import sudoku.SudokuBusinessLogic

fun main(args: Array<String>) {
    var board = arrayOf(intArrayOf(7,0,2,0,5,0,6,0,0), intArrayOf(0,0,0,0,0,3,0,0,0), intArrayOf(1,0,0,0,0,9,5,0,0),
        intArrayOf(8,0,0,0,0,0,0,9,0), intArrayOf(0,4,3,0,0,0,7,5,0), intArrayOf(0,9,0,0,0,0,0,0,8),
        intArrayOf(0,0,9,7,0,0,0,0,5), intArrayOf(0,0,0,2,0,0,0,0,0),intArrayOf(0,0,7,0,4,0,2,0,3))

    var sudoku: SudokuBusinessLogic = SudokuBusinessLogic()

    sudoku.printBoard(board);
    if(sudoku.solveBoard(board)){
        println("Successfull")
    }else{
        println("sorry")
    }
    sudoku.printBoard(board);
}