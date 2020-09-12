package dynamicprogramming;

public class PalindromePartitioningmMemoizedOptimisation 
{
	static int [][]t=new int[1001][1001];
	public static int solve(String s,int i,int j)
	{
		int mini=9999;
		if(i>=j||ispalin(s,i,j))
			return 0;
		if(t[i][j]!=-1)
			return t[i][j];
		for(int k=i;k<=j-1;k++)
		{
			if(t[i][k]!=-1)
			{
				int left=solve(s,i,k);
				t[i][k]=left;
			}
			if(t[k+1][j]!=-1)
			{
				int right=solve(s,k+1,j);
				t[k+1][j]=right;
			}
			
			int temp_ans=(1+solve(s,i,k)+solve(s,k+1,j));
			if(temp_ans<mini)
			{
				mini=temp_ans;
			}
			
		}
		return (t[i][j]=mini);
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
		String s="ukjdcoklnsjytafluzakzehwxyxhxrztbiwdyjrnbamxctkxvkjupsrosqvphuiiehocqfqtheqkzcjunupemiugy";
		int i=0;
		int j=s.length()-1;
		for(int k=0;k<1001;k++)
		{
			for(int l=0;l<1001;l++)
			{
				t[k][l]=-1;
			}
		}
		System.out.println(solve(s,i,j));

	}

}
