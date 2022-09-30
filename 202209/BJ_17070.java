import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N;
	static int[][] map;
	static int[][] deltas = {{0,1},{1,0},{1,1}};
	static int count=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		map= new int[N][N];
		
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(input.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}
		if(map[N-1][N-1]==0) {
			movePipe(0,1,0);			
		}
		
		System.out.println(count);
	}
	
	static void movePipe(int r, int c, int direct) {
		if(r==N-1 && c==N-1) {
			count++;
			return;
		}
		
		for(int i=0;i<deltas.length;i++) {
			if(direct==0) {
				if(i==1) continue;
			}
			else if(direct==1) {
				if(i==0) continue;
			}
			
			if(i==0 || i==1) {
				int nr = r+deltas[i][0];
				int nc = c+deltas[i][1];
				
				if(isIn(nr,nc) && map[nr][nc]==0) {
					movePipe(nr,nc,i);
				}
			}
			
			else {
				boolean flag = true;
				
				for(int d=0;d<deltas.length;d++) {
					int nr= r+deltas[d][0];
					int nc= c+deltas[d][1];
					
					if(!isIn(nr,nc) || map[nr][nc]!=0) {
						flag=false;
						break;
					}
				}
				
				if(flag) {
					movePipe(r+deltas[2][0],c+deltas[2][1],2);
				}
			}
		}
		
		
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
