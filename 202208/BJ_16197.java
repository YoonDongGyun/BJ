import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 16.
@see https://www.acmicpc.net/problem/16197
@performance 14560KB 260ms
@category #dfs
@note 
*/
public class BJ_16197{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static char[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] coins = new int[2][2];
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		int coinIndex=0;
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		
		map=new char[N][M];
		
		for(int i=0;i<N;i++) {
			map[i]=input.readLine().toCharArray();
			
			for(int j=0;j<M;j++) {
				if(map[i][j]=='o') {
					coins[coinIndex][0]=i;
					coins[coinIndex][1]=j;
					coinIndex++;
				}
			}
		}
		dfs(coins[0][0], coins[0][1], coins[1][0], coins[1][1],0);
		
		if(min==Integer.MAX_VALUE) {
			min=-1;
		}
		
		output.append(min);
		
		System.out.println(output);
		
	}
	
	static void dfs(int r1, int c1, int r2, int c2, int count) {
		//버튼을 10번 보다 많이 누르게 된다면 종료
		if(count>10) {
			return;
		}
		
		//동전이 둘 다 떨어진 경우
		if(!isIn(r1,c1) && !isIn(r2,c2)) {
			return;
		}
		
		//동전이 둘 중 하나만 떨어진 경우
		if((!isIn(r1,c1) && isIn(r2,c2)) || (!isIn(r2,c2) && isIn(r1,c1))) {
			min=Math.min(min, count);//최소값 갱신
			return;
		}
		
		for(int i=0;i<deltas.length;i++) {
			int nr1=r1+deltas[i][0];
			int nc1=c1+deltas[i][1];
			
			int nr2=r2+deltas[i][0];
			int nc2=c2+deltas[i][1];//두 동전 한꺼번에 같은 방향으로 이동
			
			//한 동전은 벽을 만나서 이동을 못할 수도 있지만 다른 동전은 이동이 가능한 경우도 있기 때문에 벽을 만난 동전을 원래 위치로 돌려주고 아닌 동전만 이동시키는 과정이 필요
			if(isIn(nr1,nc1) && map[nr1][nc1]=='#') {//벽을 만나면 이동 불가능하기 때문에 원래 위치로 다시 조정
				nr1=r1;
				nc1=c1;
			}
			if(isIn(nr2,nc2) && map[nr2][nc2]=='#') {//벽을 만나면 이동 불가능하기 때문에 원래 위치로 다시 조정
				nr2=r2;
				nc2=c2;
			}
			
			dfs(nr1, nc1, nr2, nc2, count+1);//횟수 1 증가시키고 이동한 방향으로 다시 진행
		}
	}
	
	//동전이 떨어졌는지 안떨어졌는지 판별
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
}