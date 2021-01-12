
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			Solution.mergeSort(arr, n);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}
