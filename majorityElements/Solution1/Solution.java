/*
Time Complexity: O(N)
Space Complexity: O(N)

Where N is the size of array/list.
*/
import java.util.HashMap;
public class Solution {
	public static int findMajority(int n, int[] arr) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			// Storing frequency of each element
			if (!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], 1);
			} else {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			}

			if (hashMap.get(arr[i]) > n / 2) {
				return arr[i];
			}
		}

		// If no majority element found, return -1
		return -1;
	}
}
