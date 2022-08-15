
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 11.
@see
@performance
@category #
@note */
public class BJ_13549{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K;
	static int min=Integer.MAX_VALUE; //시간 비교 위한 최소값
	static int max=100000;//N과 K 범위 내에서 가장 최대값
	static boolean[] visited= new boolean [max+1];//방문여부 
	
	public static class Node{
		int num;
		int time;
		
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());//시작 위치
		K=Integer.parseInt(tokens.nextToken());//도착 위치
		
		bfs();
		System.out.println(min);
	}
	
	static void bfs() {
		Queue <Node> queue = new LinkedList<>();
		queue.offer(new Node(N,0));//시작하는 위치를 지정하고 시간을 0으로 만들고 시작
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			visited[current.num]=true;
			if(current.num==K) min=Math.min(min, current.time);//도착지점에 도착하면 최소값 적용
			
			if(current.num*2<=max && !visited[current.num*2]) {//순간이동
				queue.offer(new Node(current.num*2,current.time));//순간이동은 시간 소요가 없으므로 위치만 바꿔준다
			}
			if(current.num+1<=max && !visited[current.num+1]) {//앞으로 1만큼 이동
				queue.offer(new Node(current.num+1,current.time+1));//시간은 1소요된다
			}
			if(current.num-1>=0 && !visited[current.num-1]) {//뒤로 1만큼 이동
				queue.offer(new Node(current.num-1,current.time+1));//시간은 1소요된다.
			}
			
		}

	}
}