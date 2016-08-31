package binary;

import adt.MyTree;

public class BinaryTree<T> extends MyTree<T> {
	
	private BinaryNode<T> root;
	
	/************************************************************/
	//���췽��
	public BinaryTree(){
		this.root = null;
	}
	
	/************************************************************/
	//ʵ�ֵķ���
	/**
	 * �ڸ��ڵ����һ���ڵ�
	 * @param x �ڵ�ֵ
	 * @return ����Ľڵ�
	 */
	public BinaryNode<T> insert(T x){
		return this.root = new BinaryNode<T>(x, this.root, null);
	}
	/**
	 * ��ĳ���ڵ��²���һ���ڵ�
	 * @param parent ������Ľڵ�
	 * @param x ����ڵ��ֵ
	 * @param left �Ƿ�Ϊ����
	 * @return ����Ľڵ�
	 */
	public BinaryNode<T> insert(BinaryNode<T> parent,T x,boolean left){
		BinaryNode<T> node = new BinaryNode<T>(x);
		if(left){
			node.setLeft(parent.getLeft());
			parent.setLeft(node);
		}else{
			node.setRight(parent.getRight());
			parent.setRight(node);
		}
		return node;
	}
	
	/**
	 * ɾ����������
	 * @param parent ��ĸ�ڵ�
	 * @param left �Ƿ�Ϊ������
	 * @return ɾ���������ĸ��ڵ�
	 */
	public BinaryNode<T> remove (BinaryNode<T> parent,boolean left){
		BinaryNode<T> old;
		if(left){
			old = parent.getLeft();
			parent.setLeft(null);
		}else{
			old = parent.getRight();
			parent.setRight(null);
		}
		return old;
	}
	
	/**
	 * ��������ǰ�����
	 * @param p ���ĸ��ڵ�
	 */
	public void preorder(BinaryNode<T> p){
		if(p!=null){
			System.out.println(p.getData());
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}
	/**
	 * ���������������
	 * @param p ���ĸ��ڵ�
	 */
	public void inorder(BinaryNode<T> p){
		if(p!=null){
			preorder(p.getLeft());
			System.out.println(p.getData());
			preorder(p.getRight());
		}
	}
	
	public void inorder(){
		inorder(root);
	}
	
	/**
	 * �������к������
	 * @param p ���ĸ��ڵ�
	 */
	public void postorder(BinaryNode<T> p){
		if(p!=null){
			preorder(p.getLeft());
			preorder(p.getRight());
			System.out.println(p.getData());
		}
	}
	
	/**
	 * �����Ľڵ���
	 * @param node ���ڵ�
	 * @return �ڵ���
	 */
	public int size(BinaryNode<T> node){
		if(node==null){
			return 0;
		}else{
			return size(node.getLeft())+size(node.getRight())+1;
		}
	}
	
	public int height(BinaryNode<T> node){
		if(node==null){
			return 0;
		}else{
			int hl = height(node.getLeft());
			int hr = height(node.getRight());
			return (hl>hr?hl:hr)+1;
		}
	}
	/************************************************************/
	//��д���෽��
	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public int level(T key) {
		return 0;
	}

	@Override
	public int size() {
		return size(root);
	}

	@Override
	public int height() {
		return height(root);
	}

	@Override
	public void preorder() {
		preorder(root);
	}

	@Override
	public void postoder() {
		postorder(root);
	}

	@Override
	public void levelorder() {

	}

	@Override
	public void clear() {
		root = null;
	}
	/***********************************************************************/
	//get() and set()
	public BinaryNode<T> getRoot() {
		return root;
	}
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
}
