package graph;

/**
 * ������� �洢�ڽӾ���
 * @author llw
 *
 */
public class Matrix {
	private int rows,columns;
	private int[][] element;
	/********************************************************/
	//���췽��
	public Matrix(int m,int n){
		this.element = new int[m][n];
		this.rows = m;
		this.columns = n;
	}
	public Matrix(int n){
		this(n,n);
	}
	
	public Matrix(int m,int n,int[][]value){
		this(m,n);
		for(int i=0;i<value.length&&i<m;i++){
			for(int j=0;j<value[i].length&&j<n;j++){
				this.element[i][j] = value[i][j];
			}
		}
	}
	
	/**************************************************************/
	//ʵ�ַ���
	public int getRows() {
		return rows;
	}
 
	public int getColumns() {
		return columns;
	}
	
	public int get(int i,int j){
		if(i<rows&&i>=0&&j<columns&&j>=0){
			return this.element[i][j]; 
		}
		throw new IndexOutOfBoundsException("�±�Խ��");
	}
	
	public void set(int i,int j,int x){
		if(i<rows&&i>=0&&j<columns&&j>=0){
			this.element[i][j] = x; 
		}
		throw new IndexOutOfBoundsException("�±�Խ��");
	}
	
	public void setRowsColumns(int m,int n){
		if(m>0&&n>0){
			if(m>element.length||n>element[0].length){
				int[][] source = this.element;
				this.element = new int[m][n];
				for(int i=0;i<rows;i++){
					for(int j=0;j<columns;j++){
						this.element[i][j] = source[i][j];
					}
				}
			}
			this.rows = m;
			this.columns =n;
		}else{
			throw new IllegalArgumentException("����Խ��");
		}
	}
}
