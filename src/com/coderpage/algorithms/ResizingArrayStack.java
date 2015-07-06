package com.coderpage.algorithms;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1]; // 栈元素
	private int N = 0; // 元素数量

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		if (N == a.length) {
			resizei(2 * a.length);
			a[N++] = item;
		}
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4) {
			resizei(a.length / 2);
		}
		return item;
	}

	private void resizei(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
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
			return a[i--];
		}

		public void remove() {

		}
	}
}
