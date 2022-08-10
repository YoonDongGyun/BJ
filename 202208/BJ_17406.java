import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_17406 {
	static int N, M, K;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int[][] nums;
	static int[][] arr;
	static int[][] temp;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		nums = new int[N][M];
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++)
				nums[i][j] = Integer.parseInt(tokens.nextToken());
		}
		
		copyArray();

		rotationList = new Rotation[K];
		for (int k = 0; k < K; k++) {
			int r, c, s;
			tokens = new StringTokenizer(input.readLine());

			r = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());
			s = Integer.parseInt(tokens.nextToken());

			rotationList[k] = new Rotation(r, c, s);
		}
		
		makePermutation(0, new boolean[K], new int[K]);
		
		System.out.println(minValue);
	}

	static class Rotation {
		int r;
		int c;
		int s;
		int len;
		int rotateCnt;

		Rotation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.len = 2 * s + 1;
			this.rotateCnt = this.len / 2;
		}
	}

	static Rotation[] rotationList;

	static void rotate(Rotation rotation) {
		int r = rotation.r;
		int c = rotation.c;
		int s = rotation.s;
		int len = rotation.len;
		int rotateCnt = rotation.rotateCnt;

		// 임시 배열 temp
		temp = new int[len][len];

		// arr 배열의 회전시킬 부분을 임시 배열 temp에 복사
		for (int i = r - s - 1; i <= r + s - 1; i++) {
			for (int j = c - s - 1; j <= c + s - 1; j++)
				temp[i - r + s + 1][j - c + s +1] = arr[i][j];
		}

		// 복사한 부분 회전시킴
		for (int cnt = 0; cnt < rotateCnt; cnt++) {
			int keep = temp[cnt][cnt];

			for (int i = cnt; i < len - cnt - 1; i++)
				temp[i][cnt] = temp[i + 1][cnt];
			for (int i = cnt; i < len - cnt - 1; i++)
				temp[len - cnt - 1][i] = temp[len - cnt - 1][i + 1];
			for (int i = len - cnt - 1; i > cnt; i--)
				temp[i][len - cnt - 1] = temp[i - 1][len - cnt - 1];
			for (int i = len - cnt - 1; i > cnt; i--)
				temp[cnt][i] = temp[cnt][i - 1];

			temp[cnt][cnt + 1] = keep;
		}

		//	arr 배열에 회전시킨 부분을 다시 복사
		for (int i = r - s - 1; i <= r + s - 1; i++) {
			for (int j = c - s - 1; j <= c + s - 1; j++)
				arr[i][j] = temp[i - r + s + 1][j - c + s +1];
		}
	}
	
	//	배열 arr의 각 행의 합 중 최소인 값 찾아서 반환
	static int minSum() {
		int sum = 0;
		int ret = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			sum = 0;
			
			for(int j = 0; j < M; j++)
				sum += arr[i][j];
		
			if(ret > sum)
				ret = sum;
		}
		
		return ret;
	}
	
	static void makePermutation(int nth, boolean[] isSelected, int[] order) {
		if(nth == K) {
			for(int i = 0; i < K; i++) {	//	정해진 순서에 따라 회전시킴
				Rotation r = rotationList[order[i]];
				rotate(r);
			}
			
			int res = minSum();	//	회전한 배열의 값
			
			if(minValue > res) 	//	최솟값이 갱신될 경우 변경
				minValue = res;
			
			copyArray();	//	arr 배열을 회전시키기 전으로 돌려놓음
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!isSelected[i]) {
				order[nth] = i;
				isSelected[i] = true;
				
				makePermutation(nth + 1, isSelected, order);
				
				isSelected[i] = false;
			}
		}
	}
	
	static void copyArray() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				arr[i][j] = nums[i][j];
		}
	}
}