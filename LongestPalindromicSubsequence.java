package dynamicprogramming;

public class LongestPalindromicSubsequence 
{
	public static int lcs(char[]X,char[]Y,int m,int n) 
	{
		int [][]t=new int[m+1][n+1];
		for(int i=0;i<m+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
				}
			}
		}
		
		for(int i=1;i<m+1;i++) 
		{
			for(int j=1;j<n+1;j++)
			{
				if(X[i-1]==Y[j-1])
				{
					t[i][j]=1+t[i-1][j-1];
				}
				else
				{
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
				}
			}
			
		}
		return t[m][n];
		
	}

	public static void main(String[] args) 
	{
		String a="hbjeausdwetcoigruoczwvlfxjvygtpnuatvulatsuxie";
		StringBuffer sb=new StringBuffer(a);
		String b=sb.reverse().toString();
		int m=a.length();
		int n=b.length();
		char []x=a.toCharArray();
		char []y=b.toCharArray();
		int lcs=lcs(x,y,m,n);
		System.out.println(lcs);

	}

}
