package dynamicprogramming;

public class MemoizeKnapsack 
{
	 static int [][]t=new int[100][100];

	static int knapsack(int[] weights,int []val,int W,int n)
	{
		//Base Condition
		if(n==0||W==0)
			return 0;
		if(t[n][W]!=-1)
			return t[n][W];
		//If weight of the item is less than the total weight,then the item may be included may not be included.Select max of the two.
		if(weights[n-1]<=W)
			t[n][W]=Math.max((val[n-1]+knapsack(weights,val,W-weights[n-1],n-1)),knapsack(weights,val,W,n-1));
		//If weight of the item is greater than W
		else
			t[n][W]=knapsack(weights,val,W,n-1);
		return t[n][W];
	}
	public static void main(String[] args) 
	{
		int W=9;
		int weights[]= {1,3,4,5};
		int val[]= {1,4,5,7};
		int n=weights.length;
		
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				t[i][j]=-1;
			}
		}
		System.out.println(knapsack(weights,val,W,n));
		

	}

}
