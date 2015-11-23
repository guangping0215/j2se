package com.ncs.innerclass;

public class SingleChainListNormal {
	//用while循环打印
	private static void printNodes(Node node){
		while(null != node){
			System.out.print(node.getData());
			node = node.getNext();
		}
	}
	
	//用递归循环打印
	private static void printNodes2(Node node){
		System.out.print(node.getData());
		if(null != node.getNext()){
			printNodes2(node.getNext());
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		printNodes(node1);
		System.out.println();
		System.out.println("=============");
		printNodes2(node1);
	}
}

class Node{
	private String data;
	private Node next;
	public Node(String data){
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
