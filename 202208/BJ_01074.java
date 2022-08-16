import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 16.
@see https://www.acmicpc.net/problem/1074
@performance 11568KB 84ms
@category #분할 정복 #재귀
@note 재귀와 분할 정복 활용법 확실히 숙지하자
*/
public class BJ_01074{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int cnt;
	static int[][] deltas = {{0,1}, {-1,-1},{0,1}};
	static int start_x=1,start_y=1;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		int N=Integer.parseInt(tokens.nextToken());
		int r=Integer.parseInt(tokens.nextToken());
		int c=Integer.parseInt(tokens.nextToken());
		
		int max_size=(int) Math.pow(2, N);
		
		calCnt(max_size,r,c);
		
		output.append(cnt);
		
		System.out.println(output);
	}
	
	static void calCnt(int size, int r, int c) {
		if (size==1) return;
		
		if(r<size/2 && c<size/2) {
			calCnt(size/2,r,c);
		}
		else if(r<size/2 && c>= size/2) {
			cnt+=size*size/4;
			calCnt(size/2,r,c-size/2);
		}
		else if(r>=size/2 && c<size/2) {
			cnt+=size*size/2;
			calCnt(size/2,r-size/2,c);
		}
		else if(r>=size/2 && c>=size/2) {
			cnt+=size*size*0.75;
			calCnt(size/2,r-size/2,c-size/2);
		}
	}
}
