import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_02636 {
	 	static int N, M;
	    static int[][] map;
	    static boolean[][] visited;

	    static final int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	    static List<Integer> cheese = new ArrayList<>(); 

	    public static void main(String[] args) throws IOException {
	        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	        
	        StringTokenizer tokens = new StringTokenizer(input.readLine());
	        
	        N = Integer.parseInt(tokens.nextToken());
	        M = Integer.parseInt(tokens.nextToken());
	        
	        map = new int[N][M];
	        visited = new boolean[N][M];

	        for (int i = 0; i < N; i++) {
	            tokens = new StringTokenizer(input.readLine());

	            for (int j = 0; j < M; j++) {
	                map[i][j] = Integer.parseInt(tokens.nextToken());
	            }
	        }

	        boolean flag = true;
	        int time = 0;
	        int firstCount = getCount(); // 초기상태 치즈의 개수

	        while (flag) {
	            time++;
	            
	            bfs(0,0);
	            int count = getCount();
	            
	            visited= new boolean[N][M];
	            
	            if (count == 0) {
	            	flag = false;	            	
	            }
	            else {
	            	cheese.add(count);	            	
	            }
	        }

	        System.out.println(time);

	        if (cheese.size() > 0) {
	        	System.out.println(cheese.get(cheese.size() - 1));	        	
	        }
	        
	        else {
	        	System.out.println(firstCount);	        	
	        }

	    }

	    static void bfs(int r, int c) {

	        Queue<Point> queue = new LinkedList<>();
	        queue.add(new Point(r,c));
	        visited[r][c] = true;

	        while (!queue.isEmpty()) {
	            Point current = queue.poll();

	            for (int d = 0; d < 4; d++) {
	                int nr = current.r + deltas[d][0];
	                int nc = current.c + deltas[d][1];

	                if (isIn(nr,nc)) {
	                    if (!visited[nr][nc]) {
	                        if (map[nr][nc] == 1) {
	                            map[nr][nc] = 2;
	                            visited[nr][nc] = true;
	                        }
	                        if (map[nr][nc] == 0) {
	                            visited[nr][nc] = true;
	                            queue.add(new Point(nr, nc));
	                        }
	                    }
	                }
	            }
	        }

	        removeCheese(); 
	    }

	    static void removeCheese() {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (map[i][j] == 2)
	                    map[i][j] = 0;
	            }
	        }
	    }

	    static int getCount() {
	        int count = 0;

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (map[i][j] == 1) {
	                    count++;
	                }
	            }
	        }

	        return count;
	    }

	    static class Point {
	        int r,c;

			public Point(int r, int c) {
				super();
				this.r = r;
				this.c = c;
			}
	    }
	    
	    static boolean isIn(int r, int c) {
	    	return r>=0 && r<N && c>=0 && c<M;
	    }
	}