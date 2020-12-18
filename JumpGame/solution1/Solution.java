/*
Time Complexity: O(N^2)
Space Complexity: O(N*log(W)),

where N is the size of the array and W is the maximum of all elements present in the array.
*/
import java.util.HashSet;

public class Solution {

	public static int countDistinctBitwiseOR(int[] arr, int size) {
		int var = 0;
		// Set to store the distinct OR values
		HashSet<Integer> ans = new HashSet<>();
		for (int i = 0; i < size; i++) {
			var = 0;
			for (int j = i; j < size; j++) {
				var = var | arr[j];
				ans.add(var);
			}

		}

		return ans.size();

	}

}