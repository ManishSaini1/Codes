/*
    Time Complexity - O(9^K)
    Space Complexity - O(1)

    where K is the number of empty cells in the sudoku
*/

public class Solution {

	public static void solveSudoku(int[][] sudoku) {
		backTrack(sudoku, 0, 0);
		return;

	}

	private static boolean backTrack(int[][] sudoku, int i, int j) {
		if (j == 9) {
			if (i == 8) {
				return true;
			}
			j = 0;
			i++;
		}
		if (sudoku[i][j] != 0) {
			return backTrack(sudoku, i, j + 1);
		}
		for (int put = 1; put <= 9; put++) {
			if (canPut(sudoku, i, j, put)) {
				sudoku[i][j] = put;
				if (backTrack(sudoku, i, j + 1)) {
					return true;
				}
				sudoku[i][j] = 0;
			}
		}
		return false;

	}

	private static boolean canPut(int[][] sudoku, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == num || sudoku[row][i] == num) {
				return false;
			}
			if (sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
				return false;
			}
		}
		return true;
	}

}
