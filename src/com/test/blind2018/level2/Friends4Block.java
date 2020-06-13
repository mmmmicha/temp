package com.test.blind2018.level2;

/*
 * 테스트명 : 프렌즈4블록
 * 
 * @ Kwanghyeon
 * 
 * */

import java.util.ArrayList;

class Bingo
{
	public int x;
	public int y;
	
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
	
}

public class Friends4Block
{
	public static int solution(int m, int n, String[] board)
	{
		int answer = 0;
		
		String[] line = null;
		ArrayList<String[]> arr = new ArrayList<String[]>();
		ArrayList<Bingo> bingo = new ArrayList<Bingo>();
		
		boolean checking = true;
		
		
		// 배열로 쭉 정리하기
		for(int i=0; i<m; i++)
		{
			line = new String[n];
			
			for(int j=0; j<n; j++)
			{
				line[j] = board[i].substring(j, j+1);
			}
			
			arr.add(line);
		}
		
		System.out.println(arr.size());
		
		Bingo bingo1 = null;
		
		for(int i=0; i<arr.size()-1; i++)
		{
			for(int j=0; j<line.length-1; j++)
			{
				System.out.println(arr.get(i)[j].equals(arr.get(i)[j+1]) && arr.get(i)[j].equals(arr.get(i+1)[j]) && arr.get(i)[j].equals(arr.get(i+1)[j+1]));
				if(arr.get(i)[j].equals(arr.get(i)[j+1]) && arr.get(i)[j].equals(arr.get(i+1)[j]) && arr.get(i)[j].equals(arr.get(i+1)[j+1]))
				{
					System.out.println("몇번?");
					System.out.println("bingo size : " + bingo.size());
					
					answer += 4;
					
					int size = bingo.size();
					
					for(int z=0; z<size; z++)
					{
						if(bingo.isEmpty())
							break;
						
						if(bingo.get(z).getX() <= i && bingo.get(z).getX()+1 >= i && bingo.get(z).getY() <= j && bingo.get(z).getY()+1 >= j)
						{
							answer -= 1;
							
							bingo1 = new Bingo();
							
							bingo1.setX(i);
							bingo1.setY(j);
							
							bingo.add(bingo1);
							
							bingo1 = null;
							
							checking = false;
							
							System.out.println(bingo.size());
							
							System.out.println("빙고");
						}
						
					}
					
					if(checking)
					{
						bingo1 = new Bingo();
						bingo1.setX(i);
						bingo1.setY(j);
						
						bingo.add(bingo1);
						
						bingo1 = null;
						
					}
					
					checking = true;
					
				}
			}
			
		}
		
		System.out.println("bingo : " + bingo.size() + ", answer : " + answer);
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		int m=6;
		int n=6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		solution(m, n, board);
		
	}
}
