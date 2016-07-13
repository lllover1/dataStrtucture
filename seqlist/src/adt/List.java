package adt;

/**
 * ���Ա�ĳ�����
 * @author ������
 * @param <T> ���ͣ����Ա���Ԫ�صľ�������
 */
public abstract class List<T>{
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract T get(int i);
	public abstract void set(int i,T x);
	public abstract String toString ();
	public abstract int insert(int i,T x);
	public abstract int insert(T x);
	public abstract T remove(int i);
	public abstract void clear();
	public abstract int serch(T key);
	public abstract boolean contain(T key);
	public abstract int insertDifferent(T x);
	public abstract T remove(T key);
	public abstract boolean equals(Object object);
	public abstract void addAll(List<T> list);
}
