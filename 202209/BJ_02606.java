import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_02606 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N, M, count=0;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		M=Integer.parseInt(input.readLine());
		visited= new boolean[N];
		graph= new int[N][N];
		
		for(int i=0;i<M;i++) {
			tokens= new StringTokenizer(input.readLine());
			int n1 = Integer.parseInt(tokens.nextToken())-1;
			int n2 = Integer.parseInt(tokens.nextToken())-1;
			
			graph[n1][n2]=1;
			graph[n2][n1]=1;
		}
		visited[0]=true;
		virus(0);
		
		System.out.println(count);
	}
	
	public static void virus(int n) {
		for(int i=0;i<N;i++) {
			if(graph[n][i]==1 && !visited[i]) {
				visited[i]=true;
				count++;
				virus(i);
			}
		}
		
		return;
	}
}
