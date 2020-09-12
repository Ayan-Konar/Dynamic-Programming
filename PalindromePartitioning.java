package dynamicprogramming;

public class PalindromePartitioning 
{
	public static int solve(String s,int i,int j)
	{
		int mini=9999;
		if(i>=j||ispalin(s,i,j))
			return 0;
		for(int k=i;k<=j-1;k++)
		{
			int temp_ans=(1+solve(s,i,k)+solve(s,k+1,j));
			if(temp_ans<mini)
			{
				mini=temp_ans;
			}
			
		}
		return mini;
	}
	
	public static boolean ispalin(String s,int i,int j)
	{
		while(i<=j)
		{
			if(s.charAt(i++)!=s.charAt(j--))
				return false;
		}
		return true;
		
	}

	public static void main(String[] args)
	{
		String s="ababbbabbababa";
		int i=0;
		int j=s.length()-1;
		System.out.println(solve(s,i,j));

	}

}
