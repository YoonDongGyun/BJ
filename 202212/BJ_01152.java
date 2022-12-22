import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_01152 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String line = input.readLine();
		int num=0;
		boolean flag= false;
		
		for(int i=0;i<line.length();i++) {
			if(!flag) {
				if(line.charAt(i)!=' ') {
					num++;
					flag=true;
					continue;
				}
			}
			else {
				if(line.charAt(i)==' ') {
					flag=false;
				}
			}
		}
		
		System.out.println(num);
	}
}
