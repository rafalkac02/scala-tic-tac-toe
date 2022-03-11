import scala.sys.exit

object TTT extends App {

  val ticTacToe = new MyTicTacToe
  ticTacToe.printRules()

  var myGrid = ticTacToe.initialGrid()
  var counter = 0
  while (true) {
    // Player1's move
    ticTacToe.move(myGrid, 1)
    counter = counter + 1
    if (ticTacToe.gameWon(myGrid)) {
      println("Player1 won. Congrats!")
      exit()
    }
    else if (counter == 9) {
      println("It's a draw. Game over!")
      exit()
    }

    // Player2's move
    ticTacToe.move(myGrid, 2)
    counter = counter + 1
    if (ticTacToe.gameWon(myGrid)) {
      println("Player2 won. Congrats!")
      exit()
    }
  }
}