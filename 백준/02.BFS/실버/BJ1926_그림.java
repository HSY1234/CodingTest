import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	static String str = "6 5\r\n" + 
//			"1 1 0 1 1\r\n" + 
//			"0 1 1 0 0\r\n" + 
//			"0 0 0 0 0\r\n" + 
//			"1 0 1 1 1\r\n" + 
//			"0 0 1 1 1\r\n" + 
//			"0 0 1 1 1";

	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		boolean [][] visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		
		int count = 0;
		int max = 0;
		int size = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0 || visited[i][j]) continue;// 시작지점이 색칠X or 방문한적 있다면 다음으로 
				
				count++;
				visited[i][j] = true;
				queue.offer(new Point(i, j));
				size = 1;
				while(!queue.isEmpty()) {
					Point p = queue.poll();
					
					int x = p.x;
					int y = p.y;
					
					for (int k = 0; k < 4; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						if(nx<0||nx>=n||ny<0||ny>=m) continue;// 범위 밖이거나, 방문했다면 다음으로
						if(visited[nx][ny]||arr[nx][ny]==0) continue;
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						size++;
					}
				}
				if(size>max) max = size;
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}

}

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x =x;
		this.y =y;
	}
}

