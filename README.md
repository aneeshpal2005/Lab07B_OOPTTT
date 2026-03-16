# Lab07B_OOPTTT - Object Oriented Tic-Tac-Toe

Object-oriented Tic-Tac-Toe game built with Java Swing.

## Overview

This project implements a 3x3 Tic-Tac-Toe game using a simple MVC-style structure:
- Model: game state and rules
- View: Swing UI frame and tile buttons
- Controller: move handling, win/tie flow, replay/quit prompts

## Features

- Two-player local gameplay (X and O)
- Illegal move detection
- Win and tie detection
- Replay prompt after game end
- Quit confirmation dialog

## Project Structure

- `src/TTTRunner.java` - Program entry point (`main`)
- `src/TicTacToeFrame.java` - Main Swing window and board UI
- `src/TTTController.java` - Handles button clicks and game flow
- `src/TTTGame.java` - Core game logic
- `src/TTTBoard.java` - Board data structure and board utilities
- `src/TTTTileButton.java` - Custom tile button class
- `src/MoveResult.java` - Move outcome enum

## Requirements

- Java JDK 8 or later

## Compile and Run (Command Line)

From the project root:

```bash
javac src/*.java
java -cp src TTTRunner
```

## Run in IntelliJ IDEA

1. Open the project folder.
2. Use `TTTRunner` as the run configuration main class.
3. Run the configuration.

## Notes

- No external libraries are required.
- Source files are in the default package.
