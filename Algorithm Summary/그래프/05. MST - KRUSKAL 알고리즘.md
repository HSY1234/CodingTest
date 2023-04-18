# KRUSKAL 알고리즘

- MST 구하는 알고리즘
- Greedy 알고리즘

## 간선을 하나씩 선택해서 MST를 찾는 알고리즘

1. 모든 간선을 가중치에 따라 오름차순으로 정렬
2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 만들어간다.(사이클 생성될 경우 다음으로 가중치가 낮은 간선 선택)
3. n-1개가 선택될때까지 2번 반복

## 어떤 방식이 좋을까?

- 간선 위주로 풀어가는 알고리즘
  - 간선 리스트가 최적
- 사이클 구분 여부?
  - 같은 그룹에 속하는지 체크 => 서로소 집합

## 수도 코드

```
KRUSKAL(G,w)
  FOR vertex v in G.V
    Make-Set(v)

  간선 기준으로 가중치 w를 이용한 오름차순 정렬

  FOR 가중치가 가장 낮은 간선 (u,v) 선택 n-1개가 될때까지
    IF Find-Set(u) != Find-Set(v)
      Union(u,v)
```

## 구현

```java
public class Kruskal {
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

  // Disjoint-Set
	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;

		parents[bRoot] = aRoot;
		return true;

	}

	static int N;
	static int[] parents;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {

		int E ;
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to,weight);
		}

		Arrays.sort(edgeList);
		makeSet();

		int result =0,cnt=0;
		for (Edge edge : edgeList){
			if(union(edge.from,edge.to)) {
				result+= edge.weight;
				if(++cnt == N-1) break;
			}
		}
		System.out.println(result);
	}


}
```
