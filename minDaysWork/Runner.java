import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int d1[] = new int[n];
			int d2[] = new int[n];
			for (int i = 0; i < n; i++) {
				d1[i] = s.nextInt();
			}
			for (int i = 0; i < n; i++) {
				d2[i] = s.nextInt();
			}
			System.out.println(Solution.minDaysWork(n,d1, d2));
		}
	}
}
