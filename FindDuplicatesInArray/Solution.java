
/*
Time Complexity: O(N)
Space Complexity: O(1)

Where N is the size of the array.
*/
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> findDuplicates(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();

		// Incrementing all the values by n.
		for (int i = 0; i < n; i++) {
			arr[arr[i] % n] += n;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] >= 2 * n) {
				ans.add(i);
			}
		}

		return ans;
	}

}
