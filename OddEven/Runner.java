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
			arr = Solution.countEvenOdd(arr, n);
			System.out.println(arr[0] + " " + arr[1]);

			testCases--;
		}
	}

}
//2
//5
//4 5 1 2 1
//4
//2 1 2 1
