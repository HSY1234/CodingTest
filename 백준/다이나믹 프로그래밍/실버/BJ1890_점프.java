import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
//	static String str = "4\r\n" + 
//			"2 3 3 1\r\n" + 
//			"1 2 1 3\r\n" + 
//			"1 2 3 1\r\n" + 
//			"3 1 1 0";
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		
		long[][] dp = new long[N][N];
		dp[0][0] = 1L;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int length = map[i][j];
				if(length==0) continue;
				if(j+length<N) dp[i][j+length] += dp[i][j];
				if(i+length<N) dp[i+length][j] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);		
		
		
	}
}