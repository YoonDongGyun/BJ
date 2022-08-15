import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 15.
@see https://www.acmicpc.net/problem/1260
@performance 25320kb	392ms
@category #dfs #bfs
@note dfs, bfs 적용하는 방법 확실히 숙지하자
*/
public class BJ_01260{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,V;
	static int[][] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken()); //정점 개수
		M=Integer.parseInt(tokens.nextToken()); //간선 개수
		V=Integer.parseInt(tokens.nextToken()); //시작 점
		
		nodes=new int[N+1][N+1];
		visited=new boolean[N+1];

		
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(input.readLine());
			
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			nodes[n1][n2]=1;
			nodes[n2][n1]=1; //간선 양방향 연결
			
		}
		
		dfs(V); //dfs
		
		visited=new boolean[N+1];//visited 초기화
		
		bfs(); //bfs
		System.out.println(output);//결과 출력
	}
	static void dfs(int point) {
		visited[point]=true;//방문으로 변경
		output.append(String.format("%d ", point));//방문한 노드 저장
		
		for(int i=1;i<=N;i++) {
			if(nodes[point][i]==1 && !visited[i]) {//노드가 간선으로 연결되어 있고 아직 방문하지 않았다면
				dfs(i);//재귀를 통해 이전과정 반복
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);//시작점 queue에 저장
		output.append("\n");
		output.append(String.format("%d ", V));
		
		while(!queue.isEmpty()) {
			int current = queue.poll();//현재 노드 저장
			
			visited[current]=true;//현재 노드 방문 처리
			
			for(int i=1;i<=N;i++) {
				if(nodes[current][i]==1 && !visited[i]) {//노드가 간선으로 연결되어 있고 아직 방문하지 않았다면
					visited[i]=true;//방문으로 변경
					queue.offer(i);//queue에 노드 저장
					output.append(String.format("%d ", i));
				}
			}
		}
	}
	
}