package dynamicprogramming;

public class EggDroppingRecursive 
{
	public static int solve(int e,int f) 
	{
		if(f==0||f==1)
			return f;
		if(e==1)
			return f;
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++)
		{
			int temp_ans=1+Math.max(solve(e-1,k-1),solve(e,f-k));
			min=Math.min(min, temp_ans);
			
		}
		return min;
		
	}

	public static void main(String[] args) {
		int f=34;
		int e=3;
		System.out.println(solve(e,f));
		

	}

}
