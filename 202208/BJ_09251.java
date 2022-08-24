import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
@author itsme
@since 2022. 8. 24.
@see https://www.acmicpc.net/problem/9251
@performance 15868kb 108ms
@category #LCS #DP
@note 배열을 활용해 문제에 적용하는 연습을 많이 해보자
*/
public class BJ_09251{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String str1,str2;
	static int[][] words;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		str1=input.readLine();//첫번째 문자열
		str2=input.readLine();//두번째 문자열
		
		words=new int[str1.length()+1][str2.length()+1];//각 단어들을 비교하여 LCS 길이를 저장해주는 배열
		
		dp();//문자열 비교 적용
		
		output.append(words[str1.length()][str2.length()]);//words에 있는 가장 마지막 배열 값 append
		
		System.out.println(output);//결과값 출력
	}
	
	static void dp() {
		//0번째 열, 0번째 행은 이전값 더해주는 것을 편하게 하기 위해 0으로 둔다(공집합 역할)
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {//문자열을 비교했는데 서로 같다면
					words[i][j]=words[i-1][j-1]+1;//왼쪽 위 대각선에 있는 값에 1을 더해주면 된다
				}
				else {//서로 같지 않다면
					words[i][j]=Math.max(words[i][j-1], words[i-1][j]);//이전 열의 값과 이전 행의 값 중에서 큰 값을 넣어준다.
				}
			}
		}
	}
	
}