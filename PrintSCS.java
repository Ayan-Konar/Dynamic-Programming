package dynamicprogramming;

public class PrintSCS 
{
	public static String scs(char[]X,char[]Y,int m,int n)
	{
		int [][]t=new int[m+1][n+1];
		for(int i=0;i<m+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
				}
			}
		}
		
		for(int i=1;i<m+1;i++) 
		{
			for(int j=1;j<n+1;j++)
			{
				if(X[i-1]==Y[j-1])
				{
					t[i][j]=1+t[i-1][j-1];
				}
				else
				{
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
				}
			}
			
		}
		
		int i=m,j=n;
		String s="";
		while(i>0&&j>0)
		{
			if(X[i-1]==Y[j-1])
			{
				s+=X[i-1];
				i--;
				j--;
			}
			else
			{
				
				
				if(t[i-1][j]>t[i][j-1])
				{
					s+=X[i-1];
					i--;
				}
				else
				{
					s+=Y[j-1];
					j--;
				}
			}
		}
		while(i>0)
		{
			s+=X[i-1];
			i--;
		}
		while(j>0)
		{
			s+=Y[j-1];
			j--;
		}
		StringBuffer sb=new StringBuffer(s);
		return sb.reverse().toString();
	}

	public static void main(String[] args) 
	{

		String x="agfuy";
		String y="ACDFRETSG";
		x=x.toLowerCase();
		y=y.toLowerCase();
		char []X=x.toCharArray();
		char []Y=y.toCharArray();
		int m=x.length();
		int n=y.length();
		System.out.println(scs(X,Y,m,n));


	}

}
