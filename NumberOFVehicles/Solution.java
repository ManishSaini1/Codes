/*
Time Complexity: O(1)
Space Complexity: O(1)
*/
public class Solution {

	public static int numberOfVehicles(int distinctCount, char alpha1, char alpha2, char alpha3, char alpha4, int dig1,
			int dig2, int dig3, int dig4) {
		int possibilities = 1;
		possibilities *= (distinctCount) * (alpha2 - alpha1 + 1) * (alpha4 - alpha3 + 1) * (dig1 + 1) * (dig2 + 1)
				* (dig3 + 1) * (dig4 + 1);
		return possibilities;
	}

}
