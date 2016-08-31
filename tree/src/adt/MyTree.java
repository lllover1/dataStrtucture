package adt;

public abstract class MyTree<T> {
	public abstract boolean isEmpty();
	public abstract int level(T key);
	public abstract int size();
	public abstract int height();
	public abstract void preorder();
	public abstract void postoder();
	public abstract void levelorder();	
	public abstract void clear();
}
