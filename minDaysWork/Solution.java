
/*
Time complexity: O(n* log(n))
Space complexity: O(n)

Where 'n' is the number of works
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pair {
	int first;
	int second;

	Pair() {
	}

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Solution {

	public static int minDaysWork(int[] D1, int[] D2) {
		int ans = 0;
		// Vector to store the pair of D1(i) and D2(i)
		ArrayList<Pair> combined = new ArrayList<>(D1.length);

		for (int i = 0; i < D1.length; i++) {
			combined.add(new Pair(D1[i], D2[i]));
		}
		Collections.sort(combined, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.first < p2.first) {
					return 1;
				} else if (p1.first < p2.first) {
					return -1;
				} else
					return 0;

			}
		});
//		    Collections.sort((List<T>) combined);
//		    sort(combined.begin(), combined.end());  // Sort the array
		for (int i = 0; i < D1.length; i++) {
			if (combined.get(i).second >= ans) {
				ans = combined.get(i).second;
			} else {
				ans = combined.get(i).first;
			}
		}

		return ans;

	}

}
