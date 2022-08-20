import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 20.
@see https://www.acmicpc.net/problem/2407
@performance 11616KB 76ms
@category #큰 수 계산
@note 
*/
public class BJ_02407{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		
		
		output.append(calCombination(N,M));
		System.out.println(output);
	}
	
	static BigInteger calCombination(int n, int m) {
		BigInteger count=new BigInteger("1");
		BigInteger div= new BigInteger("1");
		
		if(m>n/2) {
			m=n-m;
		}
		
		for(long i=0;i<m;i++) {
			count=count.multiply(BigInteger.valueOf(n-i));
			div=div.multiply(BigInteger.valueOf(m-i));
		}
		
		return count.divide(div);
	}
	
	
	
}
