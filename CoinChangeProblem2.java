package dynamicprogramming;
//Minimize the no of coins
public class CoinChangeProblem2 
{
	public static int unboundedknapsack(int []coins,int sum,int n)
	{
		final int INT_MAX=Integer.MAX_VALUE-1;
		int [][]t=new int[n+1][sum+1];
		for(int j=0;j<sum+1;j++)
		{
			t[0][j]=INT_MAX-1;
		}
		for(int i=1;i<n+1;i++)
		{
			t[i][0]=0;
		}
		for(int j=1;j<sum+1;j++)
		{
			if(j%coins[0]==0)
			{
				t[1][j]=j/coins[0];
			}
			else
			{
			t[1][j]=INT_MAX-1;
			}
		}
		for(int i=2;i<n+1;i++)
		{
			for(int j=2;j<sum+1;j++)
			{
				if(coins[i-1]<=j)
				{
					t[i][j]=Math.min(t[i-1][j],1+t[i][j-coins[i-1]]);
				}
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) 
	{
		int []coin= {1,2,6,4};
		int n=coin.length;
		int sum=10;
		int min_coins=unboundedknapsack(coin,sum,n);
		System.out.println(min_coins);

	}

}
