import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 26.
@see
@performance
@category #
@note */
public class BJ_13458{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,B,C;
	static int[] people;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		long count=0;
		
		N=Integer.parseInt(input.readLine());
		people=new int[N];
		
		tokens=new StringTokenizer(input.readLine());
		for(int i=0;i<N;i++) {
			people[i]=Integer.parseInt(tokens.nextToken());
		}
		
		tokens=new StringTokenizer(input.readLine());
		
		B=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		
		for(int i=0;i<N;i++) {
			people[i]-=B;
			count++;
			
			if(people[i]>0) {
				if(people[i]%C==0) {
					count+=people[i]/C;
				}
				else {
					count+=people[i]/C+1;
				}
			}
		}
		
		System.out.println(count);
	}
	
	
}
