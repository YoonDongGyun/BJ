import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input;
	static StringTokenizer tokens;
	static int idx;
	static String input_str;
	public static void main(String[] args) throws IOException{
		input=new BufferedReader(new InputStreamReader(System.in));
		
		while((input_str=input.readLine())!=null) {
			tokens= new StringTokenizer(input_str);
			
			idx=0;
			
			String s=tokens.nextToken();
			String t=tokens.nextToken();
			
			
			for(int i=0;i<t.length();i++) {
				if(t.charAt(i)==s.charAt(idx)) {
					idx++;
				}
				
				if(idx==s.length()) {
					break;
				}
			}
			
			if(idx==s.length()) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
		
}
