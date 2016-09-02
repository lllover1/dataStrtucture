package graph;

/**
 * �ڽӾ���ʵ�ִ�Ȩͼ
 * @author llw
 *
 * @param <T>
 */
public class MatrixGraph<T> extends AbstractGraph<T> {
	
	protected Matrix matrix;
	
	/*************************************************************/
	//���췽��
	
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
    //ʵ�ַ���
    /**
     * �����
     * @param tripe ��
     */
    public void insertEdge(Tripe tripe){
    	
    	insertEdge(tripe.row, tripe.column, tripe.value);
    }
    
    /**
     * �����
     * @param i  ��
     * @param j  ��
     * @param weight Ȩ��
     */
    public void insertEdge(int i,int j,int weight){
    	if(i!=j){
    		if(weight<=0||weight>MAX_WEIGHT){
    			weight = MAX_WEIGHT;
    			matrix.set(i,j,weight);
    		}
    	}else{
    		throw new IllegalArgumentException("���ܲ�������");
    	}
    	
    }
    
    /**
     * ���붥��
     * @param x ����ֵ
     * @return  ����λ��
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
	 * ɾ����
	 * @param i ��
	 * @param j ��
	 */
	public void removeEdge(int i,int j){
		if(i!=j){
			this.matrix.set(i, j, MAX_WEIGHT);
		}
	}
	
	/**
	 * ɾ����
	 * @param tripe ��
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
			throw new IndexOutOfBoundsException("�±�Խ��");
		}
		
	}

	/**
	 * ���رߵ�Ȩ��
	 * @param i ��
	 * @param j ��
	 * @return Ȩ��
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
