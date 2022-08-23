import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 23.
@see https://www.acmicpc.net/problem/1197
@performance 57184kb 600ms
@category #MST
@note 프림 알고리즘 숙지하자
*/
public class BJ_01197{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V,E;
	static List<Node>[] graph;
	
	static class Node implements Comparable<Node>{
		int no;
		long cost;

		private Node(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		V=Integer.parseInt(tokens.nextToken());
		E=Integer.parseInt(tokens.nextToken());
		
		graph=new ArrayList[V+1];
		
		for(int i=0;i<=V;i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			tokens=new StringTokenizer(input.readLine());
			int A=Integer.parseInt(tokens.nextToken());
			int B=Integer.parseInt(tokens.nextToken());
			long C=Long.parseLong(tokens.nextToken());
			
			graph[A].add(new Node(B,C));
			graph[B].add(new Node(A,C));
		}
		
		prim();
		System.out.println(output);
	}
	
	static void prim() {
		long totalCost=0;
		PriorityQueue<Node> pq= new PriorityQueue<>();
		
		boolean[] visited = new boolean[V+1];
		int nodeCnt=0;
		
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node minCostHead = pq.poll();
			
			if(visited[minCostHead.no]) continue;
			
			visited[minCostHead.no]=true;
			totalCost+=minCostHead.cost;
			nodeCnt++;
			
			if(nodeCnt==V) break;
			
			List<Node> children = graph[minCostHead.no];
			
			for(int i=0;i<children.size();i++) {
				if(!visited[children.get(i).no]) {
					pq.offer(new Node(children.get(i).no,children.get(i).cost));
				}
			}
		}
		
		output.append(totalCost);
	}
	
}
