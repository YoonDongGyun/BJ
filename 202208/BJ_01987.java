import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 17.
@see https://www.acmicpc.net/problem/1987
@performance 12764KB 1036ms
@category #dfs
@note 재귀 조건 정확하게 지정하자
*/
public class BJ_01987{
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static int[][] map;
	static boolean[] visited;
	static int max=0;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());//세로
		C = Integer.parseInt(tokens.nextToken());//가로
		
		map = new int[R][C];//알파벳 맵
		visited = new boolean[26];//해당 알파벳 방문했는지 여부
		
		for(int i=0; i<R; i++) {
			String[] line = input.readLine().split("");//알파벳 별로 구분하여 배열에 저장
			for(int j=0; j<line.length; j++) {
				String alphabet = line[j];//알파벳 별도로 저장
				map[i][j] = alphabet.charAt(0)-'A';//인덱스로 활용하기 쉽게 알파벳을 정수로 바꿔서 map에 저장 A->0 B->1
			}
		}
		
		dfs(0,0,0);//시작 위치 (r,c) , 몇개의 알파벳을 지나갔는지(count)
		output.append(max);
		
		System.out.println(output);
	}
	
	//map을 벗어나지 않았는지 여부
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	//dfs
	static void dfs(int r, int c, int count) {
		if(visited[map[r][c]]) {//방문했던 적이 있는 알파벳을 만났다면
			max = Math.max(max, count);//count중 가장 큰 count를 max에 저장
			return;
		}
		else {
			visited[map[r][c]] = true;//시작 위치 방문 true로 변경
			for(int i=0; i<deltas.length; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];//이동
			
				if(!isIn(nr,nc)) continue;//map을 벗어난다면 continue
				dfs(nr, nc, count+1);//count를 1증가(알파벳을 만났기 때문에)하고 이동
			}
			visited[map[r][c]] = false;//탐색 후에 방문 여부 false로 변경
		}
	}
}