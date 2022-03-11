import scala.io.StdIn.readLine
import scala.sys.exit

class MyTicTacToe {

  val symbols = List("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
  val x_o = List('X', 'O')

  def printRules(): Unit = {
    println("RULES:")
    println("The game is played on a 3x3 grid")
    println("Player1 is O, Player2 is X. Player one starts.")
    println("Each column is given a letter (A-C) and each row is given a number (1-3)")
    println("To make a move, players type two-character string with column and row index ('A1', 'B3', 'C2' etc.)")
    println("The game ends when someone wins or the board is fully filled.")
    println()
  }

  def printGrid(grid: Array[Array[Char]]): Unit = {
    def printRow() = println(s"${"-" * 16}")

    println("   | A | B | C |")
    for (i <- 0 to 2) {
      printRow()
      print(s" ${i+1} ")
      for (j <- 0 to 2) {
        print(s"| ${grid(i)(j)} ")
      }
      println("|")
    }
  }

  // create Array 3x3
  def initialGrid() = {
    var grid = Array.ofDim[Char](3, 3)
    for(i <- 0 to 2)
      for(j <- 0 to 2)
        {
          grid(i)(j) = ' '
        }
    grid
  }

  // get the column and a row from strings like "A2"
  // ascii code: A, B, C  -  65, 66, 67
  // column
  def myI(sign: String): Int = {
    val i = sign(1).toString.toInt - 1
    i
  }
  //row
  def myJ(sign: String): Int =
  {
    val j = sign(0).toUpper.toInt - 65
    j
  }

  // check for availability
  def validSign(square: String, grid: Array[Array[Char]]): Boolean = {
    // valid square name && blank square
    if (symbols.contains(square.toUpperCase()) && grid(myI(square))(myJ(square)) == ' ') true
    else false
  }

  // Input position to put symbol in and update array
  def enterSign(grid: Array[Array[Char]], square: String, symbol: Char)  = {
    grid(myI(square))(myJ(square)) = symbol.toUpper   // case insensitive
    grid
  }

  // Make a move ensuring that user provided valid symbol and position
  def move(grid: Array[Array[Char]], n: Int) = {
    var symbol = '0'
    if (n == 2) symbol = 'X'

    var square = readLine(s"Player$n ('$symbol'), type position: ")

    while (!(validSign(square, grid))) {
      println("Invalid position. Try again: ")
      square = readLine(s"Player$n ('$symbol'): ")
    }

    if (n == 1) enterSign(grid, square, 'O')
    else enterSign(grid, square, 'X')

    printGrid(grid)
  }

  // Check if a player won
  def gameWon(grid: Array[Array[Char]]): Boolean = {
    for (x <- 0 to 2) {
      // columns
      if (grid(x)(0) == grid(x)(1) && grid(x)(1) == grid(x)(2) && grid(x)(2) != ' ') {
        return true
      }
      // rows
      else if (grid(0)(x) == grid(1)(x) && grid(1)(x) == grid(2)(x) && grid(2)(x) != ' ') {
        return true
      }
    }
    // diagonals
    if (grid(0)(0) == grid(1)(1) && grid(1)(1) == grid(2)(2) && grid(2)(2) != ' ') {
      return true
    }
    else if (grid(2)(0) == grid(1)(1) && grid(1)(1) == grid(0)(2) && grid(0)(2) != ' ') {
      return true
    }

    false
  }


  // Look for unfilled cell
  def isGameFinished(grid: Array[Array[Char]]): Boolean = {
    for(i <- 0 to 2) {
      for(j <- 0 to 2) {
        if (grid(i)(j) == ' ') return false
      }
    }
    true
  }

}