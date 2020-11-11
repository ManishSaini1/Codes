
/*
    Time Complexity - O(N)
    Space Complexity - O(N)

    where N is the size of the given array.
*/
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static int[] countEvenOdd(int[] arr, int n) {
		HashMap<Integer, Integer> frequency = new HashMap<>();
		int odd = 0, even = 0;
		for (int i = 0; i < n; i++) {
			if (frequency.containsKey(arr[i])) {
				frequency.put(arr[i], frequency.get(arr[i]) + 1);
			} else {
				frequency.put(arr[i], 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<>(frequency.keySet());
		for (int val : list) {
			int value = frequency.get(val);

			if (value % 2 == 1) {
				odd += 1;
			} else {
				even += 1;
			}
		}

		return new int[] { odd, even };
	}

}
