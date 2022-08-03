package off0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 @author itsme
 @see https://www.acmicpc.net/problem/11659
 @performance 71448kb	1980ms
 @category 구간합
 @memo 시간 제한이 빠듯하다 단순히 for문을 사용해서 구간합을 구하는 것이 아니라 구간 별 합을 미리 배열에 저장해놓고 구간 별합의 차를 통해 원하는 구간의 합을 구할 수 있다.
 */

public class BJ_11659 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int N,M;
	static int[] nums;
	static int[] sums;
	
	public static void main(String[] args) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		nums=new int[N+1];
		sums=new int[N+1];
		tokens=new StringTokenizer(input.readLine());
		for(int i=1;i<=N;i++) {
			nums[i]=Integer.parseInt(tokens.nextToken());
			sums[i]=sums[i-1]+nums[i];
			
		}
		
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(input.readLine());
			int idx1=Integer.parseInt(tokens.nextToken());
			int idx2=Integer.parseInt(tokens.nextToken());
			
			System.out.println(sums[idx2]-sums[idx1-1]);
		}
	}
}
