import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 10.
@see
@performance
@category #
@note */
public class BJ_16926{

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        R = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 몇개의 층을 돌려야 할까요?
        int depth = Math.min(N, M) / 2;

        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < R; r++) {
                // d 층을 돌린다.!!!
                rotate(d);
            }
        }

        for (int[] row : map) {
            for (int i : row) {
                output.append(i).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    static void rotate(int d) {
        // 1. keep 처리
        int keep = map[d][d];
        // 2. 위쪽을 왼쪽으로 한칸씩
        for (int c = d + 1; c < M - d; c++) {
            map[d][c - 1] = map[d][c];
        }
        // 3. 오른쪽을 위로 한칸씩
        for (int r = d + 1; r < N - d; r++) {
            map[r - 1][M - 1 - d] = map[r][M - 1 - d];
        }
        // 4. 아래쪽을 오른쪽으로 한칸씩
        for (int c = M - 1 - 1 - d; c > d - 1; c--) {
            map[N - 1 - d][c + 1] = map[N - 1 - d][c];
        }
        // 5. 왼쪽을 아래로 한칸씩
        for (int r = N - 1 - 1 - d; r > d; r--) {
            map[r + 1][d] = map[r][d];
        }
        // 6. keep 했던거 끼워넣기
        map[d + 1][d] = keep;

    }
}
