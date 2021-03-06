package adt;
@SuppressWarnings("unchecked")
public class Node<T> {
	
	//=====================================================================
	//类私有属性
	private T data;                 //节点存入的值
	private Node<T> next;           //下一个节点
	
	//=====================================================================
	//构造方法
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
	//get()方法，set()方法

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
	//公有方法
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
