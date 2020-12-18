import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases-- > 0) {
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			int arr[] = Solution.swapNumber(num1, num2);
			System.out.println(arr[0] + " " + arr[1]);

		}
	}
}
