import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author itsme
 * @see https://www.acmicpc.net/problem/12891
 * @performance 20720kb	180ms
 * @memo 8/5일 노션에 적어놓은 시간복잡도 관련 내용 다시 한번 보기, 슬라이딩 윈도우 개념 다시 한번 공부해보고 관련 문제 풀어보자
 */

public class BJ_12891 {
	
	static int[] cnt= new int['Z'+1];

	
	public static void main(String[] args) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		
		int S=Integer.parseInt(tokens.nextToken());
		int P=Integer.parseInt(tokens.nextToken());
		
		String Dna = input.readLine();

		int[] min_num=new int[4];

		int totalCnt = 0;
		
		tokens= new StringTokenizer(input.readLine());
		for(int i=0;i<4;i++) {
			min_num[i]=Integer.parseInt(tokens.nextToken());
		}
		
		for(int i=0;i<P;i++) {
			cnt[Dna.charAt(i)]++;
		}
		
		if(isAble(min_num)) {
			totalCnt++;
		}
		
		for(int i=0;i<S-P;i++) {
			cnt[Dna.charAt(i)]--;
			cnt[Dna.charAt(i+P)]++;
			
			if(isAble(min_num)) totalCnt++;

		}
		
		System.out.println(totalCnt);
		
	}
	
	static boolean isAble(int[] min_num) {
		return cnt['A']>=min_num[0] && cnt['C']>=min_num[1] && cnt['G']>=min_num[2] && cnt['T']>=min_num[3];
	}
	
	
}
