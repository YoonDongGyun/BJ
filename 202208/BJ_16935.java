import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 28.
@see
@git
@performance
@category #
@note */
public class BJ_16935{
	
	static BufferedReader input;
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

        tokens = new StringTokenizer(input.readLine());
        for (int r = 0; r < R; r++) {
            String cmd = tokens.nextToken();
            if (cmd.equals("1")) {
                oper1();
            } else if (cmd.equals("2")) {
                oper2();
            } else if (cmd.equals("3")) {
                oper3();
            } else if (cmd.equals("4")) {
                oper4();
            } else if (cmd.equals("5")) {
                oper5();
            } else if (cmd.equals("6")) {
                oper6();
            }
        }

        for (int[] row : map) {
            for (int c : row) {
                output.append(c).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);

    }
    
    // 상하 반전 - 어차피 2차원 배열은 1차원 배열의 참조를 가지니까 요것을 swap
    static void oper1() {
        for(int r=0; r<N/2; r++) {
            int [] temp = map[r];
            map[r] = map[N-1-r];
            map[N-1-r] = temp;
        }
    }
    // 좌우 반전
    static void oper2() {
       for(int c=0; c<M/2; c++) {
           for(int r=0; r<N; r++) {
               int temp = map[r][c];
               map[r][c] = map[r][M-1-c];
               map[r][M-1-c] = temp;
           }
       }
    }
    
    // 오른쪽으로 90도 회전
    static void oper3() {
        swapNM();
        int [][] moved = new int[N][M];
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                moved[r][c] = map[M-1-c][r];
            }
        }
        map = moved;
    }
    static void oper4() {
        swapNM();
        int [][] moved = new int[N][M];
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                moved[r][c] = map[c][N-1-r];
            }
        }
        map = moved;
    }
    
    // 회전 --> N,M 교체 후 새로운 배열에 넣을 수밖에..
    static void swapNM() {
        int temp = N;
        N = M;
        M = temp;
    }
    static void oper5() {
        // 1번 영역을 저장해두자.
        int [][] temp = new int [N/2][M/2];
        for(int r=0; r<N/2; r++) {
            for(int c=0; c<M/2; c++) {
                temp[r][c] = map[r][c];
            }
        }
        // 1 영역을 2에 전달 --> 2번 영역을 반환
        temp = swapSquare(0, M/2, temp);
        // 2번 영역을 받아서 --> 3에 전달 후 3 반환,
        temp = swapSquare(N/2, M/2, temp);
        // 3번 영역을 받아서 --> 4에 전달 후 4 반환
        temp = swapSquare(N/2, 0, temp);
        // 마지막으로 받은 4를 1에 저장
        temp = swapSquare(0, 0, temp);
    }
    static void oper6() {
     // 1번 영역을 저장해두자.
        int [][] temp = new int [N/2][M/2];
        for(int r=0; r<N/2; r++) {
            for(int c=0; c<M/2; c++) {
                temp[r][c] = map[r][c];
            }
        }
        // 1 영역을 4에 전달 --> 4번 영역을 반환
        temp = swapSquare(N/2   , 0, temp);
        // 4번 영역을 받아서 --> 3에 전달 후 3 반환,
        temp = swapSquare(N/2   , M/2, temp);
        // 3번 영역을 받아서 --> 2에 전달 후 2 반환
        temp = swapSquare(0   , M/2, temp);
        // 마지막으로 받은 2를 1에 저장
        temp = swapSquare(0, 0, temp);
        
    }
    
    
    static int [][] swapSquare(int r, int c, int [][] temp){
        // 미리 현재 영역 백업
        int [][] current = new int [N/2][M/2];
        for(int r2=0; r2<N/2; r2++) {
            for(int c2=0; c2<M/2; c2++) {
                current[r2][c2] = map[r+r2][c+c2];
                // 현재 영역에 temp 부어 넣기.
                map[r+r2][c+c2] = temp[r2][c2];
                
            }
        }
        // 현재 영역 반환
        return current;
    }
}