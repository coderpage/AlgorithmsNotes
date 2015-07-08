package com.coderpage.algorithms;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] stack = (Item[]) new Object[1]; // 栈元素
	private int N = 0; // 元素数量

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		if (N == stack.length) {
			resize(2 * stack.length);
		}
		stack[N++] = item;
	}

	public Item pop() {
		if (N == 0) {
			throw new IllegalStateException("已经没有元素了");
		}
		Item item = stack[--N];
		stack[N] = null;
		if (N > 0 && N == stack.length / 4) {
			resize(stack.length / 2);
		}
		return item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null) {
				temp[i] = stack[i];
			}
		}
		stack = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ResizingArrayStackIterator();
	}

	private class ResizingArrayStackIterator implements Iterator<Item> {

		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return stack[i--];
		}

		public void remove() {

		}
	}
}
