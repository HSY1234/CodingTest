import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {

//	static String str = "1\r\n" + 
//			"1 2 100\r\n";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int [][] cost = new int [N+1][3];
		int [][] dp = new int [N+1][3];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(in.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
	
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for (int i = 2; i < N+1; i++) {
			dp[i][0] = cost[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = cost[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = cost[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]));
	}

}
