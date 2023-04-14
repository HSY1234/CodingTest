import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ9095_123더하기 {

//	static String str = "3\r\n" + 
//			"4\r\n" + 
//			"7\r\n" + 
//			"10";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(in.readLine());
			int [] dp = new int[n+1];
			if(n == 1) {
				System.out.println(1);
				continue;
			}
			if(n == 2) {
				System.out.println(2);
				continue;
			}
			if(n == 3) {
				System.out.println(4);
				continue;
			}
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 3; i < n+1 ; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			System.out.println(dp[n]);
		}
	}

}
