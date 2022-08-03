import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14891 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int[][] gear = new int[4][8];//각 톱니바퀴 N극 S극 정보 저장
	static int[] gear_d= new int[4];//각 톱니바퀴들이 어떻게 이동할 지 방향을 저장하는 배열
	static int K;//회전 횟수
	
	public static void main(String[] args) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		char[] temp;
		for(int r=0;r<4;r++) {
			temp=input.readLine().toCharArray();
			for(int c=0;c<8;c++) {
				gear[r][c]=temp[c]-'0';//공백없는 숫자 배열에 저장
			}
		}
		
		K=Integer.parseInt(input.readLine());//회전 횟수
		
		for(int i=0;i<K;i++) {
			tokens=new StringTokenizer(input.readLine());
			gear_d= new int[4];//회전 정보 저장하기 위해 초기화
			
			int gear_n=Integer.parseInt(tokens.nextToken())-1;//배열 인덱스와 맞춰주기 위해 -1
			gear_d[gear_n] = Integer.parseInt(tokens.nextToken());//해당 톱니바퀴에 회전 방향 저장
			
			setMove(gear_n);//톱니바퀴 회전 이후 다른 톱니바퀴 회전 여부를 확인하기 위해 설정
			moveGearWithDirect(gear_n);//저장된 회전 방향에 따라 회전 진행
		}
		
		int s=1,sum=0;
		for(int i=0;i<4;i++) {
			sum+=gear[i][0]*s;//점수 저장
			s*=2;//점수가 2배씩 올라가니까 2배씩 곱해준다
		}
		
		System.out.println(sum);//점수 출력
	}
	
	static void moveGearWithDirect(int gear_n) {
		int temp = 0;//배열 값 변동에 활용하기 위한 임시 변수
		
		for(int i=0; i<4; i++) {
			if(gear_d[i] == 1) {//시계방향 
				temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}

			if(gear_d[i] == -1) {//반시계 방향 
				temp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
		
	}
	
	static void setMove(int gear_n) {
		//왼쪽에서 접하는 톱니 회전 방향 설정
		for(int i=gear_n-1; i>=0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				gear_d[i] = -1*gear_d[i+1];
			}else {
				break;
			}
		}
		//오른쪽에서 접하는 톱니 회전 방향 설정
		for(int i=gear_n+1; i<4; i++) {
			if(gear[i][6] != gear[i-1][2]) {
				gear_d[i] = -1*gear_d[i-1];
			}else { 
				break;
			}
		}
				
				
		
	}
	
}