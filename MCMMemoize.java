package dynamicprogramming;

public class MCMMemoize 
{
	static int [][]t=new int[1001][1001];
	public static int solve(int []arr,int i,int j)
	{
		if(t[i][j]!=-1)
			return t[i][j];
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
		return (t[i][j]=min);
	}

	public static void main(String[] args) 
	{
		for(int i=0;i<1001;i++)
		{
			for(int j=0;j<1001;j++)
			{
				t[i][j]=-1;
			}
		}
		
		int []arr= {1,2,3,4,5};
		int i=1;
		int j=arr.length-1;
		System.out.println(solve(arr,i,j));

	}

}
