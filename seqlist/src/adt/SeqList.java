package adt;
/**
 * 顺序表的具体实现
 * 内部用数组实现
 * @author 刘力文
 * @param <T>泛型，代表元素类型
 */
@SuppressWarnings("unchecked")
public class SeqList<T> extends List<T> {

	//=========================================================
	/* 对象内部私有变量
	 * element:存放所有存入顺序表的元素 
	 *         Java不支持范型数组
	 * size:书序表中元素的数量
	 */
	private Object[] element;
	private int size;
	private static final int DEFAULT_LENGTH = 64;
	//=========================================================
	//构造方法
	public SeqList(int length) {
		this.element = new Object[length];
		this.size = 0;
	}
	
	public SeqList() {
		this(DEFAULT_LENGTH);
	}
	
	public SeqList(T[] values){
		if(values==null){
			throw new NullPointerException("values==null");
		}
		this.element = new Object[values.length];
		for(int i =0;i<values.length;i++){
			this.element[i] = values[i];
		}
		this.size = values.length;
	}
	//=======================================================
	//继承父类的公有方法的具体实现
	/**
	 * 判断顺序表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.size==0;
	}
	
	/**
	 * 求顺序表中元素的数量
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * 获取位置为i的元素
	 */
	@Override
	public T get(int i) {
		if(i>=0 && i<this.size){
			return (T)this.element[i];
		}else{
			throw new IndexOutOfBoundsException("index:"+i);
		}
	}
	
	/**
	 * 设置位置为i的元素为x
	 */
	@Override
	public void set(int i, T x) {
		if(x==null){
			throw new NullPointerException("x==null");
		}
		if(i>=0 && i<this.size){
			this.element[i] = x;
		}else {
			throw new IndexOutOfBoundsException("index:"+i);
		}
	}
	
	/**
	 * 顺序表内部元素转换为字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(" : { ");
		if(this.size>0){
			sb.append(this.element[0].toString());
			for(int i = 1;i<this.size;i++){
				sb.append(" ; ");
				sb.append(this.element[i].toString());
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * 指定位置插入元素
	 */
	@Override
	public int insert(int i, T x) {
		if(x==null){
			throw new NullPointerException("x==null");
		}
		if(i<0){
			i=0;
		}
		if(i>this.size){
			i = this.size;
		}
		Object[] temp = this.element;
		if(this.size == this.element.length){
			this.element = new Object[temp.length*2];
			for(int j = 0;j<i;j++){
				this.element[j] = temp[j];
			}
		}
		for(int j = this.size-1;j>=i;j--){
			this.element[j+1] = temp[j];
		}
		this.element[i] = x;
		this.size++;
		return i;
	}
	
	/**
	 * 表尾插入元素
	 */
	@Override
	public int insert(T x) {
		return this.insert(this.size,x);
	}
	
	/**
	 * 移除指定位置的元素
	 */
	@Override
	public T remove(int i) {
		if(i<0||i>=this.size){
			throw new IndexOutOfBoundsException("index:"+i);
		}
		T old = (T)this.element[i];
		for(int j =i;j<this.size;j++){
			this.element[j] = this.element[j+1];
		}
		this.element[this.size-1] = null;
		this.size--;
		return old;
	}

	/**
	 * 清空顺序表
	 */
	@Override
	public void clear() {
		this.element = new Object[DEFAULT_LENGTH];
		this.size = 0;	
	}
	
	/**
	 * 查找指定元素的位置
	 */
	@Override
	public int serch(T key) {
		if(key==null){
			throw new NullPointerException("key==null");
		}
		for(int i = 0 ;i<this.size;i++){
			if(key.equals(this.element[i])){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 顺序表中是否包含指定元素
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
	
	/**
	 * 移除值为key的元素
	 */
	@Override
	public T remove(T key) {
		
		for(int i = 0 ;i<this.size;i++){
			if(key.equals(this.element[i])){
				return (T)this.element[i];
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object object) {
		if(this == object){
			return true;
		}
		if(object instanceof SeqList<?>){
			SeqList<T> list = (SeqList<T>) object;
			if(this.size == list.size){
				for(int i=0;i<this.size;i++){
					if(!this.get(i).equals(list.get(i))){
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
		if(list==null){
			return;
		}
		int length = list.size();
		for(int i=0;i<length;i++){
			this.insert(list.get(i));
		}
	}
}
