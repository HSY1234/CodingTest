import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2579_계단오르기_DP2 {

//	static String str = "6\r\n" + 
//			"10\r\n" + 
//			"20\r\n" + 
//			"15\r\n" + 
//			"25\r\n" + 
//			"10\r\n" + 
//			"20";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int [N+1][3];
		int arr[ ] = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		if(N==1) {
			System.out.println(arr[1]);
			return;
		}
		if(N==2) {
			System.out.println(arr[1]+arr[2]);
			return;
		}
		
		
		dp[0][1] = 0;
		dp[0][2] = 0;
		dp[1][1] = arr[1];
		dp[1][2] = 0;
		dp[2][1] = dp[1][1]+arr[2];
		dp[2][2] = arr[2];
		
		
		for (int i = 3; i < N+1; i++) {
			dp[i][2] = arr[i] + Math.max(dp[i-2][1], dp[i-2][2]);
			dp[i][1] = arr[i] + dp[i-1][2];
		}
		
		System.out.println(Math.max(dp[N][1],dp[N][2]));
		
	}

}
