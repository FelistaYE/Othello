# Description

This project implements the Othello board game, a strategy game for two players where the goal is to have more pieces of your color at the end of the game. Players place pieces on the board and capture opponent pieces by surrounding them in any direction (horizontal, vertical, or diagonal).

# Othello Rules

1. The game is played on an 8x8 board.
2. Each player has a piece color (white or black).
3. To place a piece, you must capture at least one opponent piece.
4. Pieces are captured by surrounding them between two of your pieces in a straight line (horizontal, vertical, or diagonal).
5. All captured pieces are flipped to your color.
6. If you cannot make any valid move, you pass your turn.
7. The game ends when no player can move.
8. The player with more pieces of their color wins.

# Requirements

- **Java Development Kit (JDK)** 11 or higher
- **ACM Java Libraries** (`acm.jar`) - **REQUIRED** ⚠️

# Installation

### 1. Clone the repository
```bash
git clone https://github.com/FelistaYE/Othello.git
cd Othello
```

### 2. Download ACM Java Libraries (REQUIRED)

Download the `acm.jar` file from one of these sources:

- **Direct link**: https://cs.stanford.edu/people/eroberts/jtf/acm.jar
- **Official website**: [Stanford ACM Java Task Force](https://cs.stanford.edu/people/eroberts/jtf/)

Place the acm.jar file in the `src` folder.

# Configuration

You can customize various aspects of the game by modifying constants in `Othello.java`:

- `APPLICATION_WIDTH` and `APPLICATION_HEIGHT`: Window size (default: 600x600)
- `BOARD_PADDING`: Space around the board (default: 0.03)
- `CELL_PADDING`: Space inside each cell (default: 0.10)
- `ORDER`: Board order (default: 4, creating an 8x8 board)

Customizable colors in `Display.java`:
- `SIDE_COLOR`: Border color (default: gray-blue - RGB(23, 32, 42))
- `CENTER_COLOR`: Board color (default: steel Blue - RGB(52, 73, 94))

# Other Languages

- [中文](README_ZH.md)

---

