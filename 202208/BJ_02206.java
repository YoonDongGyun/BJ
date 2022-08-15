import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_02206{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		tokens=new StringTokenizer(input.readLine());
		boolean decide = false;
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		//시작하는 좌표와 도착 좌표가 동일한 경우
		if(N==1 && M==1) {
			System.out.println("1");
		}
		else {
			String[][] map = new String[N][M]; // 지도 저장
			int[][] distance = new int [N][M]; //거리 저장
			boolean[][][] visited = new boolean [2][N][M];
			Queue<int[]> queue = new LinkedList<>();
			
			//지도 정보 저장
			for(int i=0;i<N;i++) {
				map[i]=input.readLine().split("");
			}
			
			//시작 (x좌표, y좌표, 벽을 부순적이 있는지 여부)
			queue.offer(new int[] {0,0,0});
			
			outer: while(!queue.isEmpty()) {
				int[] current = queue.poll();
				
				for(int i=0;i<deltas.length;i++) {
					int nr = current[0]+deltas[i][0];
					int nc = current[1]+deltas[i][1];
					
					//map을 먼저 벗어나지 않는지 우선적으로 확인
					if(!isIn(nr,nc)) continue;
					
					//다음 칸이 벽이라면
					if(map[nr][nc].equals("1")) {
						//벽을 부순적이 있는지, 벽을 방문한 적이 있는지 확인
						if(current[2]==0 && !visited[1][nr][nc]) {
							visited[current[2]][nr][nc] =true; //방문으로 처리
							distance[nr][nc]=distance[current[0]][current[1]]+1;//이전까지의 거리에서 +1
							queue.offer(new int[] {nr,nc,1});//queue에 저장
						}
					}
					//다음 칸이 벽이 아니라면
					else {
						//다음 칸을 방문하지 않았을 때
						if(!visited[current[2]][nr][nc]) {
							visited[current[2]][nr][nc]= true; //방문한 것으로 변경
							distance[nr][nc]=distance[current[0]][current[1]]+1;//이전까지의 거리에서 +1
							queue.offer(new int[] {nr,nc,current[2]});//queue에 저장
						}
					}
					
					//원하는 도착지점에 도착했다면
					if(nr==N-1 && nc==M-1) {
						System.out.println(distance[nr][nc]+1);//거리 출력
						decide=true;
						break outer;
					}
				}	
			}
			
			if(!decide) {
				System.out.println(-1);
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N &&  c>=0 && c<M;
	}
}
