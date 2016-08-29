package stack;

public class Test {
	public static void main(String[] args){
		String s = new Expresssion().toPostfix("((1+2*3)*4-5)/6");
		System.out.println(s);
		int i = new Expresssion().calPostfix(s);
		System.out.println(i);
	}
}
