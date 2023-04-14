import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1463_1로만들기 {

//	static String str = "2";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		int x = Integer.parseInt(in.readLine());
		
		int dp[] = new int [x+1];
		dp[1] = 0;
		
		
		for (int i = 2; i < x+1; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i%2==0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
			if(i%3==0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
		}
		System.out.println(dp[x]);
	}

}
