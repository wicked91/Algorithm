import java.util.Scanner;
import java.util.Stack;

public class Pre_order {

	
	public static int Priority(String s){
		if(s.equals("*") || s.equals("/"))
			return 3;
		else if(s.equals("+") || s.equals("-"))
			return 2;
		else if(s.equals("("))
			return 1;
		return 0;
	}
	
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String Postfix ="";
		Stack<String> Operator = new Stack<String>();
	
		int index=0;
		int LENGTH = string.length();
		
		while(LENGTH>index){
			String token = string.charAt(index)+"";
			int P = Priority(token);
			
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
				
				while(!Operator.isEmpty() && Priority(Operator.peek())>=Priority(token))
					Postfix+=Operator.pop();
				
				Operator.push(token);
			}
			
			else if(token.equals("(")){
				Operator.push(token);				
			}
			
			else if(token.equals(")")){
				
				while(!Operator.isEmpty() && !Operator.peek().equals("(")){
					Postfix+=Operator.pop();
				}
				
				if(!Operator.isEmpty() && Operator.peek().equals("(")){
					Operator.pop();
				}
			}
			
			
			else{
				Postfix+=token;
			}
	
			index++;
		
		}
		
		while(!Operator.isEmpty()){
			Postfix+=Operator.pop();
		}

		System.out.print(Postfix);
	}
}
