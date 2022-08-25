import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 25.
@see https://www.acmicpc.net/problem/10971
@performance 12204KB 256ms
@category #dfs
@note */
public class BJ_10971{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		map=new int[N][N];
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(input.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			visited=new boolean[N];
			visited[i]=true;
			dfs(i,i,0,1);
		}
		
		System.out.println(min);
	}
	static void dfs(int start,int current, int cost,int count) {
		if(count==N) {
			if(map[current][start]!=0) {
				cost+=map[current][start];
				min=Math.min(min, cost);
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && map[current][i]>0) {
				visited[i]=true;
				dfs(start,i,cost+map[current][i],count+1);
				visited[i]=false;
			}
		}
	}
}
