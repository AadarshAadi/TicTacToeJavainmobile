# Tic-Tac-Toe Game

This is a simple Tic-Tac-Toe game implemented in Android Studio. The game allows two players to take turns marking spaces in a 3x3 grid, and checks for a winner after each move.

## Features

- Two-player mode
- Dynamic grid layout for the game board
- Alternating turns between players (X and O)
- Game automatically resets after 3 moves per player
- Checks for a winner after each move
- Dialog box showing the winner and options to start a new game or quit

## Installation

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Code Explanation

### Main Activity

The main activity `Main` extends `AppCompatActivity` and contains the game logic and UI components.

- **Variables:**
  - `xTurn`: Boolean to track whose turn it is (X or O).
  - `xButtons`: Queue to keep track of X buttons.
  - `oButtons`: Queue to keep track of O buttons.
  - `buttons`: 2D array to store the button references.

- **onCreate Method:**
  - Initializes the game board by creating buttons dynamically.
  - Sets click listeners for each button to handle the game logic.

- **checkWinner Method:**
  - Checks rows, columns, and diagonals for a winning combination.

- **checkLine Method:**
  - Helper method to check if three buttons in a line have the same text.

- **showWinnerDialog Method:**
  - Displays a dialog box when a player wins, with options to start a new game or quit.

- **resetGame Method:**
  - Resets the game board and variables for a new game.

- **closeApp Method:**
  - Handles the close button click to finish the activity and close the app.

### Layout File

The layout file `activity_main.xml` should contain a `GridLayout` with an ID of `gridLayout`.

## Usage

1. Run the app on an emulator or physical device.
2. Players take turns clicking on the grid to mark X or O.
3. The game checks for a winner after each move.
4. If a player wins, a dialog box appears with options to start a new game or quit.

## Contributing

Feel free to fork this repository and contribute by submitting pull requests. Any improvements or bug fixes are welcome.
