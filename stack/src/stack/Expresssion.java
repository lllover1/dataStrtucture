package stack;

public class Expresssion {
	private MyStack<Character> stack = new SeqStack<>();
	
	public String toPostfix(String infix){
		StringBuffer postfix = new StringBuffer(infix.length());
		int i =0;
		while(i<infix.length()){
			char c = infix.charAt(i);
			switch(c){
			case '(':
				System.out.println("(");
				stack.push(c);
				i++;
				break;
			case '+':
			case '-':
				System.out.println("+ -");
				while(!stack.isEmpty()&&(!stack.peek().equals('('))){
					postfix.append(stack.pop());
				}
				stack.push(c);
				i++;
				break;
			case '*':case '/':
				System.out.println("* /");
				while(!stack.isEmpty()&&(stack.peek().equals('*')||stack.peek().equals('/'))){
					postfix.append(stack.pop());
				}
				stack.push(c);
				i++;
				break;
			case ')':
				System.out.println("£©");
				while(!stack.isEmpty()&&(!stack.peek().equals('('))){
					postfix.append(stack.pop());
				}
				stack.pop();
				i++;
				break;
			default:
				System.out.println("19");
				while(i<infix.length()&&(c=infix.charAt(i))>='0'&&c<='9'){
					postfix.append(c);
					i++;
				}
				postfix.append(' ');
			}
		}
		while(!stack.isEmpty()){
			postfix.append(stack.pop());
		}
		return postfix.toString();
	}
	
	public int calPostfix(String postfix){
		int result = 0;
		MyStack<Integer> stack = new SeqStack<>();
		int i =0;
		while(i<postfix.length()){
			char c = postfix.charAt(i);
			switch(c){
			case '+':
				result = stack.pop()+stack.pop();
				stack.push(result);
				break;
			case '-':
				int x = stack.pop();
				result = stack.pop()-x;
				stack.push(result);
				break;
			case '*':
				result = stack.pop()*stack.pop();
				stack.push(result);
				break;
			case '/':
				int y = stack.pop();
				result = stack.pop()/y;
				stack.push(result);
				break;
			default:
				int  value = 0;
				if(c>='0'&&c<='9'){
					while(c!=' '){
						value = value*10+c-'0';
						c = postfix.charAt(++i);
					}
					stack.push(value);
				}
			}
			i++;
		}
		return result;
	}
}
