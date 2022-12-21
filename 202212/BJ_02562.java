import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_02562 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int[] nums = new int[9];
		int max = Integer.MIN_VALUE;
		int position = -1;
		
		for(int i=0;i<9;i++) {
			nums[i]=Integer.parseInt(input.readLine());
			
			if(nums[i]>max) {
				max = nums[i];
				position= i+1;
			}
		}
		
		output.append(String.format("%d%n%d", max,position));
		System.out.println(output);
	}
}
