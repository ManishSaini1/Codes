/* 
Time complexity: O(2^n)
Space complexity: O(n)

Where ‘n’ is the number of elements.
*/
public class Solution1 {
	static long MOD = 1000000007;

	public static long countDerangements(long n) {
		// Base conditions
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		// countDerangements(n) = (n-1)*[countDerangements(n-1)+countDerangements(n-2)]
		return ((n - 1) % MOD * (countDerangements(n - 1) % MOD + countDerangements(n - 2) % MOD) % MOD) % MOD;

	}
}
