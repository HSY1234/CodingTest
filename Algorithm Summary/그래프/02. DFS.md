# DFS(Depth First Search)

시작 정점의 한 방향으로 갈수 있는 경로가 있는곳 까지 깊이 탐색해 가다가 더 이상 갈 곳이 없게 되면, 마지막에 만났던 갈림길 간선이 있는 정점으로 되돌아와서 다른 방향의 정점으로 탐색을 계속 반복하여 모든 정점을 순회

최근 정점으로 다시 가기 때문에 재귀적 구현 or Stack

```
재귀로 구현!
DFS(V)
  visited[V] <- true

  For 모든 각 w in adjacency(G,v)
    IF visited[w] != true
      DFS(w)
```

모든 노드 방문이 목적이니까 visited 초기화 X, visited 초기화 하는 경우는 백트래킹을 위해 DFS를 쓸때이다.

## 인접 행렬

```java

	public static void dfs(int[][] adjMatrix,boolean[] visited,int current) {
		visited[current] = true;
		System.out.println(current);

		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (int j = 0; j < N; j++) {
			if(!visited[j]&& adjMatrix[current][j]!=0) {
				dfs(adjMatrix, visited,j);
			}
		}

	}
```

## 인접 리스트

```java
  public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {// 이미 인접리스트끼리는 인접이니까 추가 확인 X
				dfs(adjList,visited,temp.vertex);
			}

		}

	}

```
