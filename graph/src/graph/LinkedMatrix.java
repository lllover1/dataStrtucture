package graph;

import adt.LinkedList;
public class LinkedMatrix {
	private int rows,columns;
	
	LinkedList<LinkedList<Tripe>> linkedList;
	
	public LinkedMatrix(int m,int n){
		this.rows = m;
		this.columns = n;
		this.linkedList = new LinkedList<>();
		for(int i=0;i<m;i++){
			linkedList.insert(new LinkedList<>());
		}
	}
	
	public LinkedMatrix(int m){
		this(m,m);
	}
	
	public LinkedMatrix(int m,int n,Tripe[] tris){
		this(m,n);
		for(int i=0;i<tris.length;i++){
			this.set(tris[i]);
		}
	}

	public void set(Tripe tripe) {
		int i = tripe.row;
		int j = tripe.column;
		if(i<rows&&i>=0&&j<columns&&j>=0){
			LinkedList<Tripe> list = linkedList.get(i);
			if(tripe.value ==0){
				list.remove(tripe);
			}else{
				int t = list.serch(tripe);
				if(t!=-1){
					list.insert(tripe);
				}else{
					list.set(i, tripe);
				}
			}
		}else{
			throw new IndexOutOfBoundsException("越界i="+i);
		}
		
	}
	
	public void set(int i,int j,int weight){
		this.set(new Tripe(i,j,weight));
	}
	
	public int get(int i,int j){
		if(i<rows&&i>=0&&j<columns&&j>=0){
			LinkedList<Tripe> key = linkedList.get(i);
			int k = key.serch(new Tripe(i, j, 0));
			if(k==-1){
				return 0;
			}else{
				return key.get(k).value;
			}
		}else{
			throw new IndexOutOfBoundsException("下标越界");
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setRowsColumns(int i, int j) {
		this.rows = i;
		this.columns = j;
	}
	
	
}
