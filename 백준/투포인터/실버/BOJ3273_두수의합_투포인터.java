import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//	static String str = "1\r\n" + 
//			"1\r\n" + 
//			"2000000";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(in.readLine());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		int result = 0;
		
		while(left < right) {
			int sum = arr[left]+ arr[right];
			if(sum>x) {
				right--;
			}
			else if(sum < x) {
				left++;
			}
			else {
				left++;
				right--;
				result++;
			}
		}
		
		System.out.println(result);
	}

}
