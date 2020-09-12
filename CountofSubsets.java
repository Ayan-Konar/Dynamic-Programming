package dynamicprogramming;

public class CountofSubsets 
{
	public static int countofsubsets(int []arr,int sum,int n)
	{
		int [][]t=new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				if(i==0)
				{
					t[i][j]=0;
				}
				if(j==0)
				{
					t[i][j]=1;
				}
			}
		}
		
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(arr[i-1]<=j)
				{
					t[i][j]=(t[i-1][j-arr[i-1]])+(t[i-1][j]);
				}
				else if(arr[i-1]>j)
				{
					t[i][j]=(t[i-1][j]);
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) 
	{
		int sum=30;
		int arr[]=  {5, 10, 12, 13, 15, 18};
		int n=arr.length;
		System.out.println(countofsubsets(arr,sum,n));

	}

}
