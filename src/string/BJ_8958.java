package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8958 {
	static BufferedReader input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(input.readLine());
		
		for(int t=0;t<T;t++) {
			String line = input.readLine();
			int score=0,plus=0;
			
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i)=='O') {
					plus++;
					score+=plus;
				}
				else {
					plus=0;
				}
			}
			
			System.out.println(score);
		}
	}
}
