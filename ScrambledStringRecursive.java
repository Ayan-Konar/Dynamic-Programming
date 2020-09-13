package dynamicprogramming;

public class ScrambledStringRecursive 
{
	public static boolean solve(String a,String b)
	{
		if(a.equals(b))
			return true;
		if(a.length()<=1||b.length()<=1)
			return false;
		
		boolean flag=false;
		int n=a.length();
		
		for(int i=1;i<=n-1;i++)
		{
			boolean cond1 = solve(a.substring(0,i),b.substring(n-i,n))==true && solve(a.substring(i,n),b.substring(0,n-i))==true;
			boolean cond2 = solve(a.substring(0,i),b.substring(0,i))==true && solve(a.substring(i,n),b.substring(i,n))==true;
			if(cond1||cond2)
			{
				flag=true;
			}
				
			
			
		}
		return flag;
		
	}

	public static void main(String[] args) 
	{
		String a="great";
		String b="rgtea";
		if(a.length()!=b.length())
			System.out.println(false);
		if(a==" " && b==" ")
			System.out.println(true);
		System.out.println(solve(a,b));
		

	}

}
