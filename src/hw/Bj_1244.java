package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj_1244 {

	static BufferedReader input;
	static StringTokenizer tokens;
	static List<Integer> switches;//스위치 상태 저장하는 리스트
	static int[][] students; //학생 {성별, 받은 숫자}
	static int N,student;//스위치 갯수, 학생 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));//BufferedReader를 통해 Input 받기
		switches=new ArrayList<>();
		
		N=Integer.parseInt(input.readLine());//스위치 갯수 입력받기
		tokens=new StringTokenizer(input.readLine());
	
		for(int i=0;i<N;i++) {
			switches.add(Integer.parseInt(tokens.nextToken()));//스위치 별로 입력받기
		}
		student=Integer.parseInt(input.readLine());//학생 수 입력받기
		
		students=new int[student][2];//성별, 받은 숫자 저장할 배열 선언
		
		for(int i=0;i<student;i++) {
			tokens=new StringTokenizer(input.readLine());
			students[i][0]=Integer.parseInt(tokens.nextToken());
			students[i][1]=Integer.parseInt(tokens.nextToken());
		}//성별, 받은 숫자 저장
		
		for(int i=0;i<student;i++) {
			switch(students[i][0]){
			case 1://학생이 남자라면
				man_student(students[i][1]);
				break;
			case 2://학생이 여자라면
				woman_student(students[i][1]);
				break;
			}
		}
		
		for(int i=0;i<N;i++) {//스위치 상태 출력
			System.out.printf("%d ",switches.get(i));
			if((i+1)%20==0) System.out.println();//20개씩 출력하고 넘어가는 경우에는 다음 줄에 출력
		}
	}
	
	//학생이 남자인 경우 호출하는 메서드
	static void man_student(int num){//num은 받은 숫자
		for(int i=num-1;i<N;i+=num) {//num의 배수마다
			if(switches.get(i)==0) {//스위치 상태가 0이라면
				switches.set(i, 1);//1로 바꿔준다
			}
			else if(switches.get(i)==1) {//스위치 상태가 1이라면
				switches.set(i, 0); //1로 바꿔준다
			}
		}
	}
	
	//학생이 여자일 경우 호출하는 메서드
	static void woman_student(int num){//num은 받은 숫자
		int temp=1;//num을 기준으로 좌우대칭인지 확인하기 위해 temp 선언
		num-=1;//배열의 index는 0부터 시작하기 때문에 1을 빼준다
		
		//좌우대칭 확인 전에 받은 숫자에 해당하는 스위치 상태부터 바꿔준다
		if(switches.get(num)==0) {//스위치 상태가 0이라면
			switches.set(num,1);//1로바꿔준다
		}
		else if(switches.get(num)==1) {//스위치 상태가 1이라면
			switches.set(num,0);//1로 바꿔준다
		}
		
		while (true) {
			if(isIn(num-temp,num+temp) && switches.get(num-temp)==switches.get(num+temp)) {//좌우 대칭 비교시 스위치를 벗어나지 않고 좌우대칭이라면
				if(switches.get(num-temp)==0 ) {//스위치 상태가 0일 때
					switches.set(num-temp, 1);//1로 바꿔준다
					switches.set(num+temp, 1);
				}
				else if(switches.get(num-temp)==1) {//스위치 상태가 1일 때
					switches.set(num-temp, 0);//0으로 바꿔준다
					switches.set(num+temp, 0);
				}
				temp++;//다음 좌우대칭 값을 비교하기 위해 temp값 증가
			}
			else {//좌우대칭이 아니라면 반복문 빠져나감
				break;
			}
		}
		
	}
	
	//인덱스가 스위치 list의 범위를 벗어나지 않는지 확인하는 메서드
	static boolean isIn(int index1,int index2) {
		return index1>=0 && index1<N && index2>=0 && index2<N;
	}
}
