#### Battleship
We make a one player game where the computer places the ships, and the user attempts to sink them.

The ship fleet is as follows:
* One battleship
* Two cruisers
* Three destroyers
* Four submarines

#### Gameplay
1. We play on a 10 by 10 grid.
2. The computer places the 10 ships making sure no ships are immediately adjacent to each other (not horizontally, vertically
diagonally adjacent). The user would not be aware of the ship placement locations.
3. The user attempts to hit the ships by "calling" a row and column position, at which the computer responds with either
   the attempt was a "hit" or a "miss".
4. When a ship is sunk the message "you sank a ship!" is printed.
5. A ships is sunk when all the cells the ship occupies are struck.
   * A battleship occupies 4 cells
   * A cruiser occupies 3 cells
   * A destroyer occupies 2 cells
   * A submarine occupies 1 cell. 

#### Reference/Resource
https://github.com/qinqinzhao/Battleship
