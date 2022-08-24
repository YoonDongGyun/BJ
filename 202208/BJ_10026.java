import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 24.
@see
@performance
@category #
@note */
public class BJ_10026 {
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	static int count1,count2;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		map=new char[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			map[i]=input.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count1++;
				}
			}
		}
		
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count2++;
				}
				
			}
		}
		
		System.out.printf("%d %d%n",count1,count2);
	}
	
	static void dfs(int r, int c) {
		visited[r][c]=true;
		char word=map[r][c];
		
		for(int i=0;i<deltas.length;i++) {
			int nr=r+deltas[i][0];
			int nc=c+deltas[i][1];
			
			if(!isIn(nr,nc)) continue;
			
			if(!visited[nr][nc] && map[nr][nc]==word) {
				visited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}