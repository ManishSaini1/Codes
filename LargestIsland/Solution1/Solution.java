/*
Time Complexity: O(N * M)
Space Complexity: O(N * M)

where N, M are the number of rows and columns in the grid.
*/
public class Solution {
	public static int dfsArea(int grid[][], int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0;

		int area = 1;

		// The dir array is used to call dfsArea in eight directions.
		int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		for (int k = 0; k < 8; k++) {
			area += dfsArea(grid, i + dir[k][0], j + dir[k][1], n, m);
		}

		return area;
	}

	public static int maxAreaOfIsland(int[][] grid, int n, int m) {
		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, dfsArea(grid, i, j, n, m));
				}
			}
		}

		return maxArea;

	}

}
