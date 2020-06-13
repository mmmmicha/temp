package com.test.blind2018.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 테스트명 : 파일명정렬2
 * 
 * @ Kwanghyeon
 * 
 * */

// split 을 쓸 때 정규표현식을 응용해서 쪼갤수 있음.
// Character.isDigit 은 숫자인지 판별하는 메소드
// Comparable 은 객체에 implements 해서 사용
// Comparator 는 annonymous class 로 sort 내 파라미터로 설정
public class FileNameSorting2
{
	public static String[] solution(String[] files)
	{
		String[] answer = sort(files);
		
		for(String a : answer)
			System.out.println(a);

		return answer;
	}

	public static String[] sort(String[] input) 
	{
	    Arrays.sort(input, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) 
	        {
	            // 첫번째 오브젝트 head, num 추출
	            String head1 = s1.split("[0-9]")[0];
	            s1 = s1.replace(head1, "");
	            head1 = head1.toUpperCase();
	            
	            String tempNum = "";
	            for(char c : s1.toCharArray()) 
	            {
	                if(Character.isDigit(c) && tempNum.length() < 5) 
	                {
	                    tempNum += c;
	                } else 
	                {
	                    break;
	                }
	            }
	            int num1 = Integer.parseInt(tempNum);
	            
	            // 두번째 오브젝트 head, num 추출
	            String head2 = s2.split("[0-9]")[0];
	            s2 = s2.replace(head2, "");
	            head2 = head2.toUpperCase();
	            
	            tempNum = "";
	            for(char c : s2.toCharArray()) 
	            {
	                if(Character.isDigit(c) && tempNum.length() < 5) 
	                {
	                    tempNum += c;
	                } else 
	                {
	                    break;
	                }
	            }
	            int num2 = Integer.parseInt(tempNum);
	            
	            // 비교 처리
	            return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2); 
	        }
	    });
	    
	    return input;
	}
	
	public static void main(String[] args)
	{
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		solution(files);
		
	}

}
