package graph;

/**
 * 邻接矩阵实现带权图
 * @author llw
 *
 * @param <T>
 */
public class MatrixGraph<T> extends AbstractGraph<T> {
	
	protected Matrix matrix;
	
	/*************************************************************/
	//构造方法
	
	public MatrixGraph(int length){
		super(length);
		this.matrix  = new Matrix(length);
	}
	
    public MatrixGraph() {
    	this(10);
	}
    public MatrixGraph(T[] value){
    	this(value.length);
    	for(int i =0;i<value.length;i++){
    		this.insertVertex(value[i]);
    	}
    }
    public MatrixGraph(T[] value,Tripe[] tripe){
    	this(value);
    	for(int j=0;j<tripe.length;j++){
    		this.insertEdge(tripe[j]);
    	}
    }
    
    /***************************************************************************/
    //实现方法
    /**
     * 插入边
     * @param tripe 边
     */
    public void insertEdge(Tripe tripe){
    	
    	insertEdge(tripe.row, tripe.column, tripe.value);
    }
    
    /**
     * 插入变
     * @param i  行
     * @param j  列
     * @param weight 权重
     */
    public void insertEdge(int i,int j,int weight){
    	if(i!=j){
    		if(weight<=0||weight>MAX_WEIGHT){
    			weight = MAX_WEIGHT;
    			matrix.set(i,j,weight);
    		}
    	}else{
    		throw new IllegalArgumentException("不能插入自身环");
    	}
    	
    }
    
    /**
     * 插入顶点
     * @param x 顶点值
     * @return  插入位置
     */
	@Override
	public int insertVertex(T x) {
		int i= this.vertexlist.insert(x);
		if(i>this.matrix.getRows()){
			this.matrix.setRowsColumns(i+1, i+1);
		}
		for(int j=0;j<i;j++){
			this.matrix.set(i, j, MAX_WEIGHT);
			this.matrix.set(j, i, MAX_WEIGHT);
		}
		return i;
	}

	/**
	 * 删除边
	 * @param i 行
	 * @param j 列
	 */
	public void removeEdge(int i,int j){
		if(i!=j){
			this.matrix.set(i, j, MAX_WEIGHT);
		}
	}
	
	/**
	 * 删除边
	 * @param tripe 边
	 */
	public void removeEdge(Tripe tripe){
		this.removeEdge(tripe.row, tripe.column);
	}
	
	
	@Override
	public void removeVertex(int i) {
		int n = this.vertexCount();
		if(i>=0&&i<n){
			this.vertexlist.remove(i);
			for(int j =0;j<n;j++){
				for(int k=i+1;k<n;k++){
					this.matrix.set(j, k-1, matrix.get(j, k));
					this.matrix.set(k-1, j, matrix.get(k, j));
				}
			}
			this.matrix.setRowsColumns(n-1, n-1);
		}else{
			throw new IndexOutOfBoundsException("下边越界");
		}
		
	}

	/**
	 * 返回边的权重
	 * @param i 行
	 * @param j 列
	 * @return 权重
	 */
	@Override
	public int weight(int i, int j) {
		return this.matrix.get(i, j);
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	@Override
	public int next(int i, int j) {
		int n = this.vertexCount();
		if(i>=0&&j>=-1&&j<n&&i!=j){
			for(int k=j+1;k<n;k++){
				if(this.matrix.get(i, k)>0&&this.matrix.get(i, k)<MAX_WEIGHT){
					return k;
				}
			}
		}
		return -1;
	}

}
