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
@since 2022. 8. 24.
@see https://www.acmicpc.net/problem/3055
@performance 12580kb 152ms
@category #bfs
@note bfs 쓸 때 계속 시간이 많이 나오는데 줄이는 방법 고민해보자 
*/
public class BJ_03055{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static char[][] map;
	static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	static List<Point> water;
	static int startR, startC;
	static int count=Integer.MAX_VALUE;
	
	static class Point{
		int r,c,cnt;

		private Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		private Point(int r, int c,int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		
		map=new char[R][C];
		
		water= new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			String line=input.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=line.charAt(j);
				
				if(map[i][j]=='*') {
					water.add(new Point(i,j));
				}
				else if(map[i][j]=='S') {
					startR=i;
					startC=j;
					map[i][j]='.';
				}
			}
		}
		
		bfs(startR, startC,0);
		
		if(count==Integer.MAX_VALUE) {
			output.append("KAKTUS");
		}
		else {
			output.append(count);
		}
		
		System.out.println(output);
	}
	
	static void water() {
		int size=water.size();
		for(int i=0;i<size;i++) {
			for(int j=0;j<deltas.length;j++) {
				int nr=water.get(i).r+deltas[j][0];
				int nc=water.get(i).c+deltas[j][1];
				
				if(isIn(nr,nc) && map[nr][nc]=='.') {
					map[nr][nc]='*';
					water.add(new Point(nr,nc));
				}
			}
		}
	}
	
	static void bfs(int startR, int startC, int cnt) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(startR, startC, cnt));
		int pcount=cnt;
		water();
		
		while(!queue.isEmpty()) {
			Point current= queue.poll();
			
			if(pcount!=current.cnt) {
				water();
				pcount=current.cnt;
			}

			map[current.r][current.c]='*';
			
			for(int i=0;i<deltas.length;i++) {
				int nr=current.r+deltas[i][0];
				int nc=current.c+deltas[i][1];
				
				if(isIn(nr,nc)) {
					if(map[nr][nc]=='.') {
						map[nr][nc]='*';
						queue.offer(new Point(nr,nc,current.cnt+1));
					}
					else if(map[nr][nc]=='D') {
						count=Math.min(count, current.cnt+1);
						break;
					}					
				}
				
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
