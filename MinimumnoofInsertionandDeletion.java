package dynamicprogramming;

public class MinimumnoofInsertionandDeletion 
{
public static String lcs(char []X,char []Y,int m,int n)
{
	int [][]t=new int[m+1][n+1];
	for(int i=0;i<m+1;i++)
	{
		for(int j=0;j<n+1;j++)
		{
			if(i==0|j==0)
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
	//return t[m][n];
	int i=m,j=n;
	String s="";
	while(i>0&&j>0)
	{
		if(X[i-1]==Y[j-1])
		{
			s+=X[i-1];
			i--;
			j--;
		}
		else
		{
			if(t[i-1][j]>t[i][j-1])
				i--;
			else
				j--;
		}
	}
	StringBuffer sb=new StringBuffer(s);
	
	return sb.reverse().toString();
}
	public static void main(String[] args) 
	{
		String a="geeksforgeeks";
		String b="geeks";
		a=a.toLowerCase();
		b=b.toLowerCase();
		char []x=a.toCharArray();
		char []y=b.toCharArray();
		int m=a.length();
		int n=b.length();
		String lcs=lcs(x,y,m,n);
		int no_of_insertion=n-lcs.length();
		int no_of_deletion=m-lcs.length();
		System.out.println( no_of_insertion+" "+ no_of_deletion);
		

	}

}
