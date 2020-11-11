import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int m = s.nextInt();
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		System.out.println(Solution.minTimeToRot(matrix, n, m));

	}

}
