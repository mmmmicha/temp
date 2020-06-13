package com.test.blind2018.level1;

/*
 * 테스트명 : 다트게임
 * 
 * @ Kwanghyeon
 * 
 * */

public class DartGame
{
	public static int solution(String dartResult)
	{
		int answer = 0;
		
		int[] three = new int[3];
		
		int count = 0;
		
		char temp = 0;
		
		for(int i=0; i<dartResult.length(); i++)
		{
			temp = dartResult.charAt(i);
			
			if(temp=='S')
				three[count-1] = (int)Math.pow(three[count-1],1);
			else if(temp=='D')
				three[count-1] = (int)Math.pow(three[count-1],2);
			else if(temp=='T')
				three[count-1] = (int)Math.pow(three[count-1],3);
			else if(temp=='*')
			{
				if(count==1)
					three[count-1] = three[count-1] * 2;
				else
				{
					three[count-2] = three[count-2] * 2;
					three[count-1] = three[count-1] * 2;
				}
			}
			else if(temp=='#')
				three[count-1] = -three[count-1];
			else
			{
				if(dartResult.charAt(i)-48 == 1 && dartResult.charAt(i+1)-48==0)
				{
					three[count++] = temp-39;
					i++;
				}
				else
					three[count++] = temp-48;
			}
				
			
			//System.out.println("int : " + three[count-1]);
				
		}
		
		answer = three[0] + three[1] + three[2];
		
		//System.out.println("answer : " + answer);
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		String dartResult = "1D2S#10S";
		
		solution(dartResult);
		
	}
}
