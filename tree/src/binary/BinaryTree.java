package binary;

import adt.MyTree;

public class BinaryTree<T> extends MyTree<T> {
	
	private BinaryNode<T> root;
	
	/************************************************************/
	//构造方法
	public BinaryTree(){
		this.root = null;
	}
	
	/************************************************************/
	//实现的方法
	/**
	 * 在根节点插入一个节点
	 * @param x 节点值
	 * @return 插入的节点
	 */
	public BinaryNode<T> insert(T x){
		return this.root = new BinaryNode<T>(x, this.root, null);
	}
	/**
	 * 在某个节点下插入一个节点
	 * @param parent 被插入的节点
	 * @param x 插入节点的值
	 * @param left 是否为左孩子
	 * @return 插入的节点
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
	 * 删除孩子子树
	 * @param parent 父母节点
	 * @param left 是否为左子树
	 * @return 删除的子树的根节点
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
	 * 对树进行前序遍历
	 * @param p 树的根节点
	 */
	public void preorder(BinaryNode<T> p){
		if(p!=null){
			System.out.println(p.getData());
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}
	/**
	 * 对树进行中序遍历
	 * @param p 树的根节点
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
	 * 对树进行后序遍历
	 * @param p 树的根节点
	 */
	public void postorder(BinaryNode<T> p){
		if(p!=null){
			preorder(p.getLeft());
			preorder(p.getRight());
			System.out.println(p.getData());
		}
	}
	
	/**
	 * 求树的节点数
	 * @param node 根节点
	 * @return 节点数
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
	//重写父类方法
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
