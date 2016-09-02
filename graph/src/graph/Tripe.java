package graph;

public class Tripe implements Comparable<Tripe> {

	int row,column,value;
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


}
