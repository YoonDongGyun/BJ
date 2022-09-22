import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int r;
	int c;
	
	Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class BJ_16234 {
	
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static List<Pair> union = new ArrayList<>();
	static boolean visited[][];
	static int map[][];
	static int N,L,R,count;
	static boolean moved = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		move();
		
		System.out.println(count);
        
	}
	public static void move() {
		
		while(true) {
			moved = false;
			visited = new boolean[N][N]; //새로 BFS 시작할때마다 visited 초기화
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					if(!visited[i][j]){
						 bfs(i,j);    //방문하지 않은상태면 BFS 시작
					}				
				}
			}
												
			if(!moved) break; //국경이동이 없으면 while 종료
			else count++; //국경이동이 있었다면 count ++
		}
			
	}
	
	public static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r,c));
		visited[r][c] = true; //방문 처리
		union.add(new Pair(r,c));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			r = p.r;
			c = p.c;
			
			for(int k=0; k<deltas.length; k++) {
				int nr = r + deltas[k][0];
				int nc = c + deltas[k][1];
				
				if(isIn(nr,nc)) {
					if(!visited[nr][nc] && L <= Math.abs(map[r][c] - map[nr][nc]) &&  Math.abs(map[r][c] - map[nr][nc]) <= R) {
						moved = true;//인구 이동으로 변경
						visited[nr][nc] = true; //방문 처리
						union.add(new Pair(nr,nc)); //연합에 추가
						queue.add(new Pair(nr,nc)); //queue에 추가
					}
				}	
			}				
		}	
		
		//BFS 가 끝나면 인구이동 결과 맵에 집어넣기
		int sum = 0;
		for(int i=0; i<union.size(); i++) {
			Pair p = union.get(i);
			 sum += map[p.r][p.c];
		}
		
		for(int i=0; i<union.size(); i++) {
			Pair p = union.get(i);
			map[p.r][p.c] = sum / union.size();
		}
		union.removeAll(union);
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
}