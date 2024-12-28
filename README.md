# Tic-Tac-Toe Game (GUI)

## Overview
A simple Java-based Tic-Tac-Toe game with a graphical user interface (GUI) created using Swing. The game includes a 3x3 board, turn-based gameplay, win detection, and a game reset feature.

## Features
- **Grid Layout**: The game board is displayed in a 3x3 grid using `JButton`s.
- **Turn Tracking**: Players alternate between 'X' and 'O'.
- **Winner Detection**: The game checks for a winner after every move and displays a message when a player wins.
- **Game Reset**: The board resets after a winner is declared.

## Key Components
- **TicTacToeFrame**: The main `JFrame` containing the game board and turn label.
- **Game Logic**: Managed in the `TicTacToe` class (not shown here), which tracks moves and checks for a win.

## How It Works
- The `TicTacToeFrame` extends `JFrame` and uses a `GridLayout` for the board.
- A `ButtonClickListener` class listens for button presses, updates the board, alternates turns, and checks for a winner.

## Requirements
- Java Development Kit (JDK)

## Installation
1. Clone the repository:  
   `git clone https://github.com/akshat-dimri/tic-tac-toe.git`  
2. Compile and run the program in your preferred IDE or terminal.  

## Usage
1. Launch the program.
2. Players take turns clicking buttons on the board to place their mark ('X' or 'O').
3. When a player wins, a message displays the winner, and the game resets automatically.
