import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ11726_2n타일링 {

	static String str = "1000";

	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < N+1; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			if(dp[i]>=10007) dp[i] %=10007; 
		}
		
		System.out.println(dp[N]);
	}

}
