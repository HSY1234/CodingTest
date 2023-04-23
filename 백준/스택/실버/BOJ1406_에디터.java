import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

//	static String str1 = "abcd\r\n" + 
//			"3\r\n" + 
//			"P x\r\n" + 
//			"L\r\n" + 
//			"P y";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str1));

		String str = in.readLine();
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			String cmd = in.readLine();
			switch (cmd.charAt(0)) {
			case 'L':
				if (leftStack.empty())
					break;
				rightStack.push(leftStack.pop());
				break;
			case 'D':
				if (rightStack.empty())
					break;
				leftStack.push(rightStack.pop());
				break;
			case 'B':
				if (leftStack.empty())
					break;
				leftStack.pop();
				break;
			case 'P':
				leftStack.push(cmd.charAt(2));
				break;
			}
		}
		while (!leftStack.empty()) {
			rightStack.push(leftStack.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!rightStack.empty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb.toString());

	}

}
