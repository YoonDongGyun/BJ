package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4344{
	static BufferedReader input;
	static StringTokenizer tokens;
	static int[] score;
	
	public static void main(String[] args) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		int C=0;
		try {
			C=Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<C;i++) {
			double avg=0;
			int count=0;
			tokens=new StringTokenizer(input.readLine());
			
			int n=Integer.parseInt(tokens.nextToken());
			score=new int[n];
			
			for(int r=0;r<n;r++) {
				score[r]=Integer.parseInt(tokens.nextToken());
				avg+=score[r];
			}
			
			avg/=n;
			
			for(int r=0;r<n;r++) {
				if(score[r]>avg) count++;
			}
			
			System.out.printf("%.3f%%%n",100.0*count/n);
		}
	}
}
