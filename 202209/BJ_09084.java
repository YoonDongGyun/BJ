import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 9. 15.
@see
@git
@performance
@category #
@note */
public class BJ_09084{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N,M;
	static int[] coins,count;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine());
		
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(input.readLine());
			coins= new int[N];
			
			tokens=new StringTokenizer(input.readLine());
			for(int i=0;i<N;i++) {
				coins[i]=Integer.parseInt(tokens.nextToken());
			}
			
			M=Integer.parseInt(input.readLine());
			count=new int[10001];
			
			for(int i=0;i<N;i++) {
				count[coins[i]]+=1;
				
				for(int j=coins[i]+1;j<=M;j++) {
					count[j]+=count[j-coins[i]];
				}
			}
			
			output.append(count[M]).append("\n");
		}
		
		System.out.println(output);
	}
	
}
