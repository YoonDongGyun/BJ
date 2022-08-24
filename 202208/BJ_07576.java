import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 24.
@see
@performance
@category #
@note */
public class BJ_07576{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static int days,count;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Point> queue= new LinkedList<>();
	
	static class Point{
		int r,c;

		private Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		M=Integer.parseInt(tokens.nextToken());
		N=Integer.parseInt(tokens.nextToken());
		
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(input.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				
				if(map[i][j]==1) {
					queue.offer(new Point(i,j));
				}
				
				else if(map[i][j]==0) {
					count++;
				}
			}
		}
		while (count > 0 && !queue.isEmpty()) {
            for (int s = queue.size(); s > 0; s--) {
                Point head = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = head.r + deltas[k][0];
                    int nc = head.c + deltas[k][1];

                    if (isIn(nr,nc) && map[nr][nc]==0) {
                    	count--;
                    	map[nr][nc] = 1;
                    	queue.offer(new Point(nr,nc));
                    	
                    }
                }
            }
            days++;
        }
		
		 System.out.println(count == 0 ? days : -1);
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
