import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2579_계단오르기 {

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
		int[] dp = new int [N+1];
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
		if(N==3) {
			
			System.out.println();
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		
		for (int i = 4; i < N+1; i++) {
			dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3]+arr[i-1]);
		}
		
		System.out.println(dp[N]);
		
	}

}
