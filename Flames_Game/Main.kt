package Flames_Game
import  Flames_Game.Flames;
import java.util.Scanner

fun main(args:Array<String>){
    var flam:Flames = Flames()

    var scan:Scanner = Scanner(System.`in`)
    println("Enter  Boy Name ")
    var name1:String = scan.nextLine()
    println("Enter girl name ")
    var name2:String = scan.nextLine()


    flam.flame(name1,name2)

}