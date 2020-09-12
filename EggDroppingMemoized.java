package dynamicprogramming;

public class EggDroppingMemoized 
{
	static int [][]t=new int[1001][1001];
	public static int solve(int e,int f) 
	{
		if(f==0||f==1)
			return f;
		if(e==1)
			return f;
		
		if(t[e][f]!=-1)
			return t[e][f];
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++)
		{
			int temp_ans=1+Math.max(solve(e-1,k-1),solve(e,f-k));
			min=Math.min(min, temp_ans);
			
		}
		t[e][f]=min;
		return t[e][f];
	}
	public static void main(String[] args) 
	{
		int f=34;
		int e=3;
		for(int i=0;i<1001;i++)
		{
			for(int j=0;j<1001;j++)
			{
				t[i][j]=-1;
			}
		}
		System.out.println(solve(e,f));

	}

}
