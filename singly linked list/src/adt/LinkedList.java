package adt;
/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class LinkedList<T> extends List<T> {
	
	//===========================================================================
	//˽������
	private Node<T> head;      //����ͷ���
	private int size;          //������С
	
	//===========================================================================
	//���췽��
	public LinkedList (){
		this.head = new Node<T>();
		this.size = 0;
	}
	
	//===========================================================================
	//get() set()
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	//===========================================================================
	//��д���෽��
	@Override
	/**
	 * �ж������Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * ��ȡ������Ԫ������
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * ��ȡ��i��Ԫ��
	 */
	@Override
	public T get(int i) {
		if(i<0||i>=size){
			throw new IndexOutOfBoundsException("i:"+i);
		}
		Node<T> temp = this.head.getNext();
		while(i!=0 && temp!=null){
			temp = temp.getNext();
			i--;
		}
		return temp!=null?temp.getData():null;
	}

	/**
	 * ���õ�i��ֵΪx
	 */
	@Override
	public void set(int i, T x) {
		if(x==null){
			throw new NullPointerException("x:"+x);
		}
		if(i<0||i>=size){
			throw new IndexOutOfBoundsException("i:"+i);
		}
		Node<T> temp = this.head;
		while(i!=0 && temp.getNext()!=null){
			temp = temp.getNext();
			i--;
		}
		if(i == 0){
		    Node<T> node = new Node<>(x,temp.getNext().getNext());
			temp.setNext(node);	
		}
		
	}

	@Override
	public String toString() {
		return null;
	}

	/**
	 * ��I��λ�ò���x
	 */
	@Override
	public int insert(int i, T x) {
		if(x==null){
			throw new NullPointerException("x:"+x);
		}
		if(i<0||i>size){
			throw new IndexOutOfBoundsException("i:"+i);
		}
		Node<T> temp = this.head;
		int local = i;
		while(i!=0 && temp!=null){
			temp = temp.getNext();
			i--;
		}
		if(i == 0){
		    Node<T> node = new Node<>(x,temp.getNext());
			temp.setNext(node);
			this.size++;
			return local;
		}else {
			return -1;
		}
	}

	/**
	 * ��β����x
	 */
	@Override
	public int insert(T x) {
		return this.insert(this.size,x);
	}

	/**
	 * �Ƴ���i��Ԫ��
	 */
	@Override
	public T remove(int i) {
		if(i<0||i>=size){
			throw new IndexOutOfBoundsException("i:"+i);
		}
		Node<T> temp = this.head;
		while(i!=0 && temp.getNext()!=null){
			temp = temp.getNext();
			i--;
		}
		T old = null;
		if(i == 0){
			old = temp.getNext().getData();
			temp.setNext(temp.getNext().getNext());	
			this.size--;
		}
		return old;
	}

	@Override
	public void clear() {
		this.head = new Node<T>();
		this.size = 0;
	}

	/**
	 * ����ֵΪkey�ĵ�һ��Ԫ��
	 */
	@Override
	public int serch(T key) {
		if(key==null){
			throw new NullPointerException("key:"+key);
		}
		Node<T> temp = this.head;
		for(int i =0;temp!=null&&i<size;i++){
			temp = temp.getNext();
			if(key.equals(temp.getData())){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 */
	@Override
	public boolean contain(T key) {
		return this.serch(key)!=-1;
	}

	@Override
	public int insertDifferent(T x) {
		if(!this.contain(x)){
			return this.insert(x);
		}
		return -1;
	}

	@Override
	public T remove(T key) {
		if(key==null){
			throw new NullPointerException("key:"+key);
		}
		Node<T> temp = this.head.getNext();
		for(int i =0;temp!=null&&i<size;i++){
			T old = temp.getNext().getData();
			if(key.equals(old)){
				return old;
			}
			temp = temp.getNext();
		}
		return null;
	}

	@Override
	public boolean equals(Object object) {
		if(this == object){
			return true;
		}
		if(object instanceof LinkedList<?>){
			LinkedList<T> obj = (LinkedList<T>) object;
			if(this.size == obj.size){
				Node<T> nodeThis = this.head.getNext();
				Node<T> nodeObj = obj.getHead().getNext();
				for(int i=0;i<this.size;i++){
					if(!nodeThis.equals(nodeObj)){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void addAll(List<T> list) {
		if(list == null){
			throw new NullPointerException();
		}
		int length = list.size();
		for(int i =0; i<length;i++){
			this.insert(list.get(i));
		}
	}

}