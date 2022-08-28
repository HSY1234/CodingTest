# Priority Queue

- 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조 (큐에 들어가는 원소는 비교가 가능한 기준이 있어야함)
- 내부 요소는 Heap으로 구성되어 이진트리 구조로 이루어져 있음
- 내부구조가 Heap으로 구성되어 있기에 시간 복잡도는 O(NLogN)

## 선언

```java
import java.util.PriorityQueue;
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 작은수가 우선순위가 높음
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 큰수가 우선순위가 높게
```

## 추가

```java
Queue<Integer> priorityQueue = new PriorityQueue<>();
queue.add(1);
queue.offer(3);
```

- add는 문제 발생시 예외 발생
- offer는 문제 발생시 false 반환

## 삭제

```java
queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
queue.remove();     // queue에 첫번째 값 제거
queue.clear();  // 초기화
```

- poll 비었을시 null
- remove는 에러 발생

## 조회

```java
queue.peek();
```

## 기타

```java
queue.size();      // queue의 크기 출력
queue.isEmpty();     // queue 비어있는지
```
