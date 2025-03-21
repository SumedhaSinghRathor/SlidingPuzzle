# SlidingPuzzle

## Features of the Game:
**1. Grid Puzzle Layout:**
  - A 4x4 grid contains numbered buttons (1 to 15) with one empty space, resembling a classic sliding puzzle.
  - The user can move tiles around the grid to arrange them in numerical order.

**2. Shuffling Logic:**
  - The tiles are shuffled randomly when the game starts using a shuffleArray() method to ensure every game has a unique start.

**3. User Interaction:**
  - The game responds to arrow key inputs (UP, DOWN, LEFT, RIGHT) to slide tiles.
  - Movements depend on the position of the empty space, and invalid moves are restricted.

**4. Winning Condition:**
  - The checkWinner() method verifies if the tiles are arranged sequentially from 1 to 15.

**5. Visual Design:**
  - The puzzle has a bright yellow background, pink tiles, and a white empty space.
  - Labels display the game's title and the number of attempts made by the user.

## Functional Highlights:
**- Key Listener:**
  - The game is controlled by the KeyEvent listener, which handles tile movement based on arrow key presses.
**- Dynamic Display:**
  - The puzzle updates visually with every valid move (e.g., swapping the empty space with a numbered tile).
  - The number of moves is displayed, along with congratulatory feedback upon solving the puzzle.

## Additional Notes:
- Fonts and layout are styled for clarity and aesthetic appeal.

## Usage:
To run the game:
- Compile the code, then execute the main method.
- A window will appear with the puzzle ready to solve.

It's a simple, interactive game that showcases object-oriented programming, graphical UI design, and event handling in Java!

![Project 1 - Sliding Puzzle created with Java](https://github.com/SumedhaSinghRathor/SlidingPuzzle/assets/130545882/5b8310ae-2c44-464a-8e96-eebd8bbbef49)

![Number Grid Puzzle](https://github.com/SumedhaSinghRathor/SlidingPuzzle/assets/130545882/598876b1-63a1-458b-bec3-fce5faab4b50)
