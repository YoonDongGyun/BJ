import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 17.
@see https://www.acmicpc.net/problem/1992
@performance 11688kb 80ms
@category #분할 정복 #재귀
@note 분할 정복, 재귀 문제 많이 풀어보자
*/
public class BJ_01992{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			String line=input.readLine();
			for(int c=0;c<N;c++) {
				map[r][c]= line.charAt(c)-'0';
			}
		}
		
		zipVideo(0,0,N);
		
		System.out.println(output);
	}
	
	static void zipVideo(int r, int c, int size) {
		
		if(canZip(r,c,size)) {
			output.append(map[r][c]);
			return;
		}
		
		output.append("(");
		
		//sector 1
		zipVideo(r,c,size/2);
		
		//sector 2
		zipVideo(r,c+size/2,size/2);
		
		//sector 3
		zipVideo(r+size/2,c,size/2);
		
		//sector 4
		zipVideo(r+size/2,c+size/2,size/2);
		
		output.append(")");
	}
	
	static boolean canZip(int r, int c, int size) {
		int temp=map[r][c];
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(temp!=map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
