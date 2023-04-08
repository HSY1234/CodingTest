# Arrays

## Arrays 출력

```java
int [] arr1 = {1,2,3,4};
int [][] arr2 = {{1,2},{3,4}};

// 배열 출력
System.out.println(Arrays.toString(arr1));

// 2차원 배열 출력
System.out.println(Arrays.deepToString(arr2));

```

## Arrays 채우기

java는 선언시 int 배열 전부 0으로 초기화

boolean 배열은 false

```java
int [] arr1 = new int[2];
int [][] arr2 = new int[2][2];

// 배열 채우기
Arrays.fill(arr1, -1) // -1로 다 채우기

// 2차원 배열 채우기
for(int i =0; i<2; i++){
  Arrayts.fill(arr2[i],-1);
}

```
