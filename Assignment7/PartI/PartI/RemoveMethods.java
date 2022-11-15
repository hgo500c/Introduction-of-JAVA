package PartI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoveMethods {

	public static void remAllStack(Stack<Object> stack, Object item) {
        Stack<Object> temp = new Stack<Object>();  // this is the temp stack I can push in 
        while (!stack.isEmpty()) {
                        Object ex = stack.pop();
                        if (!ex.equals(item)) {  //if the new one is not the item We want to remove 
                              temp.push(ex);  //push that in 
                        }
                  }
        while (!temp.isEmpty()) {
        	Object tempo = temp.pop();
                        stack.push(tempo); //put that back to the stack we need. 

        }

}
	
	public static void remAllQueue(Queue<Object> queue, Object item) {
		Queue<Object> temp = new LinkedList<Object>();
		while(!queue.isEmpty())
		{
		Object a=queue.remove();
		if(!a.equals(item))
		temp.add(a);
		}  // this is the same 
		while(!temp.isEmpty())
		{
		queue.add((Integer)temp.remove());
		}
		}
         
	
	
	public static void main(String[] args) {
		Stack<Object> stk = new Stack<Object>();
		stk.push(new Integer(24));
		stk.push(new Integer(2));
		stk.push(new Integer(9));
		stk.push(new Integer(2));
		stk.push(new Integer(7));
		stk.push(new Integer(10));
		stk.push(new Integer(16));
		System.out.println("begin: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(2));
		System.out.println("end: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(24));
		System.out.println("end: stk is " + stk);
		
		Queue<Object> q = new LinkedList<Object>(); // you should probably find a concrete class for this
		q.offer(new Integer(24));
		q.offer(new Integer(2));
		q.offer(new Integer(9));
		q.offer(new Integer(2));
		q.offer(new Integer(7));
		q.offer(new Integer(10));
		q.offer(new Integer(16));
		System.out.println("begin: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(2));
		System.out.println("end: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(24));
		System.out.println("end: q is " + q);
		
	}
}
