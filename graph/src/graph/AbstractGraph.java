package graph;

import adt.SeqList;

/**
 * 图的带权实现
 * @author llw
 *
 * @param <T> 顶点元素类型
 */
public abstract class AbstractGraph<T> {
	protected static final int MAX_WEIGHT = 0x0000fff;  //最大权值
	protected SeqList<T> vertexlist;                    //顶点顺序表
	
	/*******************************************************/
	//构造方法
	public AbstractGraph(int i){
		this.vertexlist = new SeqList<>(10);
	}
	public AbstractGraph(){
		this(10);
	}
	
	public int vertexCount(){
		return this.vertexlist.size();
	}
	public T getVertex(int i){
		return this.vertexlist.get(i);
	}
	public void setVertex(int i,T x){
		this.vertexlist.set(i, x);
	}
	
	/********************************************************/
	//抽象方法
	public abstract int insertVertex(T x);
	public abstract void removeVertex(int i);
	public abstract int weight(int i,int j);
	public abstract int next(int i,int j);
}
