package dynamicprogramming;

public class MCMRecursive 
{
	public static int solve(int []arr,int i,int j)
	{
		int min=99999;
		if(i>=j)
			return 0;
		for(int k=i;k<=j-1;k++)
		{
			int temp_ans=solve(arr,i,k)+solve(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
		if(temp_ans<min)
		{
			min=temp_ans;
		}
		}
		return min;
	}

	public static void main(String[] args) 
	{
		int []arr= {1,2,3,4};
		int i=1;
		int j=arr.length-1;
		System.out.println(solve(arr,i,j));

	}

}
