import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 23.
@see https://www.acmicpc.net/problem/1463
@performance 15716kb 104ms	
@category #DP
@note */
public class BJ_01463{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] count;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(input.readLine());
		
		count=new int[n+1];
		
		count[0]=0;
		count[1]=0;
		
		for(int i=2;i<n+1;i++) {
			count[i]=count[i-1]+1;
			
			if(i%3==0) {
				count[i]=Math.min(count[i], count[i/3]+1);
			}
			if(i%2==0) {
				count[i]=Math.min(count[i], count[i/2]+1);
			}
		}
		
		output.append(count[n]);
		
		System.out.println(output);
	}
	
	
}