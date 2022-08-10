import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_02023_1 {
	static int N,dec=1;
	static int[] start_nums = {2,3,5,7};
	static int[] number = {1,3,7,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N=Integer.parseInt(input.readLine());
		
		for(int n: start_nums) {
			makePermutationDup(1,n);
		}
		
		
	}
	
	static void makePermutationDup(int nth, int choosed) {
		if(!isPrime(choosed)) return;
        // 기저조건: 몇 번째꺼를 고르는데choosed를 다 채웠다~~~
        if (nth == N) {
        	System.out.println(choosed);
            return;
        }

        // inductive part
        for (int i = 0; i < number.length; i++) {
            // 해당 하는 녀석을 사용하기
            makePermutationDup(nth + 1, choosed*10+number[i]);
        }
	
	}
	
	static boolean isPrime(int n) {
		for(int i=2; i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
