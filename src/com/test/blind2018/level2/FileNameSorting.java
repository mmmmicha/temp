package com.test.blind2018.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 테스트명 : 파일명정렬
 * 
 * @ Kwanghyeon
 * 
 * */

// split 을 쓸 때 정규표현식을 응용해서 쪼갤수 있음.
// Character.isDigit 은 숫자인지 판별하는 메소드
public class FileNameSorting
{
	public String[] solution(String[] files)
	{
		String[] answer = {};
		
		ArrayList<String> fileName = new ArrayList<String>();
		ArrayList<String> number = new ArrayList<String>();
		ArrayList<String> alp = new ArrayList<String>();
		
		ArrayList<String> head = new ArrayList<String>(); 
		
		
		// 숫자 담기
		for(int i=0; i<=9; i++)
		{
			number.add(""+i);
		}
		
		char temp;
		
		// 알파벳(대문자 담기)
		for(int i=65; i<=90; i++)
		{	
			temp = (char)i;
			alp.add(""+temp);
		}
		
		for(int i=0; i<files.length; i++)
		{
			fileName.add(files[i].toUpperCase());
		}
		
		Collections.sort(fileName);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<fileName.size(); i++)
		{
			sb = new StringBuilder();
			for(int j=0; j<fileName.get(i).length(); j++)
			{
				if(number.contains(fileName.get(i).charAt(j)+""))
				{
					break;
				}
				sb.append(fileName.get(i).charAt(j)+"");
			}
			
			if(head.indexOf(sb.toString())==-1)
				head.add(sb.toString());
		}
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("0");
		arr.add("0011");
		arr.add("12");
		arr.add("32");
		arr.add("03");
		arr.add("41");
		arr.add("19");
		
		Collections.sort(arr);
		
		for(String i : arr)
			System.out.println(i);
	}
}
