
import java.util.LinkedList;
import java.util.Queue;

/*
Time complexity: O(Q*N); For each push operation O(N); O(1) for all other operations
Space complexity: O(N)

where Q is the number of queries, N denotes the maximum number of elements in the queue.
*/
public class Stack {
	public Queue<Integer> q1;

	public Stack() {
		this.q1 = new LinkedList<>();
	}

	public int getSize() {
		return this.q1.size(); // Return the size of the queue 'q1'
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public void push(int data) {
		int size = this.getSize();
		this.q1.add(data);
		for (int i = 0; i < size; i++) // Make the new data front of the queue.
		{
			this.q1.add(this.q1.peek());
			this.q1.poll();
		}

	}

	public int pop() {
		if (isEmpty()) { // If empty, return -1.
			return -1;
		}
		int ans = this.q1.peek(); // Simply dequeue from the queue q1.
		this.q1.poll();
		return ans;
	}

	int top() {
		if (isEmpty()) {
			return -1;
		}

		int ans = this.q1.peek();

		return ans;
	}
}
