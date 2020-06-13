package com.test.blind2018.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/*
 * 테스트명 : 방금 그 곡
 * 
 * @ Kwanghyeon
 * 
 * */

public class JustNowThatSong
{
	public static String solution(String m, String[] musicinfos)
	{
		// 음악 진행시간
		int[] ingTime = new int[musicinfos.length];
		
		// 음악 제목
		String[] title = new String[musicinfos.length];
		
		// 음정
		String[] um = new String[musicinfos.length];
		
		// 조건 일치 제목
		int[] correct = new int[musicinfos.length];
		
		Arrays.fill(correct, 0);
		
		SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
		Date start;
		Date end;
		long diff;
		long minute;
		int maxTime=0;
		
		m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");
		
		for(int i=0; i<musicinfos.length; i++)
		{
			try
			{
				start = f.parse(musicinfos[i].split(",")[0]);
				end = f.parse(musicinfos[i].split(",")[1]);
				//System.out.println("start : " + start + ", end : " + end);
				diff = end.getTime() - start.getTime();
				minute = diff/60000;
				//System.out.println(minute);
				
				ingTime[i] = (int)minute;
				title[i] = musicinfos[i].split(",")[2];
				um[i] = "";
				
				int count = 0;
				
				String temp;
				
				for(int j=0; j<ingTime[i]; j++)
				{
					temp = musicinfos[i].split(",")[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");
					
					um[i] += temp.charAt(count++);
					
					if(count==temp.length())
						count=0;
				}
				
				//System.out.println(um[i]);
				
				if(um[i].contains(m))
				{
					correct[i] = 1;
				}
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
		}
		
		for(int i=0; i<musicinfos.length; i++)
		{
			if(correct[i]==1)
			{
				if(maxTime>=ingTime[i])
				{
					correct[i] = 0;
				}
				else
				{
					maxTime = ingTime[i];
				}
			}
		}
		
		for(int i=0; i<musicinfos.length; i++)
		{
			if(ingTime[i]==maxTime && correct[i]==1)
				return title[i];
		}
			
		
		return "(None)";
	}
	 
	public static void main(String[] args) throws ParseException
	{
		String m= "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		solution(m, musicinfos);
		
	}
}
