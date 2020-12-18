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
			System.out.println(Solution.countDistinctBitwiseOR(arr, n));
		}
	}

}
