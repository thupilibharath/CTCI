/**
 * Created by Bharath on 10/1/15.
 */

import java.util.Stack;
public class InfixtoPostfix {
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
		s1.push(1);
		s1.push(2);
		s1.push(4);

		while (!s1.isEmpty())
			System.out.println(s1.pop());
	}
}
