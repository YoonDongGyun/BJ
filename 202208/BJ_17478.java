package off0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 12.
@see https://www.acmicpc.net/problem/17478
@performance 15360KB 264ms
@category #재귀
@note 재귀활용 기본 문제 
*/
public class BJ_17478 {

	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		recurPrint(0);
	}
	
	static void printMark(int num) {
		for(int i=0;i<num;i++) {
			System.out.printf("____");
		}
	}
	
	static void recurPrint(int num) {
		if(num==N) {
			printMark(num); System.out.println("\"재귀함수가 뭔가요?\"");
			printMark(num); System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			
			for(int i=num;i>=0;i--) {
				printMark(i); System.out.println("라고 답변하였지.");
			}
			return;
		}
		printMark(num); System.out.println("\"재귀함수가 뭔가요?\"");
		printMark(num); System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		printMark(num); System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		printMark(num); System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		recurPrint(num+1);
		
	}
	
}
