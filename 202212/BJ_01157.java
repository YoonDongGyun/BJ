import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_01157 {
	
	static BufferedReader input;
	static StringBuilder output= new StringBuilder();
	static String word;
	static int[] freq = new int['z'-'a'+1];
	static int max = Integer.MIN_VALUE, temp=0;
	static char alpha;
	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		word = input.readLine().trim();
		int change = Math.abs('A' - 'a');
		
		if(word.length()==1) {
			if(word.charAt(0)>='A' && word.charAt(0)<='Z') {
				output.append(word.charAt(0));
			}
			else {
				output.append((char) (word.charAt(0)-change));
			}
		}
		
		else {
			for(int i=0;i<word.length();i++) {
				if(word.charAt(i)>='A' && word.charAt(i)<='Z') {
					freq[word.charAt(i)-'A']++;
				}
				else {
					freq[word.charAt(i)-'a']++;
				}
			}
			
			for(int i=0;i<freq.length;i++) {
				if(freq[i]>max) {
					max=freq[i];
					alpha = (char) (i + 'A');
				}
				else if(freq[i]==max) {
					alpha= '?';
				}
			}
			output.append(alpha);
		}
		
		System.out.println(output);
	}
}
