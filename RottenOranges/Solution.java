/*
Time Complexity - O(N*M)
Space Complexity - O(N*M)

where N and M are the number of rows and columns of
the grid respectively.
*/
import java.util.LinkedList;
import java.util.Queue;
class Pair {
	int first, second;

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Solution {
	static boolean isValid(boolean visited[][], int i, int j, int n, int m) {
		return i >= 0 && i < n && j >= 0 && j < m && visited[i][j] == false;
	}

	// BFS solution
	public static int minTimeToRot(int[][] grid, int n, int m) {
		int time = 0;
		// 2d array to mark visited cells
		boolean visited[][] = new boolean[n][m];
		// Queue for BFS
		Queue<Pair> queue = new LinkedList<>();
		// Push all the rotten oranges into the queue as level 0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}
		int i, j;
		// Array for exploring all 4 directions
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (queue.size() > 0) {
			// Current level size
			int levelSize = queue.size();
			while (levelSize > 0) {
				Pair currCell = queue.remove();
				i = currCell.first;
				j = currCell.second;
				// Check all adjacent cells and push them in queue, if fresh and valid
				for (int k = 0; k < 4; k++) {
					int nextI = i + dx[k];
					int nextJ = j + dy[k];

					if (isValid(visited, nextI, nextJ, n, m) && grid[nextI][nextJ] == 1) {
						queue.offer(new Pair(nextI, nextJ));
						visited[nextI][nextJ] = true;
					}
				}
				levelSize--;
			}
			// increment time for next level
			time++;
		}
		// If a fresh orange is still present, return -1
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (grid[i][j] == 1 && visited[i][j] == false) {
					return -1;
				}
			}
		}
		return Math.max(0, time - 1);

	}

}
