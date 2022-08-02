import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
@author itsme
@see https://www.acmicpc.net/problem/1254
@performance 11492kb 80ms
@category 문자열, 브루트포스 알고리즘
@memo 펠린드롬 판단 기준과 substring이용한 방법 기억해두자
*/

public class BJ_01254{
	static BufferedReader input;
	
	public static void main(String[] args) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		String str=input.readLine(); //String 입력받기
		int position=0;//substring 사용위해 인덱스 저장
		
		if(isPalindrome(str)) {//만약 str이 펠린드롬이라면
			System.out.println(str.length());//str의 length를 출력한다
		}
		else {//펠린드롬이 아니라면
			while(true) {
				if(position==str.length()-1 || isPalindrome(str.substring(position))) {//앞부터 하나씩 인덱스를 이동하여 substring이 펠린드롬인지 확인한다
					System.out.println(str.length()+position);//앞에 제외된 만큼 str 뒤에 붙이면 펠린드롬이 될 수 있기 때문에 length와 인덱스만큼 더해준다
					break;//while문 벗어나기
				}
				
				else {//substring이 펠린드롬이 아니라면
					position++;//인덱스를 앞으로 당긴다
				}
			}
		}
	}
	
	//펠린드롬인지 아닌지 판단하는 메서드
	static boolean isPalindrome(String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {//맨앞과 맨뒤부터 비교해서 일치하지 않다면 펠린드롬이 아님
				return false;
			}
		}
		
		return true;//모두다 일치하면 펠린드롬
	}
}
