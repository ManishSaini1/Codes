
/*
 * Time Complexity - O(9^K) Space Complexity - O(1)
 * 
 * where K is the number of empty cells in the sudoku
 */
import java.util.HashMap;

public class Solution {

	public static boolean isSudokuValid(int arr[][]) {
		// check for any repeating number in each of the rows.
		for (int i = 0; i < arr.length; i++) {
			if (isAnyNumberRepeating(arr, i, 0, i, 8))
				return false;
		}

		// check for any repeating number in each of the columns.
		for (int j = 0; j < arr.length; j++) {
			if (isAnyNumberRepeating(arr, 0, j, 8, j))
				return false;
		}

		// check for any repeating number in each 3X3 square grid
		for (int i = 0; i + 2 < 9; i += 3) {
			for (int j = 0; j + 2 < 9; j += 3) {
				if (isAnyNumberRepeating(arr, i, j, i + 2, j + 2))
					return false;
			}
		}

		return true;
	}

	public static boolean isAnyNumberRepeating(int arr[][], int rowStart, int colStart, int rowEnd, int colEnd) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				if (arr[i][j] != 0 && map.get(arr[i][j]) != null)
					return true;

				map.put(arr[i][j], true);
			}
		}

		return false;
	}

	public static boolean bruteForce(int sudoku[][], int i, int j) {
		if (j == 9) {
			if (i == 8) {
				if (isSudokuValid(sudoku)) {
					return true;
				}
				return false;
			}

			j = 0;
			i++;
		}

		if (sudoku[i][j] != 0) {
			return bruteForce(sudoku, i, j + 1);
		}
		for (int put = 1; put <= 9; put++) {

			sudoku[i][j] = put;

			if (bruteForce(sudoku, i, j + 1)) {
				return true;
			}

			sudoku[i][j] = 0;
		}
		return false;
	}

	public static void solveSudoku(int sudoku[][]) {
		bruteForce(sudoku, 0, 0);
		return;
	}
}
