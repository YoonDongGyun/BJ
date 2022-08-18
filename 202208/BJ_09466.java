import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 17.
@see
@performance
@category #
@note */
public class BJ_09466{

	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
    static int N;//사람 수
    static int[] choice;//어떤 팀원이랑 하고 싶은지 저장
    static int count = 0;//팀원 결정난 사람 수
    static boolean[] visited;//방문 여부
    static boolean[] pass;//사이클 확인하기 위한 검사 종료 여부
 
    public static void main(String[] args) throws Exception {
        input = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(input.readLine());//테스트 케이스
 
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(input.readLine());//사람 수 입력
            
            choice = new int[N+1];
            visited = new boolean[N+1];
            pass = new boolean[N+1];//배열 생성
            count = 0;//count 초기화
 
            tokens = new StringTokenizer(input.readLine());
            
            for(int i=1; i<=N; i++) 
                choice[i] = Integer.parseInt(tokens.nextToken());//선택 저장
 
            for(int i=1; i<=N; i++) {
            	dfs(i);//첫번째 사람부터 탐색 시작            	
            }
 
            output.append(N - count).append("\n");//전체 사람수 - 팀원 결정난 사람 수
        }
        
        System.out.println(output);//결과 출력
    }
 
    public static void dfs(int idx) {
		if(pass[idx]) { 
			return; // 이미 검사가 완료되었기 때문에 탐색을 더 진행할 필요가 없다.
		}
		
		if(visited[idx]) { // 이전에 방문한 적이 있으면 사이클 생성을 확인할 수 있음 (서로 선택한 팀원이 이어졌을 경우 팀 결성이 가능)
			pass[idx] = true; // 검사 완료로 변경
			count++; // 같은 팀원이므로 count 증가
		}
		
		visited[idx] = true; // 입력받은 파라미터(몇번째 사람) 방문으로 변경
		dfs(choice[idx]);//어떤 사람을 선택했는지 파라미터로 받아 탐색 진행
		
		pass[idx] = true; // 팀이 결성되었든 아니든 이미 검사가 끝난 사람은 다시 탐색할 필요가 없으므로 true로 변경 (불필요한 계산을 막아주고 시간을 줄여주는 역할)
		visited[idx] = false; // 재귀 종료 후 방문 체크한 거 초기화
	}
}