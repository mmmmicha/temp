package com.test.blind2018.level2;

import java.util.HashMap;
import java.util.Iterator;

/*
 * 테스트명 : 뉴스클러스터링
 * 
 * @ Kwanghyeon
 * 
 * */

public class NewsClustering
{
	public static int solution(String str1, String str2)
	{
		int answer = 0;
		
		HashMap<String, Integer> max = new HashMap<String, Integer>();
		HashMap<String, Integer> min = new HashMap<String, Integer>();
		
		HashMap<String,Integer> arr1 = new HashMap<String,Integer>();
		HashMap<String,Integer> arr2 = new HashMap<String,Integer>();
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		for(int i=0; i<str1.length()-1; i++)
		{
			if(str1.charAt(i)>=97 && str1.charAt(i)<=122 && str1.charAt(i+1)>=97 && str1.charAt(i+1)<=122)
			{
				if(arr1.containsKey("" + str1.charAt(i) + str1.charAt(i+1)))
					arr1.put("" + str1.charAt(i) + str1.charAt(i+1), arr1.get("" + str1.charAt(i) + str1.charAt(i+1))+1);
				else
					arr1.put("" + str1.charAt(i) + str1.charAt(i+1), 1);
				
				System.out.println("arr1 : " + "" + str1.charAt(i) + str1.charAt(i+1));
			}
				
		}
		
		for(int i=0; i<str2.length()-1; i++)
		{
			if(str2.charAt(i)>=97 && str2.charAt(i)<=122 && str2.charAt(i+1)>=97 && str2.charAt(i+1)<=122)
			{
				if(arr2.containsKey("" + str2.charAt(i) + str2.charAt(i+1)))
					arr2.put("" + str2.charAt(i) + str2.charAt(i+1), arr2.get("" + str2.charAt(i) + str2.charAt(i+1))+1);
				else
					arr2.put("" + str2.charAt(i) + str2.charAt(i+1), 1);
				
				System.out.println("arr2 : " + "" + str2.charAt(i) + str2.charAt(i+1));
			}
			
		}
		
		Iterator<String> it1 = arr1.keySet().iterator();
		Iterator<String> it2 = arr2.keySet().iterator();
		
		String tempKey = null;
		
		if(arr1.size()>=arr2.size())
		{
			max = new HashMap<String, Integer>(arr1);
			
			while(it2.hasNext())
			{
				tempKey = it2.next();
				
				if(max.containsKey(tempKey))
				{
					if(arr2.get(tempKey)>max.get(tempKey))
					{
						min.put(tempKey, max.get(tempKey));
						max.put(tempKey, arr2.get(tempKey));
					}
					else
					{
						min.put(tempKey, arr2.get(tempKey));
					}
				}
				else
				{
					max.put(tempKey, arr2.get(tempKey));
				}
			}
		}
		else if(arr1.size()<arr2.size())
		{
			max = new HashMap<String, Integer>(arr2);
			
			while(it1.hasNext())
			{
				tempKey = it1.next();
				
				if(max.containsKey(tempKey))
				{
					if(arr1.get(tempKey)>max.get(tempKey))
					{
						min.put(tempKey, max.get(tempKey));
						max.put(tempKey, arr1.get(tempKey));
					}
					else
					{
						min.put(tempKey, arr1.get(tempKey));
					}
				}
				else
				{
					max.put(tempKey, arr1.get(tempKey));
				}
			}
		}
		
		int minValue = 0;
		int maxValue = 0;
		
		Iterator<String> max1 = max.keySet().iterator();
		Iterator<String> min1 = min.keySet().iterator();
		
		while(max1.hasNext())
		{
			maxValue += max.get(max1.next());
		}
		
		while(min1.hasNext())
		{
			minValue += min.get(min1.next());
		}
		
		if(minValue==0 && maxValue==0)
			answer = 65536;
		else
			answer = (int)((minValue/(double)maxValue)*65536);
		
		System.out.println("min : " + minValue + ", max : " + maxValue + ", answer : " + answer);
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		solution(str1, str2);
		
	}
}
