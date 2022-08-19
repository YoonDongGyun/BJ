import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 19.
@see https://www.acmicpc.net/problem/1697
@performance 16880KB 120ms
@category #bfs
@note 
*/
public class BJ_01697{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K;
	static int max=100000;
	static int min=Integer.MAX_VALUE;
	
	static class Node{
		int num,time;

		private Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		
		bfs(new boolean[max+1], 0);
		
		output.append(min);
		
		System.out.println(min);
	}
	
	static void bfs(boolean[] visited, int time) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(new Node(N,time));
		visited[N]=true;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.num==K) {
				min=Math.min(min, current.time);
			}
			
			if(current.num*2<=max && !visited[current.num*2]) {
				visited[current.num*2]=true;
				queue.offer(new Node(current.num*2,current.time+1));
			}
			
			if(current.num+1<=max && !visited[current.num+1]) {
				visited[current.num+1]=true;
				queue.offer(new Node(current.num+1,current.time+1));
			}
			
			if(current.num-1>=0 && !visited[current.num-1]) {
				visited[current.num-1]=true;
				queue.offer(new Node(current.num-1,current.time+1));
			}
		}
	}
}