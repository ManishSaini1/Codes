/*
Time Complexity: O(3^(M*N))
Space Complexity: O(N*M)

Where N is the number of rows and M is the number of columns in the array.
*/

public class Solution {
	// Checking if the cell is valid or not.
	public static boolean isValidCell(int x, int y, int N, int M) {
		return (x < N && y < M);
	}

	public static int minCost(int[][] buildings, int x, int y, int N, int M) {
		// Base case.
		if (x == N - 1 && y == M - 1)
			return 0;

		// Finding the cost to go right from current cell.
		int rightCost = Integer.MAX_VALUE;
		if (isValidCell(x, y + 1, N, M))
			rightCost = minCost(buildings, x, y + 1, N, M) + Math.abs(buildings[x][y] - buildings[x][y + 1]);

		// Finding the cost to go down from current cell.
		int downCost = Integer.MAX_VALUE;
		if (isValidCell(x + 1, y, N, M))
			downCost = minCost(buildings, x + 1, y, N, M) + Math.abs(buildings[x][y] - buildings[x + 1][y]);

		// Finding the cost to go diagonally from current cell.
		int diagCost = Integer.MAX_VALUE;
		if (isValidCell(x + 1, y + 1, N, M))
			diagCost = minCost(buildings, x + 1, y + 1, N, M) + Math.abs(buildings[x][y] - buildings[x + 1][y + 1]);

		// return minimum jumps
		return Math.min(Math.min(downCost, rightCost), diagCost);
	}

	public static int findMinCost(int[][] buildings, int n, int m) {
		return minCost(buildings, 0, 0, n, m);

	}
}
