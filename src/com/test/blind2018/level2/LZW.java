package com.test.blind2018.level2;

import java.util.ArrayList;

/*
 * 테스트명 : 압축
 * 
 * @ Kwanghyeon
 * 
 * */

public class LZW
{
	public static int[] solution(String msg)
	{
		
		ArrayList<String> voca = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		char alp;
		for(int i=65; i<=90; i++)
		{
			alp = (char)i;
			voca.add(""+alp);
		}
		
		int count = 0;
		
		for(int i=0; i<msg.length(); i++)
		{
			
			if(voca.contains(msg.substring(i,i+1)))
			{
				if(i==msg.length()-1)
				{
					index.add(voca.indexOf(msg.substring(i))+1);
					break;
				}
				
				count = 2;
				
				while(i+count<msg.length() && voca.contains(msg.substring(i,i+count)))
				{
					count++;
				}
				//System.out.println("length : " + msg.length() + ", i+count : " + (i+count));
				voca.add(msg.substring(i, i+count));
				
				index.add(voca.indexOf(msg.substring(i, i+count-1)) + 1);
				
				if(count>=3)
				{
					i = i+count-2;
				}
				
			}
					
		}
		
		int[] answer = new int[index.size()];
		
		for(int i=0; i<index.size(); i++)
		{
			answer[i] = index.get(i);
			System.out.println("answer : " + answer[i]);
		}
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		
		solution(msg);
		
	}
}
