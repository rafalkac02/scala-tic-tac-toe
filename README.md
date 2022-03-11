# Tic-Tac-Toe

Popular Tic-tac-toe game written in Scala. The game is played between two players on a grid that's 3 squares by 3 squares. Player1 is O and Player2 is X. Player one starts the game by typing where they want to put circle.

There is a chess-like notation for each square. Each column is given a letter from A to C and each row is given number from 1 to 3.

The correct way for the players to put a mark on the grid is by typing a two-character string, i.e. "A1" for the first column and first row, "B1" for the second column and first row, etc.

The player must provide a valid square symbol (case-insensitive) - one with a valid name and not used before. Otherwise, the program will ask again for the input.

The first player to get 3 of their marks in a row (up, down, across, or diagonally) is the winner. If no one wins, the program will announce a draw after the board is fully filled.