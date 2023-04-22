import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		int [] counter = new int[2000001];
		
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			counter[arr[i]]++;
		}
		
		int x = Integer.parseInt(in.readLine());
		
		int result = 0;
		
		if(x%2==0) {
		
			for (int i = 1; i < x/2; i++) {
				if(counter[i]==1 && counter[x-i]==1) {
					result ++;
				}
			}
		}
		else {
			for (int i = 1; i <= x/2; i++) {
				if(counter[i]==1 && counter[x-i]==1) {
					result ++;
				}
			}
		}
		
		System.out.println(result);
	}

}
