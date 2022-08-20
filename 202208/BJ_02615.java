import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 20.
@see https://www.acmicpc.net/problem/2615
@performance 11912kb 84ms
@category #구현 #배열
@note 문제 조건 조금더 꼼꼼하게 보자
*/
public class BJ_02615{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map=new int[19][19];
	static int win;
	static boolean decide=false;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<19;i++) {
			tokens=new StringTokenizer(input.readLine());
			for(int j=0;j<19;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
			}
		}
		
		outer: for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]==1 || map[i][j]==2) {
					if (isWin(i,j)) break outer;
				}
			}
		}
		
		if(!decide) {
			output.append("0");
		}
		
		System.out.println(output);
	}
	static boolean isWin(int r, int c) {
		int[][] deltas = {{-1,1},{0,1},{1,1},{1,0}};
		int count;
		
		for(int i=0;i<deltas.length;i++) {
			count=1;
			int nr=r+deltas[i][0];
			int nc=c+deltas[i][1];
			
			if(isIn(nr,nc) && map[r][c]==map[nr][nc]) {
				count++;
				
				while(true) {
					if(count==5) break;
					nr+=deltas[i][0];
					nc+=deltas[i][1];
					
					if(isIn(nr,nc) && map[r][c]==map[nr][nc]) {
						count++;
					}
					else break;
				}
			}

			if(count==5) {
				int pr=r-deltas[i][0];
				int pc=c-deltas[i][1];
				
				if(isIn(pr,pc) && map[r][c]==map[pr][pc]) {
					return false;
				}
				
				nr+=deltas[i][0];
				nc+=deltas[i][1];
				
				if(isIn(nr,nc)) {
					if(map[r][c]!=map[nr][nc]) {					
						win=map[r][c];
						output.append(win).append("\n").append(String.format("%d %d", r+1,c+1));
						decide=true;
						return true;
					}
					else return false;					
				}
				
				else {
					win=map[r][c];
					output.append(win).append("\n").append(String.format("%d %d", r+1,c+1));
					decide=true;
					return true;
				}
				
				
			}
		}
		return false;
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<19 && c>=0 && c<19;
	}
}
