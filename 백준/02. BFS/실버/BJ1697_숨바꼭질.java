import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static String str = "5 17";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visited[N] = true;
		int time = 0;
		if(N==K) {
			System.out.println(0); 
			return;
		}
		while(!q.isEmpty()) {
			time++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int x = q.poll();
			
				if(x-1>=0 && !visited[x-1]) {
					if(x-1==K) {
						System.out.println(time);
						return;
					}
					visited[x-1] = true;
					q.offer(x-1);
				}
				if(x+1<=100000 && !visited[x+1]) {
					if(x+1==K) {
						System.out.println(time);
						return;
					}
					visited[x+1] = true;
					q.offer(x+1);
				}
				
				if(2*x<=100000 && !visited[2*x]) {
					if(2*x==K) {
						System.out.println(time);
						return;
					}
					visited[2*x] = true;
					q.offer(2*x);
				}
			}
		}
		
	}

}
