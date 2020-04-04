package com.test;

/*
 * 테스트명 : 캐시
 * 
 * @ Kwanghyeon
 * 
 * */

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Cache
{
	public static int solution(int cacheSize, String[] cities)
	{
		int answer = 0;
		
		LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>();
		
		Iterator<String> it = null;
		
		for(int i=0; i<cities.length; i++)
		{
			cities[i] = cities[i].toLowerCase();
		}
		
		for(int i=0; i<cities.length; i++)
		{
			
			if(cache.containsKey(cities[i]))
			{
				cache.remove(cities[i]);
				cache.put(cities[i], 1);
				
				answer += 1;
			}
			else if(cache.size()==cacheSize)
			{
				it = cache.keySet().iterator();
				String tempKey = it.next();
				
				System.out.println("tempKey : " + tempKey);
				
				if(it.hasNext())
					cache.remove(tempKey);
				
				cache.put(cities[i], 1);
				answer += 5;
			}
			else
			{
				cache.put(cities[i], 1);
				answer += 5;
			}
			System.out.println("cities : " + cities[i] + ", answer : " + answer);
				
		}
		
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize = 3;
		
		solution(cacheSize, cities);
		
	}
	
}
