import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//	static String str = "5\r\n" + 
//			"2 3 1 6 5 4\r\n" + 
//			"3 1 2 4 6 5\r\n" + 
//			"5 6 4 1 3 2\r\n" + 
//			"1 3 6 2 4 5\r\n" + 
//			"4 1 6 5 2 3";
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		int [][] dice = new int[n][6];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		for (int first = 0; first < 6; first++) {
			int max = 0;
			int start = first;
			for (int i = 0; i < n-1; i++) {
				max += getMax(start,dice[i]);
				start = findIndex(dice[i][up(start)],dice[i+1]);
			}
			max+= getMax(start,dice[n-1]);
			if(max>result) result= max;
			
		}
		
		System.out.println(result);
		
		
		
	}
	
	static int up(int down) {
		if(down==0) return 5;
		if(down==1) return 3;
		if(down==2) return 4;
		if(down==3) return 1;
		if(down==4) return 2;
		if(down==5) return 0;		
		return -1;
	}
	
	static int getMax(int down, int[] dice) {
		int up = up(down);
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if(i==down||i==up) {
				continue;
			}
			if(dice[i]>max) {
				max= dice[i];
			}
		}
		return max;
	}
	
	static int findIndex(int num, int[] dice) {
		for (int i = 0; i < 6; i++) {
			if(dice[i]==num) return i;
		}
		return -1;
	}
}