package games;

import java.util.Random;
import java.util.Scanner;

import utils.GameStats;
import utils.Posters;
import utils.Utils;

/**
 * Console implementation of the 2048 game.
 * Handles board state, movement, merging, and win/lose conditions.
 */
public class Game2048 {

	private static final int SIZE = 4;
	private static final int TARGET = 2048;

	private final Posters posters = new Posters();
	private final Utils utils = new Utils();
	private final Scanner inputUser = new Scanner(System.in);
	private final Random random = new Random();

	private int[][] board;

	/**
	 * Inicia el menú principal del juego 2048.
	 */
	public void start2048() {
		while (true) {
			posters.show2048Banner();
			posters.show2048Menu();

			String option = inputUser.nextLine();
			switch (option) {
				case "1" -> showInstructions();
				case "2" -> playGame();
				case "3" -> {
					return;
				}
				default -> posters.showMesageWarningMemu(inputUser);
			}
		}
	}

	/**
	 * Displays the 2048 instructions screen.
	 */
	private void showInstructions() {
		posters.show2048Instructions();
		inputUser.nextLine();
	}

	/**
	 * Runs a full 2048 session.
	 */
	private void playGame() {
		GameStats.register2048Start();
		resetBoard();
		addRandomTile();
		addRandomTile();

		while (true) {
			posters.show2048Board(board);
			posters.show2048MoveMenu();

			String move = inputUser.nextLine().trim().toLowerCase();
			if ("0".equals(move)) {
				GameStats.register2048Exit();
				return;
			}

			boolean moved = switch (move) {
				case "w" -> move(Direction.UP);
				case "a" -> move(Direction.LEFT);
				case "s" -> move(Direction.DOWN);
				case "d" -> move(Direction.RIGHT);
				default -> {
					posters.show2048InvalidMove(inputUser);
					yield false;
				}
			};

			if (moved) {
				addRandomTile();
			}

			if (hasTile(TARGET)) {
				posters.show2048Board(board);
				GameStats.register2048Win();
				posters.show2048Win(inputUser);
				return;
			}

			if (!hasAvailableMoves()) {
				posters.show2048Board(board);
				posters.show2048Lose(inputUser);
				return;
			}
		}
	}

	/**
	 * Initializes a new empty board.
	 */
	private void resetBoard() {
		utils.cleanScreem();
		board = new int[SIZE][SIZE];
	}

	/**
	 * Adds a random tile (2 or 4) to an empty cell.
	 */
	private void addRandomTile() {
		int emptyCount = countEmpty();
		if (emptyCount == 0) {
			return;
		}

		int targetIndex = random.nextInt(emptyCount);
		int counter = 0;
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (board[row][col] == 0) {
					if (counter == targetIndex) {
						board[row][col] = random.nextDouble() < 0.9 ? 2 : 4;
						return;
					}
					counter++;
				}
			}
		}
	}

	/**
	 * Counts empty cells in the board.
	 *
	 * @return number of empty cells
	 */
	private int countEmpty() {
		int count = 0;
		for (int[] row : board) {
			for (int value : row) {
				if (value == 0) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Checks if the board contains the target tile.
	 *
	 * @param target tile value
	 * @return true if present
	 */
	private boolean hasTile(int target) {
		for (int[] row : board) {
			for (int value : row) {
				if (value == target) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if there are valid moves left.
	 *
	 * @return true if a move is possible
	 */
	private boolean hasAvailableMoves() {
		if (countEmpty() > 0) {
			return true;
		}

		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				int value = board[row][col];
				if ((row + 1 < SIZE && board[row + 1][col] == value)
						|| (col + 1 < SIZE && board[row][col + 1] == value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Applies a movement in the given direction.
	 *
	 * @param direction movement direction
	 * @return true if the board changed
	 */
	private boolean move(Direction direction) {
		boolean moved = false;
		for (int index = 0; index < SIZE; index++) {
			int[] line = getLine(index, direction);
			int[] merged = mergeLine(line);
			if (!linesEqual(line, merged)) {
				moved = true;
				setLine(index, direction, merged);
			}
		}
		return moved;
	}

	/**
	 * Extracts a line from the board based on direction.
	 *
	 * @param index row/column index
	 * @param direction movement direction
	 * @return extracted line
	 */
	private int[] getLine(int index, Direction direction) {
		int[] line = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			switch (direction) {
				case LEFT -> line[i] = board[index][i];
				case RIGHT -> line[i] = board[index][SIZE - 1 - i];
				case UP -> line[i] = board[i][index];
				case DOWN -> line[i] = board[SIZE - 1 - i][index];
			}
		}
		return line;
	}

	/**
	 * Writes a line into the board based on direction.
	 *
	 * @param index row/column index
	 * @param direction movement direction
	 * @param line values to write
	 */
	private void setLine(int index, Direction direction, int[] line) {
		for (int i = 0; i < SIZE; i++) {
			switch (direction) {
				case LEFT -> board[index][i] = line[i];
				case RIGHT -> board[index][SIZE - 1 - i] = line[i];
				case UP -> board[i][index] = line[i];
				case DOWN -> board[SIZE - 1 - i][index] = line[i];
			}
		}
	}

	/**
	 * Merges a line by combining equal adjacent values.
	 *
	 * @param line input line
	 * @return merged line
	 */
	private int[] mergeLine(int[] line) {
		int[] compressed = compressLine(line);
		for (int i = 0; i < SIZE - 1; i++) {
			if (compressed[i] != 0 && compressed[i] == compressed[i + 1]) {
				compressed[i] *= 2;
				compressed[i + 1] = 0;
				i++;
			}
		}
		return compressLine(compressed);
	}

	/**
	 * Compacts a line by moving non-zero values to the front.
	 *
	 * @param line input line
	 * @return compacted line
	 */
	private int[] compressLine(int[] line) {
		int[] newLine = new int[SIZE];
		int index = 0;
		for (int value : line) {
			if (value != 0) {
				newLine[index++] = value;
			}
		}
		return newLine;
	}

	/**
	 * Compares two lines for equality.
	 *
	 * @param line first line
	 * @param merged second line
	 * @return true if equal
	 */
	private boolean linesEqual(int[] line, int[] merged) {
		for (int i = 0; i < SIZE; i++) {
			if (line[i] != merged[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Movement directions for 2048.
	 */
	private enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
}