import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17069 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N;
	static int[][] map;
	static int[][] deltas = {{0,1},{1,0},{1,1}};
	
	//(r,c)에 d로 접근할 수 있는 경우의 수 
	static long[][][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		map= new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			tokens=new StringTokenizer(input.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}
		
		memo= new long[N+1][N+1][3];
		//최초는 (1,2)에서 가로방향
		memo[1][2][0]=1;
		
		for(int r=1;r<=N;r++) {
			for(int c=3;c<=N;c++) {
				if(map[r][c]==1) {
					continue;
				}
				
				 // 현재 지점에 가로로 온경우 - 이전 점이 가로로 왔거나 대각선으로 왔던 경우
                memo[r][c][0] = memo[r][c - 1][0] + memo[r][c - 1][2];
                // 현재 지점에 세로로 온 경우 -  이전 점이 세로로 왔거나 대각선으로 왔던 경우
                memo[r][c][1] = memo[r - 1][c][1] + memo[r - 1][c][2];
                // 현재 지점에 대각선으로 온 경우- 3가지 모두
                if (map[r - 1][c] == 0 && map[r][c - 1] == 0) {
                    memo[r][c][2] = memo[r - 1][c - 1][0] + memo[r - 1][c - 1][1] + memo[r - 1][c - 1][2];
                }
			}
		}
		
		long count=0;
		for(int i=0;i<3;i++) {
			count+=memo[N][N][i];
		}
		
		System.out.println(count);
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
