package stack;

import adt.LinkedList;

public class LinkedStack<T> extends MyStack<T>{

	private LinkedList<T> list;
	
	/***************************************************/
	//构造方法
    public LinkedStack() {
    	list = new LinkedList<T>();
	}
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(T x) {
		list.insert(0, x);
	}

	@Override
	public T peek() {
		return list.get(0);
	}

	@Override
	public T pop() {
		return list.remove(0);
	}

}
