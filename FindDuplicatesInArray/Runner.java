
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}

			ArrayList<Integer> ans = Solution.findDuplicates(arr, n);
			if (ans.size() == 0) {
				System.out.print("-1");
			} else {
				Collections.sort(ans);
				for (int x : ans) {
					System.out.print(x + " ");
				}
			}
			System.out.println();
		}

	}
}