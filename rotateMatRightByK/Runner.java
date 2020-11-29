import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void printOutput(int result[][], int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
		}
	}

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
			int k = s.nextInt();
			int mat[][] = new int[n][m];
			getInput(mat, n, m);
			int result[][] = Solution.rotateMatRight(mat, n, m, k);
			printOutput(result, n, m);
			System.out.println();

		}

	}

}
