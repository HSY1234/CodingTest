import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ10157_자리배정 {
	
//	static String str = "";
	
	static int[] dx = {-1,0,1,0};//상우하좌
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		
		int[][] map = new int[R][C];
		
		int startX = R-1;
		int startY = 0;
		int Max = R*C;
		int d = 0;
		int x = startX;
		int y = startY;
		int counter = 1;
		boolean stop = false;
	
		if(K>Max) {
			stop = true;
			sb.append(0);
		}
		
		while(!stop) {
			map[x][y] = counter;
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(counter == K) {
				stop = true;
				sb.append(y+1).append(" ").append(R-x);
				break;
			}
			
			if(nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]==0) {
				x= nx;
				y =ny;
				counter++;
			}
			else {
				d++;
				d%=4;
			}
			
		}

		System.out.println(sb);
	}
}
