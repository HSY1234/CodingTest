# BFS(Breadth First Search)

너비 우선탐색은 탐색 시작점(트리는 루트노드, 그래프는 따로 없다) 인접한 정점들을 모두 차례로 방문후 방문했던 정점을 시작점으로 하여 다시 인접한 정점들을 차례대로 방문한다.

큐로 구현하는것이 일반적

```
BFS(G,V) 그래프 G, 시작정점 V
  큐 생성
  시작 정점 V를 큐에 삽입
  V를 방문한것으로 표시
  while(큐가 비어 있지 않은 경우){
    t <- 큐의 첫 번째 원소 반환
    for(t와 연결된 모든 간선에 대해){
      u <- t의 인접 정점
      u가 방문되지 않은곳이라면,
      u를 큐에 넣고, 방문한 것으로 표시
    }
  }

```

## 방문처리는 큐에 넣을때 해야하나? 큐에서 나올때 해야하나?

반드시 **큐에 넣을때** 해야한다!!!!  
뺄때 방문처리가 직관적이지만, BFS 주변 탐색시 뺄때 방문처리면 큐에 있는 녀석이 방문처리 되지 않고 false이기 때문에 중복해서 queue에 넣게 된다!  
따라서 직관적이지 않아도 넣고 방문처리를 해주는게 논리적으로 옳다!

## 인접 행렬

```java
public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);

			for (int j = 0; j < N; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0) {
					queue.offer(j);
					visited[j]=true;
				}
			}
		}
}
```

## 인접 리스트

```java


public static void bfs2(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {// 이미 인접리스트끼리는 인접이니까 추가 확인 X
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}

			}

		}
}

'''
```
