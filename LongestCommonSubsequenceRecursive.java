package dynamicprogramming;

public class LongestCommonSubsequenceRecursive 
{
public static int lcs(char[] X,char[] Y,int n,int m)
{
	if(n==0||m==0)
	{
		return 0;
	}
	if(X[n-1]==Y[m-1])
	{
		return 1+lcs(X,Y,n-1,m-1);
	}
	else
	{
		return Math.max(lcs(X,Y,n,m-1),lcs(X,Y,n-1,m));
	}
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
		System.out.println(lcs(X,Y,n,m));

	}

}
