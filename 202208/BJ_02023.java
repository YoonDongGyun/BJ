import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_02023 {
	
	static int N,dec=1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N=Integer.parseInt(input.readLine());
		
		//자리수 범위 지정하기 위해 N만큼 10을 곱해준다.
		for(int i=0;i<N;i++) {
			dec*=10;
		}
		
		//지정된 범위 내에서
		for(int i=dec/10;i<dec;i++) {
			if(i>2 && i%2==0) continue; //2가 아닌 짝수는 모두 소수가 아니기 때문에 제외
			
			if(isSpecial(i)) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean isSpecial(int n) {
		int dec_temp=dec/10;//자리수를 점점 늘려가며 비교하기 위해 변수 선언
		
		//첫째 자리가 소수가 아니면 조건을 만족할 수 없기 때문에 첫째자리 1차적으로 비교 후 연산 적용
		if(n/dec_temp ==2 || n/dec_temp ==3 || n/dec_temp ==5 || n/dec_temp ==7) {
			while(dec_temp>=1) {
				if(dec_temp>1 && isPrime(n/(dec_temp/10))) {
					dec_temp/=10;
				}
				else if(dec_temp==1) {
					dec_temp=0;
					if(!isPrime(n)) {
						return false; 
					}
				}
				
				else return false;
			}
		}
		
		else return false;
		
		return true;
		
	}
	
	//소수 판별식 2부터 자기자신 제곱근까지 나눠주면 소수인지 아닌지 판별할 수 있다.
	static boolean isPrime(int n) {
		for(int i=2;i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}

}
