/*
Time Complexity: O(N*log(W))
Space Complexity: O(N*log(W)),

where N is the size of the array and W is the maximum of all elements present in the array.
*/
import java.util.ArrayList;
import java.util.HashSet;
public class Solution {

	
	public static int countDistinctBitwiseOR(int[] arr, int n) {
		ArrayList<Integer> res=new ArrayList<>();
		HashSet<Integer> ans = new HashSet<>();
		int left = 0, right;
		for (int i = 0; i < arr.length; i++) {
			right = res.size();
			res.add(arr[i]);
			for (int j = left; j < right; ++j) {
				if (res.get(res.size() -1) != (res.get(j) | arr[i])) {
					res.add(res.get(j) | arr[i]);
				}
			}
			left = right;
		}

		for (int i = 0; i < res.size(); i++) {
			ans.add(res.get(i));
		}
		return ans.size();
	}

}
