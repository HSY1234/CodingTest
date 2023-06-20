import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BOJ1707_이분그래프 {
	
//	static String str = "2\r\n" + 
//			"3 2\r\n" + 
//			"1 3\r\n" + 
//			"2 3\r\n" + 
//			"4 4\r\n" + 
//			"1 2\r\n" + 
//			"2 3\r\n" + 
//			"3 4\r\n" + 
//			"4 2";
	
	public static void main(String[] args)	throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		
		int K = Integer.parseInt(in.readLine());
	
		for (int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
		
			ArrayList<Integer> [] vlist = new ArrayList[V+1];
			for (int i = 0; i < V+1; i++) {
				vlist[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vlist[a].add(b);
				vlist[b].add(a);
			}
			
			Queue<Integer> q = new LinkedList<>();
			int[] group = new int[V+1];
			boolean result = true;
			for (int i = 1; i < V+1; i++) {
				if(group[i]!= 0) continue;
				group[i] = 1;
				q.add(i);
				while(!q.isEmpty()) {
					int temp = q.poll();
					for(int next : vlist[temp]) {
						if(group[next] == group[temp]) {
							result = false;
							break;
						}
						else if(group[next] != 0) {
							continue;
						}
						group[next] = 3 - group[temp];
						q.offer(next);
					}
					if(!result) break;
				}
				if(!result) break;
			}
			if(!result) System.out.println("NO");
			else System.out.println("YES");
			
		}
		
		
		
	}
}
	