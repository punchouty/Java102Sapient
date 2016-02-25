package day2;

import java.util.Iterator;

public class Bag<E> implements Iterable<E> {
	
	private final Object[] array;
	private final int size;
	private int cursor = 0;
	
	public Bag(int size) {
		this.size = size;
		array = new Object[size];
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean add(E e) {
		if(cursor < size) {
			array[cursor] = e;
			cursor++;
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if(i >= size) {
			throw new IndexOutOfBoundsException("Size : " + size);
		}
		else {
			return (E) array[i];
		}
	}
	
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<E>{
		
		private int cursorInternal = 0;

		@Override
		public boolean hasNext() {
			return cursorInternal < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (cursorInternal < size) {
				E e = (E)array[cursorInternal];
				cursorInternal++;
				return e;
			}
			else {
				throw new IllegalStateException();
			}
		}
		
	}
	
	public static <T> T getMiddle(Bag<T> bag) {
		return bag.get(bag.getSize()/2);
	}

	public static void main(String[] args) {
		Bag<String> bag = new Bag<>(3);
		System.out.println(bag.add("Rajan"));
		System.out.println(bag.add("Punchouty"));
		System.out.println(bag.add("Another Name"));
		System.out.println(bag.add("Another"));
		System.out.println(bag.get(1));
		for (String string : bag) {
			System.out.println(string);
		}
		try {
			System.out.println(bag.get(7));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Bag.getMiddle(bag));
	}

}
