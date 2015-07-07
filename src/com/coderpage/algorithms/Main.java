package com.coderpage.algorithms;

public class Main {
	public static void main(String[] args){
		
		testResizingArrayStack();
	}
	
	
	
	private static void testResizingArrayStack(){
		ResizingArrayStack<Object> stack = new ResizingArrayStack<>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		for (int i = 0; i < 5; i++) {
			System.out.println((int)stack.pop() == i);
		}
		
	}
}
