import java.util.Scanner;

class Node{
	Node node;
	int data;
	Node(Node stack, int data){
		this.node=stack;
		this.data=data;
	}
}

class LinkdedStack{
	Node top;
}

public class Stack {

	public static void push(LinkdedStack stack,int data){
		
		Node NewNode = new Node(stack.top,data);
		stack.top=NewNode;
		
	}
	
	public static int pop(LinkdedStack stack){
		int D =  stack.top.data;
		stack.top=stack.top.node;
		
		return D;
		
	}
	
	public static int peek(LinkdedStack stack){
		return stack.top.data;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LinkdedStack stack = new LinkdedStack();
		
		stack.top=null;		
		push(stack,1);
		push(stack,2);
		push(stack,3);
		push(stack,4);
		
		System.out.println(peek(stack));
		System.out.println(pop(stack));
		System.out.println(pop(stack));
		System.out.println(pop(stack));
	}
}


