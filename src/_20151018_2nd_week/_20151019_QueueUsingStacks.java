package _20151018_2nd_week;

import java.util.Stack;
/**I've done this problem before while solving Leetcode, here's the link: 
 * {@link _20150919_ImplementQueueUsingStacks}}*/

/**Then I also quickly looked at a related topic: how to use queues to implement stacks although MIT handout didn't mention it.
 * This time, I understand it much better! Cool!
 * It's also using a tempQueue: construct a tempQueue, add the new element into it, then traverse the old queue and add all
 * elements into the tempQueue in order, in the end, assign the tempQueue back to the original queue, at this time, the original
 * queue is the final result.*/
public class _20151019_QueueUsingStacks {
	
	/**Quickly code it up again today: 10/19/2015. cool! I made it!*/
	
	private Stack<Integer> stack;
	
	public _20151019_QueueUsingStacks(){
		this.stack = new Stack<>();
	}
	
	public void push(int n){
		stack.push(n);
	}
	
	public void pop(){
		Stack<Integer> tempStack = new Stack<Integer>();
		moveStack(stack, tempStack);
		tempStack.pop();
		moveStack(tempStack, stack);
	}
	
	private void moveStack(Stack<Integer> src, Stack<Integer> dst){
		while(!src.isEmpty()){
			dst.push(src.pop());
		}
	}
}
