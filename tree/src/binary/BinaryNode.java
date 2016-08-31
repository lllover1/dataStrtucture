package binary;

/**
 * �������ڵ�
 * @author llw
 *
 * @param <T> �ڵ�洢��ֵ������
 */
public class BinaryNode<T> {
	
	private T data;
	private BinaryNode<T> left,right;
	
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public BinaryNode(T data){
		this(data,null,null);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
}
