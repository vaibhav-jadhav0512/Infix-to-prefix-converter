import java.util.Stack; 
import java.io.*; 
import java.util.*; 

class infixToPrefix 
{
	
	private static int precedence=0;
	
	static String infixToPrefix(String str)
	{

		Stack<Character> stack= new Stack<>();

		byte[] strByte = str.getBytes();
 
        	byte[] reverse = new byte[strByte.length];
 
        	byte[] ans = new byte[reverse.length];

        	for (int i=0; i<strByte.length; i++)
		{
			
			char c = str.charAt(i);
			if (c=='(')
				c=')';
			else if(c==')')
				c=')';
            		reverse[i] = strByte[strByte.length - i - 1];
		}

		String reversed =Arrays.toString(reverse);

		String y =new String("");
		y=InfixToPostfix(reversed);
		byte[] rev = y.getBytes();
		
		for (int i=0; i<rev.length; i++)
		{
			char c = str.charAt(i);
			if (c=='(')
				c=')';
			else if(c==')')
				c=')';
            		ans[i] = rev[rev.length - i - 1];
		}

		
		for (int i=0; i<ans.length; i++)
		{
			System.out.println(ans[i]);
		}

		return "0";
		
		
	}
	public static int operatorCheck(char c)
	{
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='%'||c=='^')
		{
			return 1;
		}
		else 
			return 0;
	}

	public static int operatorPrecedence(char c)
	{
		if(c=='^')
		precedence=4;
		else if(c=='/'||c=='*'||c=='%')
		precedence=3;
		else if(c=='+'||c=='-')
		precedence=2;
		else
		precedence=1;

		return precedence;
	}

	static String InfixToPostfix(String str)
	{
		String result =new String("");

		Stack<Character> stack= new Stack<>();

		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);

			if(operatorCheck(c)==0)
				result += c;

			else if (c == '(') 
                		stack.push(c); 

			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
				result += stack.pop();

				stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && operatorPrecedence(c) <= operatorPrecedence(stack.peek()))
				{
					result +=stack.pop();				

				}	
					stack.push(c);
			}
		}
		
		while (!stack.isEmpty()){ 
            		if(stack.peek() == '(') 
                	return "Invalid Expression"; 
            		result += stack.pop(); 
         } 
        	 return result;
	}
 
}



public class PrefixConverter
{
	public static void main(String args[])
	{
    		String str = "k+l-m*n+(o^p)*w/u/v*t+q"; 

		infixToPrefix i1=new infixToPrefix();

         	i1.infixToPrefix(str);
		
 	}
}