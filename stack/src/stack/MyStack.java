package stack;

/**
 * ջ�ĳ�����
 * @author llw
 *
 * @param <T> ����
 */
public abstract class MyStack<T> {
	public abstract boolean isEmpty();
	public abstract void push(T x);
	public abstract T peek();
	public abstract T pop();
}
