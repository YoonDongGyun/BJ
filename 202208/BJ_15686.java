package off0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 12.
@see
@performance
@category #
@note */
public class BJ_15686 {

	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,cityDistance=Integer.MAX_VALUE;
	static int[][] map;
	static List<Point> homeIndex= new ArrayList<>();
	static List<Point> chickenIndex = new ArrayList<>();
	
	public static class Point{
		int x;
		int y;
		
		private Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d) ",x,y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		tokens=new StringTokenizer(input.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(input.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
				if(map[r][c]==1) {
					homeIndex.add(new Point(r,c));
				}
				else if (map[r][c]==2) {
					chickenIndex.add(new Point(r,c));
				}
			}
		}
		
		if(M==chickenIndex.size()) {
			cityDistance=getMinDistance();
		}
		
		else {
			makeCombination(0, new int[M][2], 0);
		}
		
		System.out.println(cityDistance);
		
	}
	static int getMinDistance() {
		int sum=0;
		
		for(int i=0;i<homeIndex.size();i++) {
			int min=Integer.MAX_VALUE;			
			for(int j=0;j<chickenIndex.size();j++) {
				min=Math.min(min, getDistance(homeIndex.get(i).x,homeIndex.get(i).y,chickenIndex.get(j).x,chickenIndex.get(j).y));
			}
			sum+=min;
		}
		
		return sum;
	}
	static int getMinDistance(int[][] choosed) {
		int sum=0;
		
		for(int i=0;i<homeIndex.size();i++) {
			int min=Integer.MAX_VALUE;			
			for(int j=0;j<choosed.length;j++) {
				min=Math.min(min, getDistance(homeIndex.get(i).x,homeIndex.get(i).y,choosed[j][0],choosed[j][1]));
			}
			sum+=min;
		}
		
		return sum;
	}
	static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	
	static void makeCombination(int nth, int[][] choosed, int startIdx) {
        if (nth == M) {
            cityDistance = Math.min(cityDistance, getMinDistance(choosed));
            return;
        }

        for (int i = startIdx; i < chickenIndex.size(); i++) {
            choosed[nth][0] = chickenIndex.get(i).x;
            choosed[nth][1] = chickenIndex.get(i).y;
            // 중복 방지를 위한 장치: i+1
            makeCombination(nth + 1, choosed, i + 1);
        }
    }
}
