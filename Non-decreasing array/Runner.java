import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases > 0) {
			int n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			if (Solution.isPossible(arr, n)) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
			testCases--;
		}
	}

}
