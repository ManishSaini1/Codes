

import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();
			int at[] = new int[n];
			int dt[] = new int[n];

			for (int i = 0; i < n; i++) {
				at[i] = s.nextInt();
			}

			for (int i = 0; i < n; i++) {
				dt[i] = s.nextInt();
			}

			int minPlatforms = Solution.calculateMinPatforms(at, dt, n);
			System.out.println(minPlatforms);
			t--;
		}
	}

}