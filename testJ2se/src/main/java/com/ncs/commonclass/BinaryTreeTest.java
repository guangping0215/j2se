package com.ncs.commonclass;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.add(100);
		tree1.add(99);
		tree1.add(98);
		tree1.add(95);
		tree1.add(45);
		tree1.add(34);
		tree1.add(12);
		tree1.add(56);
		tree1.add(23);
		tree1.add(5);
		tree1.add(6);
		tree1.add(3);
		tree1.add(8);
		tree1.add(22);
		tree1.add(33);
		tree1.print();
	}
}
	
class BinaryTree{
	class Node{
		private Comparable<Integer> data;
		private Node left;
		private Node right;
		
		public void addNode(Node newNode){
			if(newNode.data.compareTo((Integer) this.data) < 0){
				if(this.left == null){
					this.left = newNode;
				}else{
					this.left.addNode(newNode);
				}
			}
			if(newNode.data.compareTo((Integer) this.data) >= 0){
				if(this.right == null){
					this.right = newNode;
				}else{
					this.right.addNode(newNode);
				}
			}
		}
		
		public void PrintNode(){
			if(this.left != null){
				this.left.PrintNode();
			}
			System.out.println(this.data+"\t");
			if(this.right != null){
				this.right.PrintNode();
			}
		}
	}
	
	private Node root;
	public void add(Comparable<Integer> next){
		Node node = new Node();
		node.data = next;
		if(root == null){
			root = node;
		}else{
			root.addNode(node);
		}
	}
	public void print(){
		this.root.PrintNode();
	}
}
