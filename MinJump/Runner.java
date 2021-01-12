import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int arr[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			int cost = Solution.findMinCost(arr, n, m);
			System.out.println(cost);
		}

	}

}
