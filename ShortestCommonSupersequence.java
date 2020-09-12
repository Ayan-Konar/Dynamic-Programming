package dynamicprogramming;

public class ShortestCommonSupersequence 
{
	public static int lcs(char[] X,char[] Y,int n,int m)
	{
		int [][]t=new int[n+1][m+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
				}
			}
		}
		
		for(int i=1;i<n+1;i++) 
		{
			for(int j=1;j<m+1;j++)
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
		return t[n][m];
	}


	public static void main(String[] args) 
	{
		String x="ayan";
		String y="Sayan";
		x=x.toLowerCase();
		y=y.toLowerCase();
		char []X=x.toCharArray();
		char []Y=y.toCharArray();
		int n=x.length();
		int m=y.length();
		System.out.println(m+n-lcs(X,Y,n,m));

	}

}
