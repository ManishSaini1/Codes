
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = s.nextInt();
		while (tc-- > 0) {
			int N = s.nextInt(), M = s.nextInt();

			int mat[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					mat[i][j] = s.nextInt();
				}

			}

			int ans = Solution.maximalAreaOfSubMatrixOfAll1(mat, N, M);
			System.out.println(ans);
		}

	}
}
