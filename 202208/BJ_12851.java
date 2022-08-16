import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 14.
@see https://www.acmicpc.net/problem/12851
@performance 86608KB 216ms
@category #bfs
@note bfs 숙련도를 조금 더 높이자
*/
public class BJ_12851{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int su,bro,min=Integer.MAX_VALUE,cnt=0;
	static int max=100000;//최대 값
	static boolean[] visited = new boolean[max+1];//방문 여부
	
	static class Node{
		int num;//위치
		int time;//시간
		
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		su=Integer.parseInt(tokens.nextToken()); //수빈 위치
		bro=Integer.parseInt(tokens.nextToken()); // 동생 위치
		
		bfs();
		output.append(String.format("%d%n",min));
		output.append(cnt);
		
		System.out.println(output);
		
	}
	
	//bfs 탐색
	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(su,0));//첫번째에 수빈 위치와 시간 저장
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			visited[current.num]=true;
			
			if(current.num==bro) {//동생이 있는 위치에 도착했다면
				
				if(min>current.time) {//최소값 비교
					min=current.time;//최소값 현재 시간으로 변경
					cnt=1;//방법의 수 1로 초기화
				}
				else if(min==current.time) {//최소값과 같다면
					cnt++;//방법의 수 증가
				}
			}
			
			if(current.num*2<=max && !visited[current.num*2]) { //순간이동
				queue.offer(new Node(current.num*2,current.time+1));//위치 2배로 이동 시간+1
			}
			
			if(current.num-1>=0 && !visited[current.num-1]) {//뒤로 한칸 이동
				queue.offer(new Node(current.num-1,current.time+1));//위치-1 시간+1
			}
			
			if(current.num+1<=max && !visited[current.num+1]) {//앞으로 한칸 이동
				queue.offer(new Node(current.num+1,current.time+1));//위치+1 시간+1
			}
		}
	}
}
