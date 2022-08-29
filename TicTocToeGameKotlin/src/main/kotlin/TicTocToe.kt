import java.util.LinkedList
import java.util.Scanner
import kotlin.random.Random as Random

class TicTocToe {
     companion object {
         var playerList = ArrayList<Int>()
         var cpuList = ArrayList<Int>()
     fun printBoard(board: Array<CharArray>) {
         for (row in board) {
             for (ch in row) {
                 print(ch)
             }
             println()
         }
     }
         fun placePosition(board: Array<CharArray>,position:Int,Player:String){

             var symbol:Char = ' '
             if(Player.equals("player")){
                 symbol = 'X'
                 playerList.add(position)
             }else if(Player.equals("cpu")){
                 symbol = 'O';
                 cpuList.add(position)
             }
             when (position){
                 1->board[0][0] = symbol
                 2->board[0][2] = symbol
                 3->board[0][4] = symbol
                 4->board[2][0] = symbol
                 5->board[2][2] = symbol
                 6->board[2][4] = symbol
                 7->board[4][0] = symbol
                 8->board[4][2] = symbol
                 9->board[4][4] = symbol
             }
         }

         fun checkWinner():String{
             var topRow:List<Int> = listOf(1,2,3)
             var midRow:List<Int> = listOf(4,5,6)
             var botRow:List<Int> = listOf(7,8,9)
             var leftCol:List<Int> = listOf(1,4,7)
             var midCol:List<Int> = listOf(2,5,8)
             var rightCol:List<Int> = listOf(3,6,9)
             var cross1:List<Int> = listOf(1,5,9)
             var cross2:List<Int> = listOf(3,5,7)

             var winner = ArrayList<List<Int>>()
             winner.add(topRow)
             winner.add(midRow)
             winner.add(botRow)
             winner.add(leftCol)
             winner.add(midCol)
             winner.add(rightCol)
             winner.add(cross1)
             winner.add(cross2)

             for(list in winner){
                 if(playerList.containsAll(list)){
                     return "Congrajulation"

                 }else if(cpuList.containsAll(list)){
                     return "cpu win!better luck next time"
                 }else if (playerList.size+ cpuList.size == 9){
                     return "match is Draw"
                 }
             }

             return ""
         }

 }
}

fun main(args:Array<String>){
    var board :Array<CharArray> = arrayOf(charArrayOf(' ','|',' ','|',' '),
        charArrayOf('-','+','-','+','-'),
        charArrayOf(' ','|',' ','|',' '),
        charArrayOf('-','+','-','+','-'),
        charArrayOf(' ','|',' ','|',' '),)
    var scan = Scanner(System.`in`)
 TicTocToe.printBoard(board)
    while (true) {
        println("Enter the Position")
        var position: Int = scan.nextInt()
while(TicTocToe.playerList.contains(position)||TicTocToe.cpuList.contains(position)){
   println("Position Already Taken")
    println("Enter the Position")
    position = scan.nextInt()
}
        TicTocToe.placePosition(board, position, "player")

        var result:String = TicTocToe.checkWinner();

        var random = Random.nextInt(10);
//    var cpuPosition:Int = random.nextInt(10);
        while(TicTocToe.playerList.contains(random)||TicTocToe.cpuList.contains(random)){
             random = Random.nextInt(10);
        }
        TicTocToe.placePosition(board, random, "cpu")
        TicTocToe.printBoard(board)
        result = TicTocToe.checkWinner()
        if(result.length>0){
            println(result)
            break;
        }

    }

}