import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//dfs를 활용해 탐색을 진행하고 이미 방문했던 곳이 있으면 사이클로 판단
public class BJ_4803{
	
	static BufferedReader input;
	static StringBuilder output= new StringBuilder();
	static StringTokenizer tokens;
	static boolean[] visited; //방문 여부
	static int N,M; //정점, 간선 개수
	static ArrayList<Integer>[] tree; //트리
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		int test_case=1;//몇번째 테스트 케이스인지 저장

        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break; //둘다 0이면 종료

            int trees = 0;
            tree = new ArrayList[N];
            visited = new boolean[N];
            
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                
                //서로 연결
                tree[a].add(b);
                tree[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {//아직 방문하지 않았다면
                    visited[i] = true; //방문으로 변경
                    if (dfs(-1, i)) trees++; //트리 개수 추가
                }
            }

            output.append(String.format("Case %d: ", test_case));
            switch(trees) {
            case 0:
            	output.append("No trees.\n");
            	break;
            case 1:
            	output.append("There is one tree.\n");
            	break;
            default:
            	output.append(String.format("A forest of %d trees.\n", trees));
            	break;
            }
            
            test_case++;
        }

        System.out.println(output);
    }

	//dfs
    public static boolean dfs(int root, int node) {
        for (int t : tree[node]) {
            if (t == root) continue;
            if (visited[t]) return false;
            visited[t] = true;
            if (!dfs(node, t)) return false;
        }
        return true;
    }
}