import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6549_히스토그램에서가장큰직사각형 {

//	static String str =  
//			"7 2 1 4 5 1 3 3\r\n" + 
//			"4 1000 1000 1000 1000\r\n" + 
//			"1 7\r\n" + 
//			"0";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n!=0) {
			long [] h = new long[n];
			for (int i = 0; i < n; i++) {
				h[i] = Long.parseLong(st.nextToken()); 
			}
			
			Stack<Long> s = new Stack<>();// 높이 저장용
			Stack<Long> sIndex = new Stack<>();// 해당 기둥 좌표 저장용 
			
			long maxArea = 0;
			
			for (int i = 0; i < n; i++) {
				long idx = i;
				while(!s.isEmpty()&&s.peek()>=h[i]) {
					maxArea = Math.max(maxArea, s.peek()*(i-sIndex.peek()));
					idx = sIndex.peek();
					s.pop();
					sIndex.pop();
				}
				s.push(h[i]);
				sIndex.push(idx);
			}
			
			while(!s.isEmpty()) {
				maxArea = Math.max(maxArea, s.peek()*(n-sIndex.peek()));
				s.pop();
				sIndex.pop();
			}
			
			sb.append(maxArea).append('\n');
			
			// 다음 테스트 케이스
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
	}

}
