import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_01316 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N;
	static List<String> ch = new ArrayList<>();
	static String[] strs;
	static int count=0, idx=0;
	
	public static void main(String[] args) throws Exception{
		input= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		strs = new String[N];
		
		for(int i=0;i<N;i++) {
			strs[i]=input.readLine();
			
			boolean flag = true;
			ch.clear();
			idx=0;
			
			if(strs[i].length()==0) {
				continue;
			}
			
			for(int j=1;j<strs[i].length();j++) {
				if(strs[i].charAt(j)==' ') continue;
				if(strs[i].charAt(j) != strs[i].charAt(j-1)) {
					ch.add(strs[i].substring(idx,j));
					idx=j;
					
					if(idx==strs[i].length()-1) {
						ch.add(strs[i].substring(idx,strs[i].length()));
					}
				} else {
					if(idx==0 && j==strs[i].length()-1) {
						ch.add(strs[i]);
						idx=j;
					}
				}
			}
			if(idx<strs[i].length()-1) {
				ch.add(strs[i].substring(idx));
			}
			
			if(strs[i].length()==1 || ch.size()==1) {
				count++;
			}
			else {
				outer: for(int c=0;c<ch.size();c++) {
					for(int k=c+1;k<ch.size();k++) {
						if(ch.get(c).charAt(0)==ch.get(k).charAt(0)) {
							flag = false;
							break outer;
						}
						else flag= true;
					}
				}
			
				if(flag) { 
					count++;			
					
				}
			}
		}
		
		System.out.println(count);
	}
}
