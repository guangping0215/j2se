package com.ncs.innerclass;

//主要理解操作的原理，Java实际应用中已经提供了大量的数据结构实现类
public class SingleChainListInnerClass {
	public static void main(String[] args) {
		ChainLink chainLint = new ChainLink();
		chainLint.addNode("A");
		chainLint.addNode("B");
		chainLint.addNode("C");
		chainLint.addNode("D");
		chainLint.addNode("E");
		chainLint.addNode("F");
		chainLint.addNode("G");
		
		chainLint.printNode();
		System.out.println("==========");
		System.out.println(chainLint.containNode("E"));
		System.out.println("==========");
		chainLint.deleteNode("E");
		chainLint.printNode();
		System.out.println(chainLint.containNode("E"));
	}
}

class ChainLink{
	
	class Node{
		private String data;
		private Node next;
		
		public Node(String data){
			this.data = data;
		}
		public void add( Node node ){
			if(null == this.next){
				this.next = node;
			}else{
				this.next.add(node);
			}
		}
		public boolean search( String data ){
			if(this.data.equals(data)){
				return true;
			}else{
				if( null != this.next){
					return this.next.search(data);
				}else{
					return false;
				}
			}
		}
		public void delete( Node previous, String data ){
			if(this.data.equals(data)){
				previous.next = this.next;
			}else{
				if( null != this.next){
					this.next.delete(this,data);
				}
			}
		}
		public void print(){
			System.out.print(this.data+"\t");
			if(null != this.next){
				this.next.print();
			}
		}
	}
	
	private Node root;
	public void addNode(String data){
		Node newNode = new Node(data);
		if(null == this.root){
			this.root = newNode;
		}else{
			this.root.add(newNode);
		}
	}
	
	public boolean containNode(String data){
		return this.root.search(data);
	}
	
	public void printNode(){
		this.root.print();
	}
	
	public void deleteNode(String data){
		if(containNode(data)){
			if(this.root.data.equals(data)){
				this.root = this.root.next;
			}else{
				this.root.next.delete(this.root, data);
			}
		}
	}
}