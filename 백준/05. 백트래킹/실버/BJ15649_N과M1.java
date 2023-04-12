import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "4 4";
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[M];
		boolean[] isSelected = new boolean[N+1];
		
		func(N,M, 0, arr, isSelected);
		System.out.println(sb);
	}
	
	static void func(int N, int M, int now, int[] arr, boolean[] isSelected) {
		if(now == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			arr[now] = i;
			func(N, M, now+1, arr, isSelected);
			isSelected[i] = false;
		}
	}

}
