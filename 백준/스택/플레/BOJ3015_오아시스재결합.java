import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ3015_오아시스재결합 {

//	static String str = "7\r\n" + 
//			"3\r\n" + 
//			"3\r\n" + 
//			"3\r\n" + 
//			"3\r\n" + 
//			"3\r\n" + 
//			"3\r\n" + 
//			"3";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> s = new Stack<>();
		Stack<Integer> c = new Stack<>();
		
		long answer = 0;

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			while(!s.isEmpty()&&s.peek()<height) {
				answer+=c.peek();
				s.pop();
				c.pop();
			}
			
			if(s.isEmpty()) {// 빈 경우
				s.push(height);
				c.push(1);
			}
			else if(s.peek() == height) { // 같은 경우
				int count =c.peek();
				answer+=count;
				c.pop();
				if(c.isEmpty()) answer--;// 스택에 남은게 같은 키 사람밖에 없는 경우
				c.push(count+1);
				answer++;// 남아있는 사람과 서로 볼수있다
			}
			else{// 비어있지 않고 같지 않은 경우
				s.push(height);
				c.push(1);
				answer++;
			}
			
		}
		
		System.out.println(answer);
	}

}
