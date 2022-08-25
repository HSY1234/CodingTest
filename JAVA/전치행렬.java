
public class 전치행렬 {
	public static void main(String[] args) {
		int[][] arr= new int[3][3] ;
		
		int count = 1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = count++;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i<j) {
					swap(arr,i,j);
				}
			}
			
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void swap(int [][] arr ,int i, int j) {
		int temp = arr[i][j];
		arr[i][j]=arr[j][i];
		arr[j][i]=temp;
	}
}
