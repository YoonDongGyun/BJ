import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class BJ_09012 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
 
		int T = Integer.parseInt(input.readLine());
 
		while (T-- > 0) {
			output.append(solve(input.readLine())).append('\n');
		}
		System.out.println(output);
 
	}
 
	public static String solve(String s) {
 
		int count = 0;
 
		for (char c : s.toCharArray()) {
 
			// 여는 괄호일 경우 카운트 증가
			if (c == '(') {
				count++;
			}
 
			// 아래는 모두 닫는 괄호 일 경우들이다.
 
			// count 가 0인 경우. 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
			else if (count == 0) {
				return "NO";
			}
			// 그 외의 경우 count를 감소시킨다.
			else {
				count--;
			}
		}
 
		/*
		 * 모든 검사 마치고 잔여 요소가 있으면(count > 0) 여는 괄호가 많은 경우는 "NO" 
		 * 요소가 비어있으면(count = 0) 온전한 수식이므로 "YES" 이다.
		 */
 
		if (count == 0) {
			return "YES";
		} 
		else {
			return "NO";
		}
	}
}