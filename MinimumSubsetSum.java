package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSum 
{

	public static int subsetsum(int []arr,int sum,int n)
	{
		boolean [][]t=new boolean[n+1][sum+1];
		/*for(int i=0;i<sum+1;i++)
		{
			t[0][i]=false;
		}
		for(int i=0;i<n+1;i++)
		{
			t[i][0]=true;
		}*/
		
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				if(i==0)
				{
					t[i][j]=false;
				}
				if(j==0)
				{
					t[i][j]=true;
				}
			}
		}
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(arr[i-1]<=j)
				{
					t[i][j]=t[i-1][j]||t[i-1][j-arr[i-1]];
				}
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		//return t[n][sum];
		List<Integer>l=new ArrayList<>();
		for(int i=0;i<=(sum)/2;i++)
		{
			if(t[n][i]==true)
			{
				l.add(i);
			}
		}
		
		int mn=9999;
		for(Integer i:l)
		{
			mn=Math.min(mn,sum-2*i);
		}
		return mn;
	}
	public static void main(String[] args) 
	{
		int arr[]= {36,7,46,40};
		int n=arr.length;
		int range=0;
		for(int i=0;i<arr.length;i++)
		{
			range+=arr[i];
		}
		System.out.println(subsetsum(arr,range,n));

	}

}
