package off0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 12.
@see https://www.acmicpc.net/problem/3040
@performance 11796KB 80ms
@category #조합
@note 조합 활용으로 간단히 풀 수 있는 문제 
*/
public class BJ_03040 {

	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] dwarf= new int[9];

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			dwarf[i]=Integer.parseInt(input.readLine());
		}
		
		makeCombination(0, new int[7], 0);
	}
	
	static boolean isRight(int[] choosed) {
		int sum=0;
		
		for(int i=0;i<choosed.length;i++) {
			sum+=choosed[i];
		}
		
		if(sum==100) return true;
		else return false;
	}
	
	static void makeCombination(int nth, int[] choosed, int startIdx) {
		if(nth == choosed.length) {
			if(isRight(choosed)) {
				for(int i=0;i<choosed.length;i++) {
					System.out.printf("%d%n",choosed[i]);
				}
			}
			return;
		}
		
		for(int i=startIdx;i<9;i++) {
			choosed[nth]=dwarf[i];
			makeCombination(nth+1, choosed, i+1);
		}
	}

}
