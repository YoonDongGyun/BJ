package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11720 {
	static BufferedReader input;
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(input.readLine());
		int sum=0;
		
		String line=input.readLine();
		
		for(int i=0;i<N;i++) {
			sum+=line.charAt(i)-'0';
		}
		
		
		System.out.println(sum);
	}
}
