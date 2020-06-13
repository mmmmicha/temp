package com.test.blind2018.level1;

/*
 * 테스트명 : 비밀지도
 * 
 * @ Kwanghyeon
 * 
 * 
 * */

public class SecretMap
{
	public static String[] solution(int n, int[] arr1, int[] arr2)
	{
		String[] answer = {};
		
		int div1 = 0;
		int temp1 = 0;
		
		int div2 = 0;
		int temp2 = 0;
		
		answer = new String[arr1.length];
		
		System.out.println(answer.length);
		
		for(int i=0; i<arr1.length; i++)
		{
			div1 = arr1[i];
			div2 = arr2[i];
			
			answer[i] = "";
			
			for(int j=0; j<n; j++)
			{
				if(j==n-1 && arr1[i]>Math.pow(2, n) -1)
				{
					temp1 = 0;
				}
				else
				{
					temp1 = div1%2;
					div1 = div1/2;
				}
				
				if(j==n-1 && arr2[i]>Math.pow(2, n) -1)
				{
					temp2 = 0;
				}
				else
				{
					temp2 = div2%2;
					div2 = div2/2;
				}
				
				if(temp1 == 0 && temp2 == 0)
					answer[i] += " ";
				else
					answer[i] += "#";
				
			}
			answer[i] = new StringBuffer(answer[i]).reverse().toString();
			
		}

		return answer;
	}
	
	public static void main(String[] args)
	{
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		solution(5, arr1, arr2);
	}
}
