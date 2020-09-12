package dynamicprogramming;

public class KnapsackTopDown 
{
	static int knapsack(int[] weights,int []val,int W,int N)
	{
		int [][]t=new int[N+1][W+1];
		
		for(int i=0;i<N+1;i++)
		{
			for(int j=0;j<W+1;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
				}
			}
		}
		
		for(int i=1;i<N+1;i++)
		{
			for(int j=1;j<W+1;j++)
			{
				if(weights[i-1]<=j)
				{
					t[i][j]=Math.max((val[i-1]+t[i-1][j-weights[i-1]]), t[i-1][j]);
				}
				else if(weights[i-1]>j)
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[N][W];
	}

	public static void main(String[] args) 
	{
		int W=9;
		int weights[]= {1,3,4,5};
		int val[]= {1,4,5,7};
		int n=weights.length;
		System.out.println(knapsack(weights,val,W,n));

	}

}
