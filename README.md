# Tic-Tac-Toe Game with Sound and GUI

## Overview
A simple Java-based Tic-Tac-Toe game with a graphical user interface (GUI) created using Swing. The game includes a 3x3 board, turn-based gameplay, win detection, and audio feedback for each action, including a click sound and a winning sound.

## Features
- **Grid Layout**: The game board is displayed in a 3x3 grid using `JButton`s.
- **Turn Tracking**: Players alternate between 'X' and 'O'.
- **Sound Feedback**: Audio cues (click and win) are played during interactions.
- **Winner Detection**: The game checks for a winner after every move and displays a message when a player wins.
- **Game Reset**: The board resets after a winner is declared.

## Key Components
- **TicTacToeFrame**: The main JFrame containing the game board and turn label.
- **Game Logic**: Managed in the `TicTacToe` class (not shown here), which tracks moves and checks for a win.
- **Sound Playback**: Utilizes `javax.sound.sampled` to play sound effects when a player clicks a button or wins.

## How It Works
- The `TicTacToeFrame` extends `JFrame` and uses a `GridLayout` for the board.
- A `ButtonClickListener` class listens for button presses, updates the board, alternates turns, and checks for a winner.
- The `playSound` method is used to play the associated sound effects when a button is clicked or when a player wins.

## Requirements
- Java Development Kit (JDK)
- Sound files (`click.wav` and `winning.wav`) in the project folder

## Installation
1. Clone the repository:
   git clone https://github.com/akshat-dimri/tic-tac-toe.git
