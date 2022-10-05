import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_01194 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N,M,startR,startC,result=Integer.MAX_VALUE;
	static char[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][][] visited;
	
	public static class Point{
		int r, c, distance, key;

		public Point(int r, int c, int distance, int key) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.key=key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", distance=" + distance + ", key=" + key + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		
		map=new char[N][M];
		visited= new boolean[N][M][64];
		
		for(int i=0;i<N;i++) {
			String line = input.readLine();
			map[i]=line.toCharArray();
			
			for(int j=0;j<M;j++) {
				if(map[i][j]=='0') {
					startR=i;
					startC=j;
					map[i][j]='.';
				}
			}
		}
		
		move(startR,startC);
		
		if(result==Integer.MAX_VALUE) {
			result=-1;
		}
		
		System.out.println(result);
	}
	
	public static void move(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r,c,0,0));
		
		while(!queue.isEmpty()) {
			Point head = queue.poll();
			
			if(map[head.r][head.c]=='1') {
				result=Math.min(result, head.distance);
				return;
			}
			
			for(int d=0; d<deltas.length;d++) {
				int nr = head.r+deltas[d][0];
				int nc = head.c+deltas[d][1];
				int dis = head.distance;
				int headKey = head.key;
				
				if(!isIn(nr,nc)) continue;
				
				if(map[nr][nc]=='#' || visited[nr][nc][headKey]) {
					//벽 또는 방문한 칸
					continue;
				}
				else if(map[nr][nc]>='a' &&map[nr][nc]<='f' && !visited[nr][nc][headKey]) {
					//열쇠 줍줍
					visited[nr][nc][headKey]=true;
					headKey |= (1<<map[nr][nc]-'a');
					visited[nr][nc][headKey]=true;
					queue.add(new Point(nr,nc,dis+1,headKey));
				}
				else if(map[nr][nc]>='A' &&map[nr][nc]<='F' && !visited[nr][nc][headKey]) {
					//문 만남
					int doorKey= (1<<map[nr][nc]-'A');
					
					if((headKey & doorKey)>0) {
						visited[nr][nc][headKey]=true;
						queue.add(new Point(nr,nc,dis+1,headKey));	
					}
					
					else continue;
				}
				
				else if(map[nr][nc]=='.' && !visited[nr][nc][headKey]) {
					visited[nr][nc][headKey]=true;
					queue.add(new Point(nr,nc,dis+1,headKey));
				}
				
				else {
					visited[nr][nc][headKey]=true;
					queue.add(new Point(nr,nc,dis+1,headKey));
				}
			}
			
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
