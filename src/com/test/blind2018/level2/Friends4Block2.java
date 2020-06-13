package com.test.blind2018.level2;

import java.util.Arrays;

/*
 * 테스트명 : 프렌즈4블록2
 * 
 * @ Kwanghyeon
 * 
 * */

public class Friends4Block2
{
	public static int solution(int m, int n, String[] board)
	{
		
		int[] destroyBoardCheck = new int[m*n];
		char[] destroyBoard = new char[m*n];
		
		int count = 0;
		int maxCount = 0;
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				destroyBoard[i*n+j] = board[i].charAt(j);
			}
		}
		
		Arrays.fill(destroyBoardCheck, 0);
		
		while(true)
		{
			count = 0;
			
			for(int i=0; i<m-1; i++)
			{
				for(int j=0; j<n-1; j++)
				{
					if(destroyBoard[i*n+j] != ' ' && destroyBoard[i*n+j]==destroyBoard[(i+1)*n+j] 
							&& destroyBoard[i*n+j]==destroyBoard[(i+1)*n+j+1]
									&& destroyBoard[i*n+j]==destroyBoard[i*n+j+1])
					{
						destroyBoardCheck[i*n+j] = 1;
						destroyBoardCheck[(i+1)*n+j] = 1;
						destroyBoardCheck[i*n+j+1] = 1;
						destroyBoardCheck[(i+1)*n+j+1] = 1;
					}
				}
			}
			
			for(int i=0; i<m; i++)
			{
				for(int j=0; j<n; j++)
				{
					if(destroyBoardCheck[i*n+j] == 1)
					{
						count += 1;
						destroyBoard[i*n+j] = ' ';
					}
				}
			}
			
			if(count == 0)
				break;
			
			maxCount += count;
			for(int i=m-1; i>0; i--)
			{
				for(int j=0; j<n; j++)
				{
					for(int k=0; k<=i; k++)
					{
						if(destroyBoard[i*n+j]!=' ')
						{
							break;
						}
						else if(destroyBoard[(i-k)*n + j] != ' ')
						{
							destroyBoard[i*n+j] = destroyBoard[(i-k)*n + j];
							destroyBoard[(i-k)*n + j]= ' ';
							break;
							
						}
					}
				}
			}
			
			
			
		}
		
		return maxCount;
		
		
	}
	
}
