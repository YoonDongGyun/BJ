import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 15.
@see
@performance
@category #
@note */
public class BJ_06593{
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int L,R,C;
	static char[][][] map;
	static int[][] deltas= {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,1}, {0,0,-1}};
	
	public static void main(String[] args) throws IOException{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			L = Integer.parseInt(tokens.nextToken()); //층 수
			R = Integer.parseInt(tokens.nextToken()); //한 층의 행
			C = Integer.parseInt(tokens.nextToken()); //한 층의 열
			
			if(L ==0 && R==0 && C==0) {//모두 0 입력받으면 종료
				System.out.println(output);//결과값 출력
				return;
			}
			
			int c=0,r=0,l=0;
			map =new char[L][R][C]; //3차원 배열로 map 구성 (층, 행, 열)
			
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String line = input.readLine();
					
					for(int k=0; k<C; k++) {
						map[i][j][k] = line.charAt(k);
						if(map[i][j][k] == 'S') { //출발 지점이면
							c = k; //열
							r = j; //행
							l = i; //층
							
							map[i][j][k] = '.';
						}
					}
				}
				input.readLine(); //중간 공백 줄 처리
			}
			bfs(c, r, l); //탐색 시작
		}
	}
	
	//bfs x->c y->r z->l
	static void bfs(int c, int r, int l) {
		Queue<int[]> q = new LinkedList<>();//bfs 활용 위해 Queue 선언
		boolean[][][] visited = new boolean[L][R][C];//방문 여부
		
		q.add(new int[] {c,r,l,0});//출발 지점 queue에 저장
		visited[l][r][c] = true;//방문으로 저장
		
		while(!q.isEmpty()) {//queue가 빌 때까지
			int[] current = q.poll();
			int currentC=current[0];//열
			int currentR=current[1];//행
			int currentL=current[2];//층
			
			int time = current[3];
			
			if(map[currentL][currentR][currentC]=='E') {//출구 도착
				output.append("Escaped in ").append(time).append(" minute(s).\n");//결과 출력위해 append
				return;//종료
			}
			
			for(int i=0; i<deltas.length; i++) {
				int nc = currentC + deltas[i][0]; 
				int nr = currentR + deltas[i][1];
				int nl = currentL + deltas[i][2];//이동
				
				if(!isIn(nc,nr,nl)) continue;//범위 밖이라면 continue
				if(visited[nl][nr][nc]) continue;//이미 방문했던 칸이라면 continue
				if(map[nl][nr][nc]=='.' || map[nl][nr][nc]=='E') {//빈 공간이거나 출구에 도착했다면
					visited[nl][nr][nc] = true;//방문한 칸 방문으로 변경
					q.add(new int[] {nc, nr, nl, time+1});//이동한 위치로 다시 탐색 시작하고 시간+1
				}
			}
		}
		output.append("Trapped!\n");//코드가 여기까지 온다는 것은 주위에 빈 공간이 없거나 이미 방문한 칸 밖에 없을 경우에 오기 때문에 탈출 불가능
	}
	
	//빌딩을 벗어나는지 아닌지 판별하기 위한 boolean method
	static boolean isIn(int c, int r, int l) {
		return c>=0 && r>=0 && l>=0 && c<C && r<R && l<L;
	}
}