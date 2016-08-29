package stack;

/**
 * 栈的抽象类
 * @author llw
 *
 * @param <T> 泛型
 */
public abstract class MyStack<T> {
	public abstract boolean isEmpty();
	public abstract void push(T x);
	public abstract T peek();
	public abstract T pop();
}
