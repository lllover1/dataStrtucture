package expression;

public class ExpData {
	int value;
	char oper;
	public ExpData(int value,char oper){
		this.value = value;
		this.oper = oper;
	}
	
	public String toString (){
		return this.oper ==' '?this.value+"":this.oper+"";
	}
}
