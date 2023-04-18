# PRIM 알고리즘

- MST 알고리즘
- Greedy 알고리즘

## 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 찾는 알고리즘

1. 임의의 정점에서 시작(아무거나 선택 가능)
2. 선택한 정점과 인접하는 정점중에 최소 비용의 간선이 존재하는 정점을 선택
3. 모든 정점이 선택될때까지 1,2 반복

## 어떤 방식이 좋을까?

- 정점위주로 풀어가는 알고리즘
  - 인접 배열 or 인접 리스트
- 서로소인 disjoint-set 2개 유지
  - MST로 선택된 정점들 집합
  - MST에 아직 선택되지 않은 정점들 집합

## 수도 코드

```
PRIM(G,r)// r: 시작 정점, minEdge[]: 정점 기준으로 타 정점과의 최소 간선 비용
  result =0, cnt=0 //cnt: 처리한 정점수, visited[]: MST에 포함된 정점 여부
  FOR u in V
    minEdge[u] = 무한// 일단 모든 거리 무한으로 초기화
  minEdge[r]=0
  WHILE true
    u <= Extract-MIN() // 방문처리 안된곳에서 최소비용 정점
    visited[u] = true
    result = result+minEdge[u]
    if(++cnt == N) break;
    For v in u의 인접정점
      IF visited[v] == false AND w(u,v) < minEdge[v] // 방문안되고, 최소비용이 더 적다면
        minEdge[v] = u(u,v) // 업데이트
  return result
end PRIM
```

## 구현방식

Priority Queue를 쓰는게 편하다! => 그냥 업데이트시 넣어주고, 꺼낼때 visited체크!(이미 방문했다면 버리고 새로 꺼내기)

## 그냥 구현

```java
public class Prim {
	public static void main(String[] args) throws IOException {
		int N;
		StringTokenizer st = null;
		int[][] adjMatrix = new int[N][N];

		int[] minEdge = new int[N];//타정점에서 자신으로의 간선비용중 최소비용
		boolean[] visited = new boolean[N];// 신장트리의 선택된 여부

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result =0;// MST 비용
		minEdge[0] =0;

		for (int c = 0; c < N; c++) {// N개의 정점을 모두 연결
			//신장 트리에 연결되지 않은 정점중 가장 유리한 비용의 정점을 선택

			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {// 모든 for문 돌려서 신장트리에 포함 안된 노드는 모든 신장트리 포함노드와 거리 비교해서 최솟값
				if(!visited[i] && min >minEdge[i] ) {// 이부분을 우선순위 큐로 바꿀수 있다
					min = minEdge[i];
					minVertex = i;
				}
			}

			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;

			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
			for(int i=0;i<N;i++) {
				if(!visited[i]&& adjMatrix[minVertex][i]!=0&&minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}

			System.out.println(result);
		}
	}
}
```

## 우선순위 큐

```java
public class Prim_PQ {
	public static void main(String[] args) throws IOException {
		int N;
		StringTokenizer st = null;
		int[][] adjMatrix = new int[N][N];

		int[] minEdge = new int[N];//타정점에서 자신으로의 간선비용중 최소비용
		boolean[] visited = new boolean[N];// 신장트리의 선택된 여부

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result =0;// MST 비용
		minEdge[0] =0;

		for (int c = 0; c < N; c++) {// N개의 정점을 모두 연결
			//신장 트리에 연결되지 않은 정점중 가장 유리한 비용의 정점을 선택

			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {// 모든 for문 돌려서 신장트리에 포함 안된 노드는 모든 신장트리 포함노드와 거리 비교해서 최솟값
				if(!visited[i] && min >minEdge[i] ) {// 이부분을 우선순위 큐로 바꾸면 됩니다!
					min = minEdge[i];
					minVertex = i;
				}
			}

			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;

			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
			for(int i=0;i<N;i++) {
				if(!visited[i]&& adjMatrix[minVertex][i]!=0&&minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}

			System.out.println(result);
		}
	}
}

```
