import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void getInput(int arr[][], int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.nextInt();
			}
		}
	}

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int grid[][] = new int[n][m];
			getInput(grid, n, m);
			int result = Solution.maxAreaOfIsland(grid, n, m);
			System.out.println(result);

		}

	}

}
