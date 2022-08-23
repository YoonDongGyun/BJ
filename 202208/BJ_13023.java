import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 23.
@see https://www.acmicpc.net/problem/13023
@performance  18268kb 252ms
@category #dfs
@note */
public class BJ_13023{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Integer>[] relations;
	static int N,M;
	static List<Integer>[] map;
	static boolean decide;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		
		map=new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			map[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(input.readLine());
			
			int n1=Integer.parseInt(tokens.nextToken());
			int n2=Integer.parseInt(tokens.nextToken());
			
			map[n1].add(n2);
			map[n2].add(n1);
		}
		
		for(int i=0;i<N;i++) {
			if(map[i].size()==0) continue;
			if(decide) break;
			dfs(i,new boolean[N],0);			
		}
		if(!decide) output.append(0);
		else output.append(1);
		
		System.out.println(output);
	}
	
	static void dfs(int start, boolean[] visited, int count) {
		if(count==4) {
			decide=true;
			return;
		}
		
		visited[start]=true;
		
		for(int i=0;i<map[start].size();i++) {
			if(!visited[map[start].get(i)]) {
				visited[map[start].get(i)]=true;
				dfs(map[start].get(i),visited,count+1);
				visited[map[start].get(i)]=false;
			}
		}
	}
	
	
}