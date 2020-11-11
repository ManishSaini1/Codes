import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(Solution.distinctLeft(arr, n, k));
			testCases--;
		}
	}

}