package com.test.blind2018.level3;

import java.util.HashMap;

/*
 * 테스트명 : 추석트래픽
 * 
 * @ Kwanghyeon
 * 
 * */

public class ThanksgivingTraffic
{
	public static int solution(String[] lines)
	{
		int answer = 0;
		
		double[][] result = new double[lines.length][2];
		
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>(); 
		
		for(int i=0; i<lines.length; i++)
		{
			result[i][1] = Double.parseDouble(lines[i].substring(17, 23));
			String temp = lines[i].substring(24);
			result[i][0] = result[i][1] - Double.parseDouble(temp.substring(0, temp.length()-1));
			
			if(res.containsKey((int)result[i][0]))
				res.put((int)result[i][0], res.get((int)result[i][0])+1);
			else
				res.put((int)result[i][0], 1);
			
			answer = Math.max(answer, res.get((int)result[i][0]));
			
		}
		
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
						  "2016-09-15 20:59:58.233 1.181s",
						  "2016-09-15 20:59:58.299 0.8s",};
		
		System.out.println(solution(lines));
		
	}
}
