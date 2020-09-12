package dynamicprogramming;

public class CountPathsTopDown 
{
	public static int count_all_paths(int m,int n)
	{
		int [][]t=new int [m+1][n+1];
		t[0][0]=1;
		for(int j=1;j<n+1;j++)
		{
			t[0][j]=1;
		}
		for(int i=1;i<m+1;i++)
		{
			t[i][0]=1;
		}
		
		for(int i=1;i<m+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				t[i][j]=t[i-1][j]+t[j-1][i];
			}
		}
		return t[m][n];
		
	}

	public static void main(String[] args) 
	{
		
		int n=3;
	    int m=3;
	    System.out.println(count_all_paths(m,n));


	}

}
