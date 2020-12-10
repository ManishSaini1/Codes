/*
Time Complexity: O(N * M)
Space Complexity: O(N + M)

where N, M are the number of rows and columns in the grid.
*/

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int first, second;

	Pair() {

	}

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

}

public class Solution {
	public static int bfsArea(int grid[][], int i, int j, int n, int m) {
		Queue<Pair> q = new LinkedList<>();
		int area = 0;
		Pair p = new Pair(i, j);
		q.add(p);
		grid[i][j] = 0;

		// Array to traverse in 8 directions
		int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		while (q.size() != 0) {
			Pair cell = q.peek();
			q.poll();

			int x = cell.first;
			int y = cell.second;

			area++;

			for (int k = 0; k < 8; k++) {
				int newX = x + dir[k][0];
				int newY = y + dir[k][1];

				if (newX >= 0 && newY >= 0 && newX < n && newY < m && grid[newX][newY] == 1) {
					Pair temp = new Pair(newX, newY);
					q.add(temp);
					// Mark cell as 0
					grid[newX][newY] = 0;
				}
			}
		}

		return area;
	}

	public static int maxAreaOfIsland(int[][] grid, int n, int m) {

		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, bfsArea(grid, i, j, n, m));
				}
			}
		}

		return maxArea;
	}

}
