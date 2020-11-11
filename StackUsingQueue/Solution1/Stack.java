
import java.util.LinkedList;
import java.util.Queue;

/*
Time complexity: O(Q*N); For each push operation O(N); O(1) for all other operations
Space complexity: O(N)

where Q is the number of queries, N denotes the maximum number of elements in the queue.
*/
public class Stack {
	public Queue<Integer> q1;
	public Queue<Integer> q2;

	public Stack() {
		this.q1 = new LinkedList<>();
		this.q2 = new LinkedList<>();
	}

	public int getSize() {
		return this.q1.size(); // Return the size of the queue 'q1'
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public void push(int data) {// Simply enqueue data to q1

		this.q1.add(data);

	}

	public int pop() {
		if (isEmpty()) { // If empty, return -1.
			return -1;
		}
		while (this.q1.size() > 1) { // Enqueue all the elements of q1 into q2 except the last one.
			this.q2.add(this.q1.peek());
			this.q1.poll();
		}

		int ans = this.q1.peek(); // Last element of q1 is our answer.
		this.q1.poll();

		Queue<Integer> temp = q1; // Swap q1 and q2.
		q1 = q2;
		q2 = temp;

		return ans;
	}

	int top() {
		if (isEmpty()) {
			return -1;
		}
		while (this.q1.size() > 1) { // Enqueue all the elements of q1 into q2 except the last one.
			this.q2.add(this.q1.peek());
			this.q1.poll();
		}

		int ans = this.q1.peek(); // Last element of q1 is our answer.
		this.q1.poll();
		this.q2.add(ans); // Enqueue the top to q2.

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;

		return ans;
	}
}
