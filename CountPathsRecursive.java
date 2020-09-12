package dynamicprogramming;

public class CountPathsRecursive {

	public static int count_all_paths(int m,int n)
    {
        if(n==1||m==1)
        {
            return 1;
        }
        else
        {
            return (count_all_paths(n,m-1)+count_all_paths(n-1,m));
        }
        
    }
	public static void main(String[] args) 
	{
		int n=3;
	    int m=3;
	    System.out.println(count_all_paths(m,n));

	}

}
