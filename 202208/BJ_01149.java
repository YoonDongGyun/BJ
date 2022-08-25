import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
@author itsme
@since 2022. 8. 25.
@see https://www.acmicpc.net/problem/1149
@performance 12144KB 88ms
@category #DP 
@note */
public class BJ_01149{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] colors;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());//집의 개수
		
		colors= new int[N][3];//집 별로 색을 칠하기 위해 얼마나 비용이 필요한지 저장하는 배열 0->빨강, 1->초록, 2->파랑
		cost= new int[N][3];//최소 비용 정하기 위한 배열
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(input.readLine());
			for(int j=0;j<3;j++) {
				colors[i][j]=Integer.parseInt(tokens.nextToken());
			}
		}
		
		cost[0][0]=colors[0][0];
		cost[0][1]=colors[0][1];
		cost[0][2]=colors[0][2];//초기값들 저장
		
		for(int i=1;i<N;i++) {
			cost[i][0]+=Math.min(cost[i-1][1], cost[i-1][2])+colors[i][0];//빨강을 선택한 경우 이전에 초록과 파랑 중 최소 값과 더해준다
			cost[i][1]+=Math.min(cost[i-1][0], cost[i-1][2])+colors[i][1];//초록을 선택한 경우 이전에 빨강과 파랑 중 최소 값과 더해준다
			cost[i][2]+=Math.min(cost[i-1][0], cost[i-1][1])+colors[i][2];//파랑을 선택한 경우 이전에 빨강과 초록 중 최소 값과 더해준다
		}
		
		output.append(Math.min(Math.min(cost[N-1][0], cost[N-1][1]),cost[N-1][2]));//최종 값 중 최소 값 append
		
		System.out.println(output);//결과값 출력
	}
	
}
