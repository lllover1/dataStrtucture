package stack;

import adt.SeqList;

public final class SeqStack<T> extends MyStack<T> {

	private SeqList<T> list;
	/***************************************************/
	//构造方法
	public SeqStack(int i){
		list = new SeqList<>(i);
	}
	
	public SeqStack(){
		list = new SeqList<>(64);
	}
	/****************************************************/
	//实现父类抽象方法
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(T x) {
		list.insert(x);
	}

	@Override
	public T peek() {
		return list.get(list.size()-1);
	}

	@Override
	public T pop() {
		return list.remove(list.size()-1);
	}

}
