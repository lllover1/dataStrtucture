package adt;
@SuppressWarnings("unchecked")
public class Node<T> {
	
	//=====================================================================
	//��˽������
	private T data;                 //�ڵ�����ֵ
	private Node<T> next;           //��һ���ڵ�
	
	//=====================================================================
	//���췽��
	public Node (){
		this(null,null);
	}
	
	public Node (T data) {
		this(data,null);
	}
	
	public Node (T data,Node<T> next) {
		this.data = data;
		this.next = next;
	}
	//======================================================================
	//get()������set()����

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	//======================================================================
	//���з���
	public String toString () {
		return this.data.toString();
	}
	public boolean equals(Object object){
		if(this==object){
			return true;
		}
		if(object instanceof Node<?>){
			Node<T> node = (Node<T>) object;
			if(this.data.equals(node.getData())){
				return true;
			}
		}
		return false;
	}
}