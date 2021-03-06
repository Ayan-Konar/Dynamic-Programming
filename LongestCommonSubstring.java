package dynamicprogramming;

public class LongestCommonSubstring 
{
	public static int lcsubstring(char []X,char []Y,int m,int n)
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
                    t[i][j]=0;
                }
            }
        }
        
        int max=0;
        
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(t[i][j]>max)
                {
                    max=t[i][j];
                }
            }
        }
        return max;
    }

	public static void main(String[] args) 
	{
		String x="Phillipines";
        String y="Philips";
        x=x.toLowerCase();
        y=y.toLowerCase();
        char []X=x.toCharArray();
        char []Y=y.toCharArray();
        int m=x.length();
        int n=y.length();
        System.out.println(lcsubstring(X,Y,m,n));

	}

}
