package dynamicprogramming;

import java.util.HashMap;

public class ScrambledStringMemoized 
{
	static HashMap<String,Boolean>hm=new HashMap<>();
	public static boolean solve(String a,String b)
	{
		if(a.equals(b))
			return true;
		if(a.length()<=1||b.length()<=1)
			return false;
		
		String s="";
		s+=a+" "+b;
		if(hm.containsKey(s))
			return hm.get(s);
		
		boolean flag=false;
		int n=a.length();
		for(int i=1;i<=n-1;i++)
		{
			boolean cond1=solve(a.substring(0,i),b.substring(n-i,n))==true && solve(a.substring(i,n),b.substring(0,n-i))==true;
			boolean cond2=solve(a.substring(0,i),b.substring(0,i))==true && solve(a.substring(i,n),b.substring(i,n))==true;
			if(cond1||cond2)
				flag=true;
		}
		hm.put(s,flag);
		return hm.get(s);
	}

	public static void main(String[] args) 
	{
		String a="great";
		String b="rgeta";
		if(a.length()!=b.length())
			System.out.println(false);
		if(a=="" && b=="")
			System.out.println(true);
		System.out.println(solve(a,b));
			

	}

}
