package dynamicprogramming;

public class LongestCommonSubsequenceMemoize 
{
	static int [][]t=new int[100][100];
	public static int lcs(char[] X,char[] Y,int n,int m)
	{
		
		if(n==0||m==0)
		{
			return 0;
		}
		if(t[n][m]!=-1)
		{
			return t[n][m];
		}
		if(X[n-1]==Y[m-1])
		{
			t[n][m]=1+lcs(X,Y,n-1,m-1);
		}
		else
		{
			t[n][m]=Math.max(lcs(X,Y,n,m-1),lcs(X,Y,n-1,m));
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
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				t[i][j]=-1;
			}
		}
		System.out.println(lcs(X,Y,n,m));

	}

}
