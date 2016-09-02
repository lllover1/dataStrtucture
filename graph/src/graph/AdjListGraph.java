package graph;

public class AdjListGraph<T> extends AbstractGraph<T>{

	protected LinkedMatrix matrix;
	
	/**********************************************************/
	//构造方法
	public AdjListGraph(int length){
		super(length);
		this.matrix = new LinkedMatrix(length);
	}
	
    public AdjListGraph() {
	}
    public AdjListGraph(T[] x) {
    	
	}
    public AdjListGraph(T[] x,Tripe[] tripe){
    	
    }
    
    /**
     * 插入边
     * @param i
     * @param j
     * @param weight
     */
    public void insertEdge(int i,int j,int weight){
    	if(i!=j){
    		if(weight<0||weight>=MAX_WEIGHT){
    			weight =0;
    		}
    		this.matrix.set(i, j, weight);
    	}
    	else new IllegalArgumentException("不能插入自身环");
    }
    public void insertEdge(Tripe tripe){
    	insertEdge(tripe.row,tripe.column,tripe.value);
    }
    
	@Override
	public int insertVertex(T x) {
		int i = this.vertexlist.insert(x);
		if(i>=this.matrix.getRows()){
			this.matrix.setRowsColumns(i+1,i+1);
		}
		return i;
	}

	public void removeEdge(int i,int j){
		if(i!=j){
			this.matrix.set(i, j, 0);
		}
	}
	
	public void removeEdge(Tripe tripe){
		removeEdge(tripe.row,tripe.column);
	}
	@Override
	public void removeVertex(int i) {
		
	}

	@Override
	public int weight(int i, int j) {
		return 0;
	}

	@Override
	public int next(int i, int j) {
		return 0;
	}

}
