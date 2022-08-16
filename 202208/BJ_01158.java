
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 8.
@see https://www.acmicpc.net/problem/1158
@performance 20968KB 272ms
@category #
@note 큐를 활용해서 적용하는 방법 추가로 고민해보자
*/
public class BJ_01158{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K;
	static List<Integer> nums= new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());

		
		for(int i=0;i<N;i++) {
			nums.add(i+1);
		}
		int point=-1;
		
		output.append("<");
		
		while(true) {
			point+=K;
			while(point>=nums.size()) {
				point-=nums.size();
			}
			
			if(nums.size()==1) {
				output.append(nums.get(0));
				break;
			}
			else {
				output.append(String.format("%d, ", nums.get(point)));
				nums.remove(point);
				point--;
			}
		}
		output.append(">");
		
		System.out.println(output);
	}
	
}
