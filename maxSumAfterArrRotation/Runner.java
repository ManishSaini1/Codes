
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = s.nextInt(), n;
		while (tc-- > 0) {
			n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			long sol = Solution.minJumps(arr, n);
			System.out.println(sol);
		}
	}
}