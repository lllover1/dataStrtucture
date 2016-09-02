package graphAlo;

public class Tripe implements Comparable<Tripe> {

	int row,column,value;
	public Tripe(int i, int j, int weight) {
		this.row =i;
		this.column =j;
		this.value = weight;
	}
	@Override
	public int compareTo(Tripe arg0) {
		if(value>arg0.value){
			return 1;
		}else if(value== arg0.value){
			return 0;
		}else{
			return -1;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof Tripe){
			Tripe tripe = (Tripe)obj;
			if(row==tripe.row&&column==tripe.column){
				return true;
			}
		}
		return false;
	}
	


}
