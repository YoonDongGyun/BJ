import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 16.
@see https://www.acmicpc.net/problem/2839
@performance 11520KB 76ms
@category #그리디 알고리즘
@note 전체적인 경우의 수를 고려하자
*/
public class BJ_02839{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		int result=Integer.MAX_VALUE;
		
		N=Integer.parseInt(input.readLine());
		
		if(N%3==0) {
			min=Math.min(min, N/3);
		}
		
		if(N%5==0) {
			min=Math.min(min, N/5);
		}
		
		
		for(int i=1;i<=N/5;i++) {
			int temp=N;
			temp-=5*i;
			
			if(temp%3!=0) continue;
			else {
				result=Math.min(result, i+temp/3);
			}
		}
		
		if(result!=Integer.MAX_VALUE) {
			min=Math.min(min, result);
		}
		else {
			if(min==Integer.MAX_VALUE) min=-1;
		}
		
		output.append(min);
		
		System.out.println(output);
	}
	
}