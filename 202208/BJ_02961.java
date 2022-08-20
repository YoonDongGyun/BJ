import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 9.
@see
@performance 11528KB 76ms
@category #부분집합
@note 부분집합의 경우 아무것도 뽑지 않는 경우의 수도 포함되어 있음 (경우의 수 파악할 때 이부분 생각하자) 
*/
public class BJ_02961{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,min=Integer.MAX_VALUE;
	static int[][] flavor;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		flavor=new int[N][2];
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(input.readLine());
			flavor[i][0]=Integer.parseInt(tokens.nextToken());
			flavor[i][1]=Integer.parseInt(tokens.nextToken());
		}
		
		if(N==1) {
			output.append(Math.abs(flavor[0][1]-flavor[0][0]));
		}
		else {
			makePowerSet(0,new boolean[N]);
			output.append(min);
		}
		System.out.println(output);
	}
	static void makePowerSet(int toCheck, boolean[] checked) {
		if(toCheck==checked.length) {
			int count=0;
			int sour=1,bitter=0;
			
			for(int i=0;i<N;i++) {
				if(checked[i]) {
					sour*=flavor[i][0];
					bitter+=flavor[i][1];
				}
				else count++;
			}
			
			if(count!=N) {
				min=Math.min(min, Math.abs(sour-bitter));
			}
			return;	
		}
		
		checked[toCheck]=true;
		makePowerSet(toCheck+1,checked);
		checked[toCheck]=false;
		makePowerSet(toCheck+1,checked);
	}
}