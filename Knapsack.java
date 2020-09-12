package dynamicprogramming;
//Recursive code..
public class Knapsack 
{
static int knapsack(int[] weights,int []val,int W,int n)
{
	//Base Condition
	if(n==0||W==0)
		return 0;
	//If weight of the item is less than the total weight,then the item may be included may not be included.Select max of the two.
	if(weights[n-1]<=W)
		return Math.max((val[n-1]+knapsack(weights,val,W-weights[n-1],n-1)),knapsack(weights,val,W,n-1));
	//If weight of the item is greater than W
	else
		return knapsack(weights,val,W,n-1);
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
