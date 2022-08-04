package com.ssafy.live0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @author itsme
 * @see https://www.acmicpc.net/status?user_id=ydg8732&problem_id=2164&from_mine=1
 * @performance 16120kb	112ms
 * @memo 시간 복잡도 파악해서 문제 풀자 배열간 이동보다 인덱스 활용해서 풀면 훨씬 속도가 빠름
 * 
 */

public class BJ_02164 {
	
	static BufferedReader input;
	static int N;
	static int[] cards;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		
		N=Integer.parseInt(input.readLine());
		cards = new int[2*N];
		
		int start_idx=1;
		int end_idx=N;
		
		for(int i=1;i<=N;i++) {
			cards[i]=i;
		}
		int cnt=N;
		
		while(cnt>1) {
			cnt--;
			start_idx++;
			
			cards[end_idx+1] = cards[start_idx];
			start_idx++;
			end_idx++;
		}
		
		System.out.println(cards[start_idx]);
	}

}
