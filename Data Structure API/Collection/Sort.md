1. Arrays.sort()

- 배열 정렬의 경우
- Ex) byte[], char[], double[], int[], Object[], T[] 등 \* Object Array에서는 TimSort(Merge Sort + Insertion Sort)를 사용
- Object Array: 새로 정의한 클래스에 대한 배열 \* Primitive Array에서는 Dual Pivot QuickSort(Quick Sort + Insertion Sort)를 사용
- Primitive Array: 기본 자료형에 대한 배열

2. Collections.sort()

- List Collection 정렬의 경우
- Ex) ArrayList, LinkedList, Vector 등 \* 내부적으로 Arrays.sort()를 사용
