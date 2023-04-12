import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//	static String str = "4 1\r\n" + 
//			"1 -7 4 3";

	static int N;
	static int S;
	static int[] arr;
	static boolean[] isSelected;
	static int counter;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N];
		counter =0;
		
		func2(0,0);
		if(S == 0) counter--;
		System.out.println(counter);
	}
	static void func(int now) {
		if(now == N) {
			int sum = 0;
			int check = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += arr[i];
					check++;
				}
			}
			if(sum == S && check!=0) {
				counter++;
				System.out.println(Arrays.toString(isSelected));
			}
			return;
		}
		
		isSelected[now] = true;
		func(now+1);
		isSelected[now] = false;
		func(now+1);
	}
	static void func2(int now, int sum) {
		if(now == N) {
			if(sum == S) counter++;
			return;
		}
		func2(now+1, sum);
		func2(now+1, sum+arr[now]);
	}

}
