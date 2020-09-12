package dynamicprogramming;

import java.util.HashMap;


public class BooleanParenthizationMemoized 
{
	static HashMap<String,Integer>hmap=new HashMap<>();
	public static int solve(char []s,int i,int j,boolean isTrue)
	{
		int ans=0;
		if(i>j)
			return 0;
		if(i==j)
		{
			if(isTrue==true)
			{
				if(s[i]=='T')
					return 1;
				else
					return 0;
			}
			else
			{
				if(s[i]=='F')
					return 1;
				else
					return 0;
			}
		}
		
		String temp=i+" "+j+" "+isTrue;
		if(hmap.containsKey(temp))
			return hmap.get(temp);
		
		for(int k=i+1;k<=j-1;k=k+2)
		{
			int LT=solve(s,i,k-1,true);
			int LF=solve(s,i,k-1,false);
			int RT=solve(s,k+1,j,true);
			int RF=solve(s,k+1,j,false);
			
			if(s[k]=='&')
			{
				if(isTrue==true)
				{
					ans+=LT*RT;
				}
				else
				{
					ans+=LT*RF+LF*RT+LF*RF;
				}
			}
			else if(s[k]=='|')
			{
				if(isTrue==true)
				{
					ans+=LT*RT+LT*RF+LF*RT;
				}
				else
				{
					ans+=LF*RF;
				}
			}
			else
			{
				if(isTrue==true)
				{
					ans+=LT*RF+LF*RT;
				}
				else
				{
					ans+=LT*RT+LF*RF;
				}
			}
			
			
		}
		hmap.put(temp,ans);
		return hmap.get(temp);
	}

	public static void main(String[] args) 
	{
		String s="T|T&F^T";
		int i=0;
		int j=s.length()-1;
		char [] x=s.toCharArray();
		System.out.println(solve(x,i,j,true));

	}

}
