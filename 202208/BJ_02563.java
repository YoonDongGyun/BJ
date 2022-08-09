
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 9.
@see https://www.acmicpc.net/problem/2563
@performance 11640kb 80ms
@category #배열
@note */
public class BJ_02563{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] page=new int[100][100];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		for (int t = 0; t < N; t++) {
			tokens=new StringTokenizer(input.readLine());
			
			int x=Integer.parseInt(tokens.nextToken());
			int y=90-Integer.parseInt(tokens.nextToken());
			
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					page[i][j]=1;
				}
			}
		}
		int cnt=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(page[i][j]==1) {
					cnt+=1;
				}
			}
		}
		System.out.println(cnt);
	}
	
}
