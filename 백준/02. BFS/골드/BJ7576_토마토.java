import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	static String str = "2 2\r\n" + 
//			"1 1\r\n" + 
//			"1 1";

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][]  box = new int[N][M];
		
		int tomato = 0;
		Queue<int []> q = new LinkedList<>();
		int time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int t = Integer.parseInt(st.nextToken());
				box[i][j] = t;
				if(t==0) tomato++;
				if(t==1) {
					q.offer(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();

			time++;
			for (int i = 0; i < size; i++) {
				
				int [] now = q.poll();
				int x = now[0];
				int y = now[1];
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = x+ dx[dir];
					int ny = y+ dy[dir];
					
					if(nx>=N || nx<0 || ny>=M || ny<0) continue;
//					System.out.println(nx+" "+ny);
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						q.offer(new int[]{nx,ny});
						tomato--;
						
					}
				}
			}
			
		}
		if(tomato != 0) System.out.println(-1);
		else System.out.println(time-1);
		
		
		
		
 	}

}

