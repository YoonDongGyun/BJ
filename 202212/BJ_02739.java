import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_02739 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		
		for(int i=1;i<=9;i++) {
			output.append(String.format("%d * %d = %d%n", N,i,N*i));
		}
		
		System.out.println(output);
	}
}
