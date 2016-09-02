package expression;

import binary.BinaryNode;
import binary.BinaryTree;

public class Expression extends BinaryTree<ExpData> {
	int i =0;
	public Expression(String prefix){
		this.setRoot(createPrefix(prefix));
	}

	private BinaryNode<ExpData> createPrefix(String prefix) {
		BinaryNode<ExpData> p = null;
		if(i<prefix.length()){
			char ch = prefix.charAt(i);
			if(ch>'0'&&ch<'9'){
				int value = 0;
				while(i<prefix.length()&&ch!=' '){
					value  = value*10 +ch-'0';
					i++;
					if(i<prefix.length()){
						ch = prefix.charAt(i);
					}
				}
				p = new BinaryNode<ExpData>(new ExpData(value, ' '));
				i++;
			}else{
				p = new BinaryNode<ExpData>(new ExpData(0, prefix.charAt(i)));
				i++;
				p.setLeft(createPrefix(prefix));
				p.setRight(createPrefix(prefix));
			}
		}
		return p;
	}
	
	public int toValue(){
		return 0;
	}
	
	public int toValue(BinaryNode<ExpData> p){
		if(p ==null){
			return 0;
		}
		return 0;
	}
}
