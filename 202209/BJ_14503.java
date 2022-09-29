
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 9. 29.
@see
@performance
@category #
@note */
public class BJ_14503{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,d,count=1;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}}; //북, 동, 남, 서
	static int VR,VC; //로봇 청소기의 처음 위치
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens= new StringTokenizer(input.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		map= new int[N][M];
		
		tokens=new StringTokenizer(input.readLine());
		
		VR=Integer.parseInt(tokens.nextToken());
		VC=Integer.parseInt(tokens.nextToken());
		d=Integer.parseInt(tokens.nextToken());
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(input.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
			}
		}
		map[VR][VC]=-1;
		
		searchVacuum(VR, VC, d);
		
		System.out.println(count);
	}
	
	static void searchVacuum(int r, int c, int direct) {
		//현재 위치를 청소
        if (map[r][c] == 0) {
            map[r][c] = -1;
            count++;
        }

        //왼쪽방향부터 탐색
        boolean flag = false;
        int origin = direct;
        for (int i = 0; i < 4; i++) {//4방향 탐색
            int nd = (direct + 3) % 4;
            int nr = r + deltas[nd][0];
            int nc = c + deltas[nd][1];

            if (isIn(nr,nc)) {
                if (map[nr][nc] == 0) {//아직 청소하지 않은 공간이라면
                	searchVacuum(nr, nc, nd);
                    flag = true;
                    break;
                }
            }
            direct = (direct + 3) % 4;
        }

        // 4방향 모두 청소가 되어있거나 벽인 경우
        if (!flag) {
            int nd = (origin + 2) % 4;
            int br = r + deltas[nd][0];
            int bc = c + deltas[nd][1];//후진

            if (isIn(br,bc)) {
                if (map[br][bc] != 1) {
                	searchVacuum(br, bc, origin); //바라보는 방향 유지한 채 후진
                }
            }
        }
    }

	
	static boolean isIn(int r, int c) {
		return r>0 && r<N && c>0 && c<M;
	}
}

